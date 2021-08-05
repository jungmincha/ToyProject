<template>
  <div>
    <welcome-image></welcome-image>
<button @click="increase">숫자 증가</button>
<button @click="desc">숫자 감소</button>
   {{value}}
  <br>
   <div v-if="hide">안녕안녕안녕안녕안녕</div>
    <button @click="toggle">감추기</button>

   
              <tr v-for="board in boardList" :key="board.bid">
                <td>{{board.bid}}</td>
                <td>
                    {{board.btitle}}

                </td>
                <td>{{board.bname}}</td>
                <td>{{board.bdate}}</td>
              </tr>
           


 <div class='saveWrap'>
    <input v-model='btitle' placeholder='제목을 입력해 주세요'>
    <input v-model='bname' placeholder='작성자를 입력해 주세요'>
    <input v-model='bcontent' placeholder='내용을 입력해 주세요'>
    <button @click='savePost'>등록</button>
</div>
   </div>
</template>


<script>
import axios from 'axios';
import WelcomeImage from "~/components/organisms/WelcomeImage"




export default {
  components: {
    WelcomeImage,
  },
  data(){
    return{
      value : 0 ,
      hide : true,
      btitle : "",
      bname : "",
      bcontent : "",

   
        boardList : {},
        boardOriginalList : {}
      
    };
  },
  methods:{
    increase(){
      this.value++;
    },
    desc(){
      this.value--;
    },
    toggle(){
      this.hide = !this.hide;
    },

    async savePost(){
      await axios.post('http://localhost:8080/board/write',{
        btitle : this.btitle,
        bname : this.bname,
        bcontent : this.bcontent

      }).then(res =>{
        // this.btitle = "",
        // this.bname = "" ,
        // this.bcontent = ""
        console.log(res.data);


      }).catch(e =>{
        console.log(e);
      });

         await axios.get('http://localhost:8080/board')
        .then(res=>{
          console.log("test");
          console.log(res.data);
          this.boardList = res.data.list.content;
        });

        return false;
    }
    

  }

}
</script>
