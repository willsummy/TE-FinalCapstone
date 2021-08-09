<template>
<div id="master">
  <div class="home">
    <div id='home-header'>

      <div id='homeandreport'>
        <h1>Home</h1>
        <router-link id='reportlink' v-bind:to="{name: 'report-form'}" >Report A Pothole</router-link>
      </div>

      <select  v-model="filterType" name="filterType" id="filterType">
        <option disabled default value="">Please select type of filter</option>
        <option value="zipcode">Zipcode</option>
        <option value="city">City</option>
        <option value="user_id">My Submissions</option>
      </select>


      <div id="zipfilter" v-if="filterType == 'zipcode'">
        <label for="zipcode">Filter by Zipcode</label>
        <input type="text" id="zipcode" v-model="zipcode" />
        <button type="submit" v-on:click.prevent="set_filter(zipcode)">Filter</button>
        <button type="submit" v-on:click.prevent="reset_filter">View All</button>
      </div>

      <div id="cityfilter" v-if="filterType == 'city'">
        <label for="city">Filter by City</label>
        <input type="text" id="city" v-model="city" />
        <button type="submit" v-on:click.prevent="set_filter(city)">Filter</button>
        <button type="submit" v-on:click.prevent="reset_filter">View All</button>
      </div>

      <div id="userfilter" v-if="filterType == 'user_id'">
        <label for="user_id">My Submissions</label>
        <button type="submit" v-on:click.prevent="set_filter(city)">Filter</button>
        <button type="submit" v-on:click.prevent="reset_filter">View All</button>
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
      zipcode: '',
      city: '',
      user_id: null,
      filterType: ''
    }
  },
  components: {
    ViewPotholes
  },
  methods: {
    set_filter(filter) {
      this.$store.commit("SET_FILTER", {"filter": filter, "filterType": this.filterType})
    },
    reset_filter() {
      this.$store.commit("RESET_FILTER")
      this.$store.commit("RESET_FILTER_TYPE")
      this.zipcode = ''
    }
  },
  created() {
    this.$store.commit("RESET_FILTER")
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
  background-color:  rgb(200,200,200);
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

#zipfilter {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
}

</style>
