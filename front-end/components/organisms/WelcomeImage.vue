<template>
  <div class='componentRoot'>
    <div class='wrapContent'>
      <img :src="require(`@/assets/img/welcomeimage.jpg`)" class='contentImage'/>
      <div class='contentText'>
        <span> 커피 한잔 어떠세요? </span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "WelcomeImage"
}
</script>

<style scoped>
.componentRoot{
  margin-top: 1rem;
  margin-bottom: 1rem;
}

.wrapContent {
  display: flex;
  align-items: center;
}

.contentImage {
  flex-basis: 70%;
}

.contentText {
  flex-basis: 30%;
  display: flex;
  justify-content: center;
}

</style>
