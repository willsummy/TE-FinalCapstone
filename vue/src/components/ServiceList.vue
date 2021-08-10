<template>
<div>
    <service-card id="service-list" v-for="service in this.$store.state.currentServices" v-bind:key="service.service_id" v-bind:service="service" ></service-card>
</div>
</template>

<script>

import ServiceCard from '../components/ServiceCard.vue';

export default {
    name: 'service-list',
    components: {
        ServiceCard

    },

}
</script>

<style>

</style>
