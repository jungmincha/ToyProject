<template>
  <div>
    <welcome-image></welcome-image>
<<<<<<< HEAD
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
=======
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
>>>>>>> 3409767e94fe1d4e34c08ddcf9f932adbe2960cb
</template>


<script>
<<<<<<< HEAD
import WelcomeImage from "~/components/organisms/WelcomeImage";
import axios from 'axios'
=======
import axios from 'axios';
import WelcomeImage from "~/components/organisms/WelcomeImage"



>>>>>>> 3409767e94fe1d4e34c08ddcf9f932adbe2960cb

export default {
  components: {
    WelcomeImage,
  },
<<<<<<< HEAD

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
=======
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

>>>>>>> 3409767e94fe1d4e34c08ddcf9f932adbe2960cb
}
</script>
