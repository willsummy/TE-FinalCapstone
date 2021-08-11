<template>
<div id="master">
  <div id="home">
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
      zipcode: '',

    }
  },
  components: {
    ViewPotholes
  },
  methods: {

  },

};


</script>


<style>

#master {
  display: flex;
  flex-direction: column;
  width: inherit;
}

#home {
  width: 100%;
}

#home-header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

</style>
