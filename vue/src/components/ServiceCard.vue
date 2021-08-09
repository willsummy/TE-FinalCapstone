<template>
<div>
    <div>
        <table >
          <tr>
            <th>Service Id</th>
            <td>{{service.service_id}}</td>
          </tr>
          <tr>
            <th>Pothole Id</th>
            <td>{{service.pothole_id}}</td>
          </tr>
          <tr>
            <th>Date Reported</th>
            <td>{{service.date_reported}}</td>
          </tr>
          <tr>
            <th>Date Inspected</th>
            <td>{{service.date_inspected}}</td>
          </tr>
          <tr>
            <th>Employee Id</th>
            <td>{{service.employee_id}}</td>
          </tr>
          <tr>
            <th>Service Status Id</th>
            <td>{{service.service_status_id}}</td>
          </tr>
        </table>

        <div>
            <button id="deleteService" v-on:click="deleteService">Delete</button>
            <button id="setAsInspected" v-on:click="setAsInspected" v-if="service.service_status == 1">Set As Inspected</button>
            <button id="setAsRepaired" v-on:click="setAsRepaired" v-if="service.service_status == 2">Set As Repaired</button>
            <span v-if="service.service_status == 3">Pothole has been repaired</span>
        </div>
    </div>



</div>
</template>

<script>
import ServiceService from '../services/ServiceService.vue'
export default {
    name: 'service-card',
    props: ['service'],

    methods: {
        deleteService() {
            ServiceService.deleteService(this.$route.params.id).then( response => {
                if( response.status == 200 ) {
                    alert("Pothole Service Deleted")
                    this.refreshServices()
                } else alert("Delete unsuccessful")
            })
        },
        refreshServices() {
            ServiceService.getList(this.$route.params.id).then( response => {
                if (response.status == 200) {
                    this.$store.commit("SET_SERVICES", response.data);
                } else alert("Could not refresh Services")
            })
        },
        setAsInspected() {
            ServiceService.setAsInspected(this.$route.params.id).then( response => {
                if( response.status == 200) {
                    this.refreshServices()
                } else alert("Unable to change service status")
            })
        },
        setAsRepaired() {
            ServiceService.setAsRepaired(this.$route.params.id).then( response => {
                if(response.status == 200) {
                    this.refreshServices()
                } else alert("Unable to change service status")
            })
        }
    }

}
</script>

<style>

</style>
