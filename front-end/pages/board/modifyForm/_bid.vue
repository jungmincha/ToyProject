<template>
  <div>
    글수정 페이지
    <div>
      <label for='subject' >제목</label>
      <input id='subject' v-model='btitle' placeholder='제목을 입력해 주세요'>
      <input v-model='bname' placeholder='작성자를 입력해 주세요'>
    </div>
    <div>
      <textarea v-model='bcontent' placeholder='내용을 입력해 주세요'></textarea>
    </div>

    <button @click='boardSave'>등록</button>
    <nuxt-link to="/board">취소</nuxt-link>
  </div>


</template>

<script>
import axios from 'axios'

export default {
  async asyncData({params}) {
    return await axios.get(`http://localhost:8080/board/edit/${params.bid}`).then(res => {
      console.log("boardDetail : ", res.data);
      const {data : boardDetail} = res.data;

      return {
        bid : boardDetail.bid,
        btitle : boardDetail.btitle,
        bname : boardDetail.bname,
        bcontent : boardDetail.bcontent,
      }
    })
  },
  data() {
    return {
      bid : "",
      btitle : "",
      bname : "",
      bcontent : "",
    };
  },
  methods: {

    async boardSave() {
      await axios.put('http://localhost:8080/board/edit/' + this.bid, {
        btitle : this.btitle,
        bname : this.bname,
        bcontent : this.bcontent
      }).then(res => {
        if(res.data.code ==='S'){
          this.$router.push("/board/" + this.bid);
        };
      }).catch(e => {
      });

      return false;
    }
  }

}
</script>

<style scoped>

</style>
