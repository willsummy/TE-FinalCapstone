<template>
  <div id="details-main">
    <div id="details-map">
      <div id="details">
        <!-- everything but description -->
      </div>
      <div id="map">
        <!-- map and description -->
        <GmapMap
      :center='center'
      :zoom='10'
      style='width:100%;  height: 400px;'
      >
        <GmapMarker
          :key="index"
          v-for="(m, index) in filteredMarkers"
          :position="m.position"
          @click="center=m.position"
        />
      </GmapMap>
      </div>
    </div>
    <div id="details-buttons">
      <!-- 3 buttons, edit, delete, status -->
    </div>
  </div>
</template>

<script>
export default {
    name: "pothole-details"

}
</script>

<style>

</style>
