<template>
<div id="master">
  <div class="home">
    <h1>Home</h1>
    <!-- <p>You must be authenticated to see this</p> -->
    <router-link v-bind:to="{name: 'report-form'}" >Report A Pothole</router-link>

    <div id="googlemap">
      <GoogleMap/>
    </div>
  </div>
</div>
</template>

<script>
import GoogleMap from '../components/GoogleMap.vue'
import PotholeService from '../services/PotholeService';
export default {
  name: "home",
  components: {
    GoogleMap
  }
};
</script>


<style>
#master {
    display: flex;
    flex-direction: column;
    align-items: center;
}
.home {
    display: flex;
    flex-direction: column;
    align-items: center;
    align-content: space-around;
    margin: auto;
    border-style: groove;
    border-color: black;

  }

</style>
