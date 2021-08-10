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


            <label for="service_status">Change Service Status</label>
                <select  v-model="editedService.service_status_id" name="service_status" id="service_status">
                    <option disabled default value="-1">Please select rank</option>
                    <option value="1">Reported, Uninspected</option>
                    <option value="2">Insepcted, Repair Pending</option>
                    <option value="3">Repair Finished</option>
                </select>

            <button id="status-change-btn" v-on:click="setNewStatus">Set New Status</button>
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
            editedService: {
                service_id: '',
                pothole_id: '',
                date_reported: '',
                date_inspected: '',
                date_repaired: '',
                employee_id: '',
                service_status_id: '',
                service_description: ''
            }
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
