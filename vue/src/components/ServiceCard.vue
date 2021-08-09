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

    </div>



</div>

</template>

<script>

export default {
    name: 'service-card',
    props: ['service']

}
</script>

<style>

</style>
