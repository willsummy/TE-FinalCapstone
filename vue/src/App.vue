<template>
  <div id="app">
    <div id="header">
      <div>
        <img src="./img/logo.png" alt="">
      </div>
      <div>
        <h1 id="title1">Greater Cleveland</h1>
        <h1 id="title2">Pothole Tracker</h1>
        <div id="nav">
          <router-link id='homelink' class="routerlink" v-bind:class="{ bold: $route.path == '/' }" v-bind:to="{ name: 'home' }">Home</router-link>
          <router-link id='loginlink' class="routerlink" v-bind:class="{ bold: $route.path == '/login' }" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
          <router-link id='registerlink' class="routerlink" v-bind:class="{ bold: $route.path == '/register' }" v-bind:to="{ name: 'register' }" v-if="$store.state.token == ''">Register</router-link>
          <router-link id='logoutlink' class="routerlink" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        </div>
      </div>

    </div>
    <div id='router'>
      <router-view />
    </div>

  </div>
</template>

<script>
import PotholeService from './services/PotholeService.js'
export default {
  created() {
      let potholes = null;
      PotholeService.getList().then(response => {
        potholes = response.data;
        this.$store.commit("SET_POTHOLES", potholes)
      })

  }
}
</script>

<style>

img {
  height: 15rem;
}

#header {
  display: flex;
  flex-direction: row;
}

</style>
