<template>
  <nav>
    <NuxtLink to="/board">
      <button>이슈 게시판</button>
    </NuxtLink>
    <button>일 상 생 각 주절주절</button>
    <button>일 상 생 각 조각조각</button>
    <button>R & D 주절주절</button>
    <button>R & D 조각조각</button>
  </nav>
</template>

<script>
export default {
  name: "HeaderNav"
}
</script>

<style scoped>

nav {
  margin-bottom: 1rem;
}

button {
  border: none;
  background-color: transparent;
  color: #898989;
}
button:hover{
  color: black;
}
</style>
