<template>
<div id="master">
  <div class="home">
    <h1>Home</h1>
    <!-- <p>You must be authenticated to see this</p> -->
    <router-link v-bind:to="{name: 'report-form'}" >Report A Pothole</router-link>
    <view-potholes/>

  </div>
</div>
</template>

<script>
import ViewPotholes from '../components/ViewPotholes.vue'

export default {
  name: "home",
  components: {
    ViewPotholes
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
