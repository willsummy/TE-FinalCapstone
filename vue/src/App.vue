<template>
  <div id="app">
    <div id="header">
      <h1 id="title">Greater Cleveland Pothole Tracker</h1>
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
  color: #001524;
}

#header, #router {
  width: 100%;
  border-style: inset;
  border-radius: 5px;
  border-color:  rgb(40, 40, 40);
  background-color: #FF7D00;
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
  background-color: #FFECD1;
  padding-bottom: 3px;
  padding-top: 3px;
  border-radius: 3px;
}

.routerlink {
  margin-left: 5px;
  margin-right: 5px;
  text-decoration: none;
  color: rgb(40, 40, 40);
}

.routerlink:hover {
  text-decoration: underline;
}



</style>
