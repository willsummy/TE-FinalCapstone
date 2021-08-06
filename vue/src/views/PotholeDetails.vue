<template>
  <div id="details-main">
    <div id="details-map">
      <div id="details">
        <!-- everything but description -->
        <p>Pothole: {{pothole.potholeId}}</p>
        <p>{{pothole.user_id}}</p>
        <p>{{pothole.date_reported}}</p>
        <p>{{pothole.time_reported}}</p>
        <p>{{pothole.address}}</p>
        <p>{{pothole.latitude}}</p>
        <p>{{pothole.longitude}}</p>
        <p>{{pothole.description}}</p>
        <p>{{pothole.size}}</p>
        
      </div>
      <div id="map">
        <!-- map and description -->
        
      </div>
    </div>
    <div id="details-buttons">
      <!-- 3 buttons, edit, delete, status -->
    </div>
  </div>
</template>

<script>
export default {
    name: "pothole-details",
    props: ['pothole']
    
  

}
</script>

<style>

</style>
