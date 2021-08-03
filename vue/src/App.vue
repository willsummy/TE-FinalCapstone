<template>
  <div id="app">
    <div id="header">
      <div id="title">Pothole Tracker</div>
      <div id="nav">
        <router-link id='homelink' class="routerlink" v-bind:class="{ bold: $route.path == '/' }" v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link id='loginlink' class="routerlink" v-bind:class="{ bold: $route.path == '/login' }" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
        <router-link id='registerlink' class="routerlink" v-bind:class="{ bold: $route.path == '/register' }" v-bind:to="{ name: 'register' }" v-if="$store.state.token == ''">Register</router-link>
        <router-link id='logoutlink' class="routerlink" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
    </div>
    <div>
      <router-view />
    </div>

  </div>
</template>

<script>
export default {
}
</script>

<style>

body {
  font-family: sans-serif;
}

div#app, div#nav {
  display: flex;
  flex-direction: column;

}

div#header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;

  align-items: center;
  background-color: lightgrey;
  border-radius: 10px;
}

div#nav {
  padding-right: 20px;
  align-items: flex-end;
}

div#nav > .routerlink {
  text-decoration: none;
  color: rgb(70, 70, 70);

}

div#nav > .routerlink:hover {
  font-size: 120%;
}

div#title {
  font-size: 70px;
  padding-left: 20px;
}

.routerlink.bold {
  font-weight: bold;
}

</style>
