<template>
  <div id="details-main">
    <div id="details-map">
      <div id="details">
        <!-- everything but description -->
        <table >
          <tr>
            <th>Pothole ID</th>
            <td>{{pothole.pothole_id}}</td>
          </tr>
          <tr>
            <th>User ID</th>
            <td>{{pothole.user_id}}</td>
          </tr>
          <tr>
            <th>Date Reported</th>
            <td>{{pothole.dateReported}}</td>
          </tr>
          <tr>
            <th>Time Reported</th>
            <td>{{pothole.timeReported}}</td>
          </tr>
          <tr>
            <th>Address</th>
            <td>{{pothole.address}}</td>
          </tr>
          <tr>
            <th>Latitude</th>
            <td>{{pothole.latitude}}</td>
          </tr>
          <tr>
            <th>Longitude</th>
            <td>{{pothole.longitude}}</td>
          </tr>
          <tr>
            <th>Size</th>
            <td>{{pothole.size}}</td>
          </tr>
        </table>

      </div>
      <div id="map-description">
        <!-- map and description -->
        <GmapMap
          :center='center'
          :zoom='10'
          style='width:100%;  height: 400px;'
        >
        <GmapMarker
          :key="index"
          :position="place.position"
          @click="center=m.position"
        />
      </GmapMap>
      <p id="description">{{this.pothole.description}}</p>
      </div>
    </div>
    <div id="details-buttons">
      <!-- 3 buttons, edit, delete, status -->
      <button id="edit" class="btn">Edit</button>
      <button id="delete" class="btn" v-on:click="deletePothole">Delete</button>
      <button id="inspected" class="btn">Set As Inspected</button>
      <button id="repaired" class="btn">Set As Repaired</button>
    </div>
  </div>
</template>

<script>
import PotholeService from '../services/PotholeService.js'

export default {
    name: "pothole-details",
    data() {
      return {
        pothole: this.$store.state.potholes.find( pothole => pothole.pothole_id == this.$route.params.id)
      }
    },
    created() {
      this.pothole = this.$store.state.potholes.find( pothole => pothole.pothole_id == this.$route.params.id)
    },
    computed: {
      place() {
        const coords = { lat: this.pothole.latitude, lng: this.pothole.longitude}
        return { position: coords}
      },
      center() {
        return {lat: this.pothole.latitude, lng: this.pothole.longitude}
      }
    },
    methods: {
      deletePothole() {
        alert("Are you sure you want to delete pothole?")
        PotholeService.delete(this.$route.params.id).then( response => {
          if (response.status == 200) {
            this.$store.commit("DELETE_POTHOLE", this.$route.params.id)
            alert("Deleted")
          } else {
            alert("Delete failed")
          }
          this.$router.push('/')
        })
      }
    }
  }
</script>

<style scoped>

#details-main {
  display: flex;
  flex-direction: column;
}

#details-map {
  display: flex;
  flex-direction: row;
}

#details-map > #details {
  flex-grow: 1;
}

#details-map > #map-description {
  width: 180vw;
  flex-grow: 3;
  display: flex;
  flex-direction: column;
}

#description {
  overflow-wrap: break-word;
}

table, th, td{
  display: flex;
  flex-direction: column;
  border: 1px solid black;
  text-align: center;
  padding: .2em
}

/* button:hover {
  background-color:yellow;
} */
</style>
