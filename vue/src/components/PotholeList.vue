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
      return this.potholes.filter( pothole => {
        return pothole.address.includes(this.$store.state.zipcodeFilter)
      })
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
