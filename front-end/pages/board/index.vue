<template>
  <div class='componentRoot'>
    <div class="boardTitle">
      ISSUE BOARD
    </div>

    <div class='tableCenter'>
      <div class="tableAndSkillContainer">
        <div class="tableWrap">
          <table>
            <thead>
              <tr>
                <th >글 번호</th>
                <th >제목</th>
                <th >글쓴이</th>
                <th >날짜</th>
              </tr>
            </thead>

            <tbody>
              <tr v-for="board in posts" :key="board.bid">
                <td class="postNumber">{{board.bid}}</td>
                <td class="postTitle">

                  <nuxt-link :to="`/board/${board.bid}`">
                    {{board.btitle}}
                  </nuxt-link>

                </td>
                <td class="postAuthor">{{board.bname}}</td>
                <td class="postDate">{{board.bdate}}</td>
              </tr>
            </tbody>

          </table>
        </div>

        <div class="tableSkillContainer">
          <nuxt-link to='/board/write'>
            글쓰기
          </nuxt-link>
        </div>


        <page-bar :paging-data='pagingData' >

        </page-bar>

<!--        {{ pagingData }}-->

      </div>

    </div>

  </div>
</template>

<script>
import axios from 'axios'
import PageBar from '~/components/atom/PageBar'

export default {
  components: {
    PageBar
  },
  async asyncData({ route, params }) {
    console.log("-----")
    console.log(route.fullPath);
    console.log("-----")

    return await axios.get('http://localhost:8080' + `${route.fullPath}`).then(res => {
      return {
        posts: res.data.content,
        pagingData : {
          totalPage : res.data.totalPages,
          curPageNumber : res.data.number + 1,
          startPageNumber : (res.data.number + 1) - 4 >= 1 ? (res.data.number + 1) - 4 : 1,
          endPageNumber : function() {
            if((res.data.number + 1) + 4 <= 9){
              return Math.min(9, res.data.totalPages);
            }
            return (res.data.number + 1) + 4 <=  res.data.totalPages ? (res.data.number + 1) + 4 : res.data.totalPages;
          }(),
          // endPageNumber : (res.data.number + 1) + 4 <=  res.data.totalPages ? (res.data.number + 1) + 4 : res.data.totalPages,
          sizeInPage : res.data.size,
          first : res.data.first,
          last : res.data.last,
        }
      }
    })
  },
  data() {
    return {
      posts: {},
      pagingData: {

      },
      pp: 0,
      error: null
    }
  },
  watch: {
    '$route': 'moveSpecificPage'
  },
  methods: {
    async moveSpecificPage(route) {
      const fetchData = await axios.get('http://localhost:8080' + route.fullPath).then(res => {
        return {
          posts: res.data.content,
          pagingData : {
            totalPage : res.data.totalPages,
            curPageNumber : res.data.number + 1,
            startPageNumber : (res.data.number + 1) - 4 >= 1 ? (res.data.number + 1) - 4 : 1,
            endPageNumber : function() {
              if((res.data.number + 1) + 4 <= 9){
                return Math.min(9, res.data.totalPages);
              }
              return (res.data.number + 1) + 4 <=  res.data.totalPages ? (res.data.number + 1) + 4 : res.data.totalPages;
            }(),
            sizeInPage : res.data.size,
            first : res.data.first,
            last : res.data.last,
          }
        }
      });

      this.posts = fetchData.posts;
      this.pagingData = fetchData.pagingData;
    },
  }
}
</script>

<style scoped>

.componentRoot{

}

.boardTitle {
  font-size: 4rem;
  margin-top: 2rem;
  margin-bottom: 2rem;
  text-align: center;
}

.tableCenter {
  display: flex;
  justify-content: center;
}

.tableAndSkillContainer{
  width: 40rem;
}

.tableWrap {
  display: flex;
  justify-content: center;
}

table {
  width: 100%;
}


table, th, td {
  border: 1px solid #bcbcbc;
}


thead th {
  text-align: center;
}

tbody td {
  padding-left: 0.4rem;
  padding-right: 0.4rem;
}

.postNumber {
  text-align: right;
}

.postTitle {
  text-align: left;
}

.postTitle a {
  text-decoration: none;
}


.postAuthor {
  text-align: left;
}

.postDate {
  text-align: center;
}

.tableSkillContainer {
  display: flex;
  justify-content: flex-end;
  margin-top: 0.5rem;
  padding-right: 0.5rem;

}

.tableSkillContainer a{
  background-color: white;
  border: 2px solid #000099; /* Green */
  color: black;
  font-size: 0.8em;
  padding: 0.5em 0.8em;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  /*font-size: 16px;*/
}

</style>
