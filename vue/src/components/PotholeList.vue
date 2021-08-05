<template>
<div>
  <pothole-card v-for="pothole in potholes" v-bind:key="pothole"></pothole-card>
  </div>
</template>

<script>

import PotholeCard from '../components/PotholeCard.vue';

export default {
    name: 'pothole-list',
    data() {
        return {
            potholes: [],
    
        }
    },
    components: {
        PotholeCard

    },

    created() {
        this.potholes = this.$store.state.potholes

    }

}
</script>

<style>

</style>