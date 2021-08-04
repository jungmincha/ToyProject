<template>
  <div class='componentRoot'>
    <h3 class='title'>
      {{ isBoardDetail.btitle }}
    </h3>

    <div class='writerArea'>
      <div class='profileArea'>

        <div class='writer'>
          {{ isBoardDetail.bname}}
        </div>

        <div class='articleInfo'>
          <div class='date'>
            {{ isBoardDetail.bdate}}
          </div>
          <div class='count'>
            조회수 {{ isBoardDetail.bhit }}
          </div>
        </div>
      </div>


      <div class='reply'>
        댓글수
      </div>
    </div>



    <hr>

    <div class="contentReader">
      {{ isBoardDetail.bcontent }}
    </div>


    <hr>

    <h3>댓글</h3>
    <div class='replyInputContainer'>
      <input v-model='newReplyName' class='replyWriterInput'>
      <textarea v-model='newReplyContent' class='replyContentTextArea'></textarea>
    </div>
    <button class='btn' @click='registNewReply'> 등록 </button>

    <ul>
      <li v-for="reply in replyList" :key="reply.rid">
        <ReplyItem :reply='reply' @reloadReplyList="reloadReplyList"></ReplyItem>
      </li>
    </ul>


    <div class='articleBottomBtn'>
      <div class='contentRelated'>
        <button class='btn' @click='boardUpdate'>
          수정
        </button>
        <button class='btn' @click='deleteBoard'>
          삭제
        </button>
      </div>
      <div class='contentNoRelated'>
        <button class='btn'>
          목록
        </button>
        <button class='btn'>
          TOP
        </button>
      </div>
    </div>

  </div>
</template>

<script>
import axios from "axios";
import ReplyItem from '~/components/organisms/ReplyItem'

export default {
  components: {ReplyItem},
  async asyncData({params}) {

    const {data : isBoardDetail} = await axios.get(`http://localhost:8080/board/${params.bid}`)
    .then(res => {
   
      console.log(res.data);

      return res.data;
    })
    .catch(e => {
      console.error(e);
    });

    const replyList = await axios.get(`http://localhost:8080/board/comments/${params.bid}`)
    .then(res => {
      
      console.log("그냥 replyList");
      console.log(res.data);
   
      return res.data;
    });


    return { isBoardDetail, replyList };
  },

  data() {
    return {
      newReplyName : "",
      newReplyContent: "",
      replyList : {}
      
    }
  },

  methods: {
    boardUpdate() {
      console.log("boardUpdate");
      console.log(this.isBoardDetail.bid);
      console.log("/board/modifyForm/" + this.isBoardDetail.bid);

      return this.$router.push("/board/modifyForm/" + this.isBoardDetail.bid);
    },
 
    async deleteBoard(){
      return await axios.delete(`http://localhost:8080/board/${this.isBoardDetail.bid}`)
      .then(res => {
        this.$router.push("/board");
      })
      .catch(e => {
        console.error(e);
      });
    },
    async registNewReply() {
      await axios.post(`http://localhost:8080/board/comments/${this.isBoardDetail.bid}`, {
        rname : this.newReplyName,
        rcontent : this.newReplyContent
      }).then(res => {
       
        this.newReplyName = ""; 
        // input box의 글자를 초기화 시켜준다
        this.newReplyContent = "";


       
     //   console.log(this.newReplyName);
      //  this.$router.push("/board/" + this.boardDetail.bid);
      
      })
      .catch(e => {
        console.error(e);
        return false;
      });

       await axios.get(`http://localhost:8080/board/comments/${this.isBoardDetail.bid}`)
      .then(res=> {
        console.log("test");
        console.log(res.data);
        this.replyList = res.data;
      });
         return false;
    },
    modifyReplyActive() {

    },
    async reloadReplyList() {
        await axios.get(`http://localhost:8080/board/comments/${this.isBoardDetail.bid}`)
        .then(res => {
         // this.data.replyList = res.data;
           console.log("reloadReplyList")
           console.log(res.data);
           this.replyList=res.data;
         
        });
    }


  }

}
</script>

<style scoped>

.componentRoot{
  padding: 1rem 1rem;
  border: 1px solid #333;
}

.replyWriterInput {
  width: 5rem;
}


.writerArea {
  display: flex;
  justify-content: space-between;
}

.replyInputContainer {
  display: flex;
}

.replyContentTextArea {

}


.articleInfo {
  display: flex;
}

.title {
}

.writer {
  font-size: 1em;
}

.articleInfo div{
  font-size: 0.7em;
}

.reply {
  font-size: 1em;
}

.articleBottomBtn{
  display: flex;
  justify-content: space-between;
  /*align-items: stretch;*/
}

.articleBottomBtn .contentRelated {
  display: flex;
  /*padding: 1rem;*/
}

.articleBottomBtn .contentNoRelated {
  display: flex;
  /*padding: 1rem;*/
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

</style>
