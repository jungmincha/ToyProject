<template>
  <div class="componentRoot">
    <footer>
      <div class='wrapCopyrightText'>
        <span class='copyrightText'>
          Copyright ©2020 CY Co., Ltd. All rights reserved.
        </span>
      </div>
    </footer>
  </div>
</template>

<script>
export default {
  name: "MainFooter"
}
</script>

<style scoped>

.componentRoot{
  margin-top: 2rem;
}

.wrapCopyrightText{
  background-color: #1d242d;
  height: 5rem;
  display: flex;
  justify-content: center;
  align-items: center;

}


.copyrightText{
  position: center;
  font-size: 0.7rem;
  color: white;
}


</style>
