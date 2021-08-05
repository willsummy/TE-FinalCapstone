<template>
<div>
  <pothole-card v-for="pothole in potholes" v-bind:key="pothole.pothole_id" v-bind:pothole="pothole"></pothole-card>
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

}
</script>

<style>

</style>
