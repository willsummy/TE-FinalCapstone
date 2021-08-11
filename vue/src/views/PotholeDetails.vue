<template>
  <div id="details-main">

    <div id="details-map">

      <div id="map-description">
        <div id="details-buttons" v-if="hasAdminStatus">
      <!-- 3 buttons, edit, delete, status -->
          <button id="edit" v-if="!isEditing" v-on:click='toggleEditing'>Edit</button>
          <button type="submit" id="editSubmit" v-if="isEditing" v-on:click.prevent="toggleEditing(); submitEdit();">Submit Edits</button>
          <button id="editClose" v-if="isEditing" v-on:click="toggleEditing">Discard Edits</button>
          <button id="delete" v-on:click="deletePothole">Delete Pothole</button>


          <button id="createService" v-on:click="createNewService" v-if="!hasService">Start Service</button>
          <button id="deleteService" v-on:click="deleteService" v-if="hasService">Delete Service</button>


            <label for="service_status">Change Service Status</label>
                <select  v-model="newStatus" name="service_status" id="service_status">
                    <option disabled default value="-1">Please select rank</option>
                    <option value="1">Reported, Uninspected</option>
                    <option value="2">Insepcted, Repair Pending</option>
                    <option value="3">Repair Finished</option>
                </select>

            <button id="status-change-btn" v-on:click="setNewStatus">Set New Status</button>
        </div>
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
      <div id="details">

        <!-- everything but description -->
          <span>
            <span>Pothole ID: </span>
            <span>{{pothole.pothole_id}}</span>
          </span>
          <span>
            <span>User ID: </span>
            <span>{{pothole.user_id}}</span>
          </span>
          <span>
            <span>Date Reported: </span>
            <span>{{pothole.dateReported}}</span>
          </span>
          <span>
            <span>Address: </span>
            <span>
              <span v-if="!isEditing">
                {{pothole.address}}
              </span>
              <span v-if="isEditing">
                <input type="text" v-model="submissionPothole.address">
              </span>
            </span>
          </span>
          <span>
            <span >Latitude: </span>
            <span>
              <span v-if="!isEditing">
                {{pothole.latitude}}
              </span>
              <span v-if="isEditing">
                <input type="text" v-model="submissionPothole.latitude">
              </span>
            </span>
          </span>
          <span>
            <span>Longitude: </span>
            <span>
              <span v-if="!isEditing">
                {{pothole.longitude}}
              </span>
              <span v-if="isEditing">
                <input type="text" v-model="submissionPothole.longitude">
              </span>
            </span>
          </span>
          <span>
            <span>Size: </span>
            <span>
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
            </span>
          </span>
          
          <span>
            <span >Rank: </span>
            <span>
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
            </span>
          </span>
          <span>
            <span>Service Status: </span>
            <span>{{serviceStatus}}</span>
          </span>
        

      </div>

    </div>

  </div>
</template>

<script>
import PotholeService from '../services/PotholeService.js'
import ServiceService from '../services/ServiceService.js'

export default {
    name: "pothole-details",

    data() {
      return {
        isEditing: false,
        pothole:{

        },

        submissionPothole: {
        },

        newStatus: null
      }
    },
    created() {
      this.refreshPotholes().then( () => {
        this.pothole = this.$store.state.potholes.find( pothole => pothole.pothole_id == this.$route.params.id);
      });
      this.refreshServices()


    },
    computed: {
      place() {
        const coords = { lat: this.pothole.latitude, lng: this.pothole.longitude}
        return { position: coords}
      },
      rankDisplay() {
        if (this.pothole.rank < 0) {
          return "Pothole Unranked"
        } else return this.pothole.rank
      },
      hasAdminStatus() {
        return this.$store.state.user.authorities[0].name === "ROLE_ADMIN"
      },
      hasService() {
        return !(this.$store.state.currentServices == null || this.$store.state.currentServices == '')
      },
      serviceStatus() {
        if (this.$store.state.currentServices == null || this.$store.state.currentServices == '') return "No Service Started"
        return this.$store.state.currentServices.service_status_id
      },
      center() {
        return {lat: this.pothole.latitude, lng: this.pothole.longitude}
      }
    },
    methods: {
      deletePothole() {
        ServiceService.deleteServicesByPothole(this.$route.params.id).then( response => {
          if(response.status == 200) {
            PotholeService.delete(this.$route.params.id).then( response => {
              if (response.status == 200) {
                this.$store.commit("DELETE_POTHOLE", this.$route.params.id)
                this.$store.commit("DELETE_SERVICE")
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
      },
        setNewStatus() {

          let editedService = this.$store.state.currentServices
          editedService.service_status_id = this.newStatus

            ServiceService.setStatus(editedService).then( response => {
                if(response.status == 200) {
                    this.refreshServices();
                } else alert("Could not update Service Status")
            })
        },
        deleteService() {
            ServiceService.deleteService(this.$store.state.currentServices.service_id).then( response => {
                if( response.status == 200 ) {
                    alert("Pothole Service Deleted")
                    this.refreshServices()
                } else alert("Delete unsuccessful")
            })
        },
    }
  }

</script>

<style scoped>
#details-map {
  display: flex;
  flex-direction: row;
}

#map-description {
  flex-grow: 1;
  width: 100%;
  display: flex;
  flex-direction: column;
}

#details {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  width: 100%;
}
</style>
