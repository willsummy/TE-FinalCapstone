<template>
  <div id="details-main">
    <div id="details-map">
      <div id="details">
        <!-- everything but description -->
        <p>{{pothole.pothole_id}}</p>
        <p>{{pothole.user_id}}</p>
        <p>{{pothole.data_reported}}</p>
        <p>{{pothole.time_reported}}</p>
        <p>{{pothole.address}}</p>
        <p>{{pothole.latitude}}</p>
        <p>{{pothole.longitude}}</p>
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
    data() {
      return {
        pothole: this.$store.state.potholes.find( pothole => pothole.pothole_id == this.$route.params.id)
      }
    },

    
    
    
  

}
</script>

<style>

</style>
