<template>
<div>
    <service-card id="service-list" v-for="service in services" v-bind:key="service.service_id" v-bind:service="service" ></service-card>
</div>
</template>

<script>

import ServiceCard from '../components/ServiceCard.vue';

export default {
    name: 'service-list',
    props: ['services'],
    components: {
        ServiceCard

    },

}
</script>

<style>

</style>
