<template>
<div id="master">
  <div class="home">
    <div id='home-header'>

      <div id='homeandreport'>
        <h1>Home</h1>
        <router-link id='reportlink' v-bind:to="{name: 'report-form'}" >Report A Pothole</router-link>
      </div>


      <div id="filter">
        <label for="zipcode">Filter by Zipcode</label>
        <input type="text" id="zipcode" v-model="zipcode" />
        <button type="sumbit" v-on:click.prevent="set_zip_filter(zipcode)">Filter</button>
        <button type="submit" v-on:click.prevent="reset_zip_filter">View All</button>
      </div>
    </div>




    <view-potholes/>

  </div>
</div>
</template>

<script>
import PotholeService from '../services/PotholeService.js'
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
    let potholes = null;
    PotholeService.getList().then(response => {
      potholes = response.data;
      this.$store.commit("SET_POTHOLES", potholes)
    })

  }
};


</script>


<style>
#master {
  border-radius: 3px;
  margin: 3px;
  background-color:  #FFECD1;
  padding: 3px;
}
.home {
  width: 100%;
  display: flex;
  flex-direction: column;
}

#home-header {
  display: flex;
  flex-direction: row;
}

#homeandreport {
  flex-grow: 1;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}

#homeandreport > h1 {
  margin: 0px;
}

#reportlink {
  text-decoration: none;
  width: fit-content;
  color: rgb(40, 40, 40);
}

#reportlink:hover {
  text-decoration: underline;
}

#filter {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
}

</style>
