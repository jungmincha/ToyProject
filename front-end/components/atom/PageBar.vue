<template>
  <div>


    <div id="wrapper">
      <div class="pagination digg">
        <ul>
          <li><button :class="{disabled : pagingData.startPageNumber <= 1}" @click='movePage(0)'>맨앞</button></li>
          <li><button :class="{disabled : pagingData.startPageNumber <= 1}" @click='movePage(pagingData.startPageNumber - 1)'>&lt;&lt; </button></li>

          <li v-for="pageNumber in pageNumberingRender()" :key="pageNumber" >
            <button :class='{current : pageNumber === pagingData.curPageNumber}' @click='movePage(pageNumber)'>
              {{ pageNumber }}
            </button>
          </li>

          <li><button :class="{disabled : pagingData.curPageNumber + 4 >= pagingData.totalPage}" @click='movePage(pagingData.endPageNumber + 1)'>&gt;&gt;</button></li>
          <li><button :class="{disabled : pagingData.curPageNumber + 4 >= pagingData.totalPage}" @click='movePage(pagingData.totalPage)'>맨뒤</button></li>
        </ul>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: 'PageBar',
  props   : {
    pagingData: {
      type: Object,
      default() {
        return {

        }
      }
    }
  },
  methods: {
    pageNumberingRender() {
      const list = [];
      for (let i = this.pagingData.startPageNumber; i <= this.pagingData.endPageNumber; i++) {
        list.push(i);
      }

      console.log("list : ", list);
      return list
    },
    movePage(nextPageNumber){
      console.log("movePage")
      // nextPageNumber -= 1;
      // console.log("nextPageNumber : ", nextPageNumber);
      return this.$router.push({ path: 'board', query: { page: nextPageNumber }});

      // this.$emit('moveSpecificPage', nextPageNumber);
      // return false;
    }

  }
}
</script>

<style scoped>


/*Common*/
div#wrapper {
  position: relative;
  width: 500px;
  margin: 0 auto;
}

div.pagination {
  overflow: hidden;
  font-size: 9pt;
  padding: 10px 0;
}

div.pagination ul {
  list-style: none;
  padding: 2px 0;
  line-height: 16px;
}

div.pagination li {
  display: inline;
}

/*Digg*/
div.pagination.digg {
  padding: 3px;
  margin: 3px;
  text-align:center;
}


div.pagination.digg li button {
  padding: 2px 5px 2px 5px;
  margin: 2px;
  border: 1px solid #AAAADD;

  text-decoration: none; /* no underline */
  background-color: white;
  color: #000099;
}

div.pagination.digg li button.current {
  padding: 2px 5px 2px 5px;
  margin: 2px;
  border: 1px solid #000099;

  font-weight: bold;
  background-color: #000099;
  color: #FFF;
}

div.pagination.digg button:hover, div.pagination.digg button:active {
  border: 1px solid #000099;
  color: #000;
}


div.pagination.digg li > button.disabled {
  padding: 2px 5px 2px 5px;
  margin: 2px;
  border: 1px solid #EEE;
  color: #DDD;
}
</style>
