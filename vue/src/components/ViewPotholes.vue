<template>
<div>
    <div id="googlemap">
      <GoogleMap/>
    </div>
    <pothole-list v-bind:potholes="$store.state.potholes"/>
</div>
</template>

<script>
import GoogleMap from '../components/GoogleMap.vue'
import PotholeService from '../services/PotholeService';
import PotholeList from '../components/PotholeList.vue';

export default {
    name: "view-potholes",
    components: {
        GoogleMap,
        PotholeList
    },
    props: ["zipcode"],

    created() {
        let potholes = null;
        PotholeService.getList().then(response => {
        potholes = response.data;
        this.$store.commit("SET_POTHOLES", potholes)
        })

    }
}
</script>

<style>


</style>
