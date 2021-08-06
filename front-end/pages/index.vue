<template>
  <div>
    <welcome-image></welcome-image>
  {{msg}}
  {{data.sumList}}

   <button class='btn' @click="toggle">클릭</button>

   <button class='btn' @click="increase">숫자 증가</button> : {{value}}

   <button class='btn' @click="movePage">페이지 이동</button>
        <div v-if="show">
          <h2>data() return에서 show가 true이면 보이고 false이면 안보여요</h2>
        </div>

  <input v-model="bname" placeholder="이름을입력하세요">
   <input v-model="btitle" placeholder="제목을입력하세요">
  <input v-model="bcontent" placeholder="내용을 입력하세요">
  <button class="btn" @click="savePost">글 작성</button>

  </div>
</template>

<script>
import WelcomeImage from "~/components/organisms/WelcomeImage";
import axios from 'axios'

export default {
  components: {
    WelcomeImage,
  },

  data() {
    return {
      msg : 'hello world',
      data: {
        sumList:[1,2,3,'dd'] 
      },
      show: true,
      value : 0,

      btitle : '',
      bcontent : '',
      bname : ''

    }
  },

  methods:{
    toggle(){
      console.log("test");
      this.show = !this.show;
    },

    increase(){
      console.log("increase");
      this.value++;
    },

    movePage(){
      console.log("movePage");
      return this.$router.push("/board");
    },

    async savePost(){
      await 
    }
  }
}
</script>
