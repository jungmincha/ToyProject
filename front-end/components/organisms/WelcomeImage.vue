<template>
  <div class='componentRoot'>
    <div class='wrapContent'>
      <img :src="require(`@/assets/img/okinawa.jpg`)" class='contentImage'/>
      <div class='contentText'>
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
