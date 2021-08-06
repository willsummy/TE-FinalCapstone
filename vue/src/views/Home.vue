<template>
<div id="master">
  <div class="home">
    <h1>Home</h1>
    <!-- <p>You must be authenticated to see this</p> -->
    <router-link v-bind:to="{name: 'report-form'}" >Report A Pothole</router-link>

    <div id="zipcode-filter">
      <label for="zipcode">Filter by Zipcode</label>
      <br>
      <input type="text" id="zipcode" v-model="zipcode" />
      <br>
      <button type="sumbit" v-on:click.prevent="set_zip_filter(zipcode)">Filter</button>
      <button type="submit" v-on:click.prevent="reset_zip_filter">View All</button>
    </div>


    <view-potholes/>

  </div>
</div>
</template>

<script>
import ViewPotholes from '../components/ViewPotholes.vue'

export default {
  name: "home",
  data() {
    return {
      zipcode: ''
    }
  },
  components: {
    ViewPotholes
  },
  methods: {
    set_zip_filter(zipcode) {
      this.$store.commit("SET_ZIP_FILTER", zipcode)
    },
    reset_zip_filter() {
      this.$store.commit("RESET_ZIP_FILTER")
      this.zipcode = ''
    }
  },
  created() {
    this.$store.commit("RESET_ZIP_FILTER")
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
  #zipcode-filter {
    text-align: center;
    margin-top: 10px;
  }

</style>
