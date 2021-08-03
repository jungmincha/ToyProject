<template>
  <div>
    <div class='pageTitle'>
      글쓰기 페이지
    </div>

    <div class='boardWrap'>
      <div class='titleWrap'>
        <textarea v-model='btitle' placeholder='제목을 입력해 주세요'>
        </textarea>
        <input v-model='bname' placeholder='작성자를 입력해 주세요'>
      </div>


      <div class='contentWrap'>
        <div>
          <textarea v-model='bcontent' placeholder='내용을 입력해 주세요'>
          </textarea>
        </div>
      </div>

      <button @click='boardSave'>등록</button>
      <nuxt-link to="/board">취소</nuxt-link>
    </div>

  </div>


</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      
      btitle : "",
      bname : "",
      bcontent : "",
    };
  },
  methods: {

    async boardSave() {
      await axios.post('http://localhost:8080/board/write', {
        btitle : this.btitle,
        bname : this.bname,
        bcontent : this.bcontent
      }).then(res => {

        if(res.data.code ==='S'){
          
            this.$router.push("/board");
        }
        
        
      }).catch(e => {
      });

      return false;
    }
  }

}
</script>

<style scoped>

.pageTitle {
  font-size: 3rem;
  margin-top: 2rem;
  margin-bottom: 2rem;
  text-align: center;
}

.boardWrap {
}

.titleWrap {
  display: flex;
  justify-content: center;
}




</style>
