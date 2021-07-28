<template>
  <header>
    <div>
      <NuxtLink class="remove-a-link-css" to="/">
        <div>
          <img src="~/static/titlelogo.jpg" />
          <p>
            COS247
            <br />
            ISSUE BLOG
          </p>
        </div>
      </NuxtLink>
    </div>

    <header-nav>
    </header-nav>
  </header>
</template>

<script>
import HeaderNav from "~/components/organisms/HeaderNav";

export default {
  name: 'MainHeader',
  components: {
    HeaderNav
  },
}
</script>

<style scoped>
img {
  display: block;
}

label {
}

.remove-a-link-css {
  text-decoration: none;
  color: black;
}


.remove-a-link-css div {
  width: fit-content;
  text-align: center;
}

nav {
  display: flex;
  justify-content: space-around;
}
</style>
