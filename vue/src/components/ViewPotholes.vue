<template>
<div id="googlemap">
    <div >
      <GoogleMap/>
    </div>
    <pothole-list v-bind:potholes="$store.state.potholes"/>
</div>
</template>

<script>
import GoogleMap from '../components/GoogleMap.vue'
import PotholeList from '../components/PotholeList.vue';

export default {
    name: "view-potholes",
    components: {
        GoogleMap,
        PotholeList
    },
    props: ["zipcode"],


}
</script>

<style>


</style>
