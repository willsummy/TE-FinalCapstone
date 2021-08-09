<template>
  <div >
    <pothole-card id="pothole-list" v-for="pothole in filteredPotholes" v-bind:key="pothole.pothole_id" v-bind:pothole="pothole"></pothole-card>
  </div>
</template>

<script>

import PotholeCard from '../components/PotholeCard.vue';

export default {
    name: 'pothole-list',
    props: ["potholes"],
    components: {
        PotholeCard

    },
    computed: {
    filteredPotholes() {
      if(this.$store.state.filterType == "zipcode") {
        return this.$store.state.potholes.filter( pothole => {
          return pothole.address.includes(this.$store.state.filter)
        })


      } else if (this.$store.state.filterType == "city") {
        return this.$store.state.potholes.filter( pothole => {
          const addressSplit = pothole.address.split(",")
          const city = addressSplit[addressSplit.length-3]
          return city.includes(this.$store.state.filter)
        })


      } else if (this.$store.state.filterType == "user_id") {
        return this.$store.state.potholes.filter( pothole => {
          return pothole.user_id == this.$store.state.user.id
        })

      } else {
        return this.$store.state.potholes
      }

    }
  }

}
</script>

<style>
#pothole-list {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
