<template>
  <div id="details-main">
    <div id="details-map">
      <div id="details">
        <!-- everything but description -->
        <table>
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
            <th>Address</th>
            <td>
              <span v-if="!isEditing">
                {{pothole.address}}
              </span>
              <span v-if="isEditing">
                <input type="text" v-model="submissionPothole.address">
              </span>
            </td>
          </tr>
          <tr>
            <th >Latitude</th>
            <td>
              <span v-if="!isEditing">
                {{pothole.latitude}}
              </span>
              <span v-if="isEditing">
                <input type="text" v-model="submissionPothole.latitude">
              </span>
            </td>
          </tr>
          <tr>
            <th>Longitude</th>
            <td>
              <span v-if="!isEditing">
                {{pothole.longitude}}
              </span>
              <span v-if="isEditing">
                <input type="text" v-model="submissionPothole.longitude">
              </span>
            </td>
          </tr>
          <tr>
            <th>Size</th>
            <td>
              <span v-if="!isEditing">
                {{pothole.size}}
              </span>
              <span v-if="isEditing">
                <label for="size">Size</label>
                <select v-model="submissionPothole.size" name="size" id="size">
                    <option disabled default value="">Please select size</option>
                    <option value="small">Small</option>
                    <option value="medium">Medium</option>
                    <option value="large">Large</option>
                </select>
              </span>
            </td>
          </tr>
          <tr>
            <th >Rank</th>
            <td>
              <span v-if="!isEditing">
                {{rankDisplay}}
              </span>
              <span v-if="isEditing">
                <label for="rank">Rank</label>
                <select  v-model="submissionPothole.rank" name="rank" id="rank">
                    <option disabled default value="-1">Please select rank</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                </select>
              </span>
            </td>
          </tr>
        </table>

      </div>
      <div id="map-description">
        <!-- map and description -->
        <GmapMap
          :center='center'
          :zoom='15'
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
      <button id="edit" v-if="!isEditing" v-on:click='toggleEditing'>Edit</button>
      <button type="submit" id="editSubmit" v-if="isEditing" v-on:click.prevent="toggleEditing(); submitEdit();">Submit Edits</button>
      <button id="editClose" v-if="isEditing" v-on:click="toggleEditing">Discard Edits</button>

      <button id="delete" v-on:click="deletePothole">Delete</button>
      <button id="createService" v-on:click="createNewService">Create New Service</button>
    </div>

    <div>
      <service-list />
    </div>
  </div>
</template>

<script>
import PotholeService from '../services/PotholeService.js'
import ServiceService from '../services/ServiceService.js'
import ServiceList from '../components/ServiceList.vue'

export default {
    name: "pothole-details",
    components: {
      ServiceList
    },
    data() {
      return {
        isEditing: false,
        pothole: this.$store.state.potholes.find( pothole => pothole.pothole_id == this.$route.params.id),

        submissionPothole: {
        }
      }
    },
    created() {
      this.refreshPotholes();
      this.refreshServices();


    },
    computed: {
      place() {
        const coords = { lat: this.pothole.latitude, lng: this.pothole.longitude}
        return { position: coords}
      },
      center() {
        return {lat: this.pothole.latitude, lng: this.pothole.longitude}
      },
      rankDisplay() {
        if (this.pothole.rank < 0) {
          return "Pothole Unranked"
        } else return this.pothole.rank
      }
    },
    methods: {
      deletePothole() {
        ServiceService.deleteServicesByPothole(this.$route.params.id).then( response => {
          if(response.status == 200) {
            PotholeService.delete(this.$route.params.id).then( response => {
              if (response.status == 200) {
                this.$store.commit("DELETE_POTHOLE", this.$route.params.id)
                alert("Deleted")
                this.$router.push('/')
              } else {
                alert("Delete pothole failed")
              }
              this.$router.push('/')
            })
          } else alert("Could not delete Services")
        })


      },
      toggleEditing() {
        this.isEditing = !this.isEditing
      },
      submitEdit() {
        PotholeService.edit(this.submissionPothole)
          .then(response => {
            if(response.status == 200) {
              this.refreshPotholes();
            } else alert("Edit Failed")
          })
      },
      refreshPotholes() {
        let potholes = null;
        PotholeService.getList().then(response => {
          potholes = response.data;
          this.$store.commit("SET_POTHOLES", potholes);
          this.pothole = this.$store.state.potholes.find( pothole => pothole.pothole_id == this.$route.params.id);
          this.submissionPothole = {

              pothole_id: this.pothole.pothole_id,
              user_id: this.pothole.user_id,
              address: this.pothole.address,
              latitude: this.pothole.latitude,
              longitude: this.pothole.longitude,
              size: this.pothole.size,
              rank: this.pothole.rank,
              description: this.pothole.description,
              date_reported: this.pothole.dateReported,
              time_reported: this.pothole.timeReported
          }
        })
      },
      createNewService() {
        let newService = {
          pothole_id: this.pothole.pothole_id,
          employee_id: this.$store.state.user.id,
          date_reported: this.pothole.dateReported
        }
        ServiceService.createService(newService)
          .then( response => {
            if(response.status == 201) {
              alert("Service Created")
              this.refreshServices()
            } else alert("Service not created")
          })
      },
      refreshServices() {
        ServiceService.getList(this.$route.params.id)
        .then( response => {
          if (response.status == 200) {
            this.$store.commit("SET_SERVICES", response.data)
          } else {
            alert("Could not retrieve Services")
          }
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
#details-map > #map-description {
  margin: .2em;
  width: 100%;
  display: flex;
  flex-direction: column;
}

#description {
  word-wrap: break-word;
  background-color:  rgb(200,200,200);
  border-radius: 3px;
  flex-grow: 1;
  margin-bottom: 0px;
  padding: .2em;
}

#map {
  flex-grow: 2;
}

table, th, td{
  display: flex;
  flex-direction: column;
  border: 1px solid black;
  text-align: center;
  margin: .2em;
  background-color:  rgb(200,200,200);
}

#details-buttons {
  margin: .2em;
}

/* button:hover {
  background-color:yellow;
} */
</style>
