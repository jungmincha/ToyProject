<template>
  <div>
    <main-header></main-header>
    <Nuxt></Nuxt>
    <main-footer></main-footer>
  </div>
</template>

<script>
import MainHeader from '~/components/organisms/MainHeader'
import MainFooter from "~/components/organisms/MainFooter";

export default {
  components: {
    MainHeader,
    MainFooter
  },
}
</script>

<style scoped>


</style>
