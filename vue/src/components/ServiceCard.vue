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

        </div>
    </div>



</div>
</template>

<script>
import ServiceService from '../services/ServiceService.js'
export default {
    name: 'service-card',
    props: ['service'],
    data() {
        return {

        }
    },
    created() {
        this.editedService = this.service;
    },
    methods: {
        deleteService() {
            ServiceService.deleteService(this.service.service_id).then( response => {
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
        setNewStatus() {
            ServiceService.setStatus(this.editedService).then( response => {
                if(response.status == 200) {
                    this.refreshServices();
                } else alert("Could not update Service Status")
            })
        }
    }

}
</script>

<style>

</style>
