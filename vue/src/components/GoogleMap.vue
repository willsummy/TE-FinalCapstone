<template>
  <div>
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
</template>

<script>
export default {
  name: 'GoogleMap',
  data() {
    return {
      center: {lat: 41.4993, lng: 81.6944},
      places: [],
    }
  },
  mounted() {
    this.geolocate();
  },
  methods: {
    geolocate() {
      navigator.geolocation.getCurrentPosition(position => {
        this.center = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
      });
    },
  },

  computed: {
    filteredMarkers() {
      const filtered = this.$store.state.potholes.filter( pothole => {
        return pothole.address.includes(this.$store.state.zipcodeFilter)
      })
      return filtered.map( pothole => {
        const marker = { lat: pothole.latitude, lng: pothole.longitude };
        return {position: marker}
      })
    }
  }
};
</script>

<style>
    div {
    width: 100%;
    }
    #map {
        height: 600px;
        background: gray;
    }
</style>
