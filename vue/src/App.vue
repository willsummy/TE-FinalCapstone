<template>
  <div id="app">
    <div id="header">
      <h1 id="title">Pothole Tracker</h1>
      <div id="nav">
        <router-link id='homelink' class="routerlink" v-bind:class="{ bold: $route.path == '/' }" v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link id='loginlink' class="routerlink" v-bind:class="{ bold: $route.path == '/login' }" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
        <router-link id='registerlink' class="routerlink" v-bind:class="{ bold: $route.path == '/register' }" v-bind:to="{ name: 'register' }" v-if="$store.state.token == ''">Register</router-link>
        <router-link id='logoutlink' class="routerlink" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
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

#app {
}

#app, #header {
  display: flex;
  flex-direction: column;
  align-items: center;
  font-family: sans-serif;
  color: rgb(40, 40, 40);
}

#header, #router {
  width: 100%;
  border-style: inset;
  border-radius: 5px;
  border-color:  rgb(40, 40, 40);
  background-color:  rgb(150, 150, 150);
}

#header {

  margin-bottom: 10px;
}

#title {
  font-size: 60px;
  margin: 0px;
}

#nav {
  width: 100%;
  display: block;
  text-align: center;
  background-color: rgb(200,200,200);
  padding-bottom: 3px;
  padding-top: 3px;
  border-radius: 3px;
}

.routerlink {
  margin-left: 5px;
  margin-right: 5px;
  text-decoration: none;
}

</style>
