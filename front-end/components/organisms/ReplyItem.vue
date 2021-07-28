<template>
  <div>
    <div class='nameWrapper'>
      <input v-model="nextName" :readonly='!modifying' class='nameInput'>
    </div>
    <div class='contentWrapper'>
      <input v-model="nextContent" :readonly='!modifying' class='contentInput'>
    </div>


    <span class='replyDate'>
      {{ reply.rdate }}
    </span>
    <div>
      <button v-show='!modifying' class='btn' @click='deleteReply(reply.rid)'>삭제</button>
      <button v-show='!modifying' class='btn' @click='changeModifying'>수정</button>
      <button v-show='modifying' class='btn' @click='registModify'>수정완료</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'ReplyItem',
  props   : {
    reply: Object,
  },
  data() {
    return {
      modifying : false,
      nextName : this.reply.rname,
      nextContent : this.reply.rcontent,
    }
  },
  computed: {

  },
  methods: {
    // eslint-disable-next-line camelcase
    async deleteReply(rid) {
      // eslint-disable-next-line camelcase
      return await axios.delete(`http://localhost:8080/board/comments/${rid}`)
        .then(res => {
          this.$emit('reloadReplyList');
        })
        .catch(e => {
          console.error(e);
        });
    },
    changeModifying() {
      this.modifying = !this.modifying;
    },
    async registModify() {
      await axios.put('http://localhost:8080/board/comments/' + this.reply.bid, {
        rid : this.reply.rid,
        rname : this.nextName,
        rcontent : this.nextContent,
      }).then(res => {
        this.$router.push("/board/" + this.reply.bid);
        this.changeModifying();
      }).catch(e => {
      });

      return false
    }
  }
}
</script>

<style scoped>


input:read-only{
  cursor: default;
  border: none;
}

.btn {
  background-color: white;
  border: 2px solid #000099; /* Green */
  border-radius: 12px;
  color: black;
  font-size: 0.8em;
  padding: 0.45em 0.8em;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  margin: 0px 0.3rem;
}

.nameInput {
  font-weight: bold;
}

.replyDate {
  font-size: 0.7em;

}


</style>
