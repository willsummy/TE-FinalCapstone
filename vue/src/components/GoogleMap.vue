<template>
  <div id="mapdiv">
    <GmapMap
      id="map"
      :center='center'
      :zoom='10'
    
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
      if(this.$store.state.filterType == "zipcode") {
        const filtered = this.$store.state.potholes.filter( pothole => {
          return pothole.address.includes(this.$store.state.filter)
        })
        return filtered.map( pothole => {
          const marker = { lat: pothole.latitude, lng: pothole.longitude };
          return {position: marker}
        })
      } else if (this.$store.state.filterType == "city") {
        const filtered = this.$store.state.potholes.filter( pothole => {
          const addressSplit = pothole.address.split(",")
          const city = addressSplit[addressSplit.length-3]
          return city.includes(this.$store.state.filter)
        })
        return filtered.map( pothole => {
          const marker = { lat: pothole.latitude, lng: pothole.longitude };
          return {position: marker}
        })
      } else if (this.$store.state.filterType == "user_id") {
        const filtered = this.$store.state.potholes.filter( pothole => {
          return pothole.user_id == this.$store.state.user.id
        })
        return filtered.map( pothole => {
          const marker = { lat: pothole.latitude, lng: pothole.longitude };
          return {position: marker}
        })

      } else {
        return this.$store.state.potholes.map( pothole => {
          const marker = { lat: pothole.latitude, lng: pothole.longitude };
          return {position: marker}
        })
      }

    }
  }
};
</script>

<style>
    #map {
      height: 600px;
      background: gray;
      border: 5px solid #78290f;
      width: 75%;
      height: 400px;
    }

    #mapdiv {
      display: flex;
      flex-direction: row;
      justify-content: center;
    }
</style>
