<template>
  <div id="app">
    <div id="header">
      <div id="imageDiv">
        <router-link id="aboutTheTeam"  to="/about">
          <img src="./img/GCPTLogo.png" alt="Greater Cleveland Pothole Tracker">
        </router-link>
      </div>
      <div id="headerDiv">
        <div id="titles">
          <h1 id="title1">GREATER CLEVELAND</h1>
          <h1 id="title2">POTHOLE TRACKER</h1>
        </div>
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
@import url('https://fonts.googleapis.com/css2?family=Exo:wght@300&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Encode+Sans:wght@700&family=Exo:wght@300&family=Josefin+Sans&display=swap');


body {
  background-color:  #ffecd1;
}

img {
  height: 10rem;
}

#header {
  display: flex;
  flex-direction: row;
  justify-content: center;
  padding: 20px;
  width:inherit;
}

#app {
  background-color: #ffecd1;
  font-family: 'Exo', sans-serif;;
}

#nav {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

#headerDiv {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding-bottom: 10px;
 
}
 #imageDiv {
   display:flex;
   justify-content: flex-end;
   height: fit-content;
   padding-right: 15px;
  }

#titles {
  
}
#title1, #title2 {
  font-family: 'Encode Sans', sans-serif;
  margin: 0px;
  
}


#title2 {
  border-bottom: 3px solid #78290F;
  font-size: 225%;
}
 

.routerlink {
  font-family: 'Encode Sans', sans-serif;
  background-color: #FF7D00;
  border-radius: 25px;
  box-shadow: 5px 5px #15616D;
  padding: 10px;
}




</style>
