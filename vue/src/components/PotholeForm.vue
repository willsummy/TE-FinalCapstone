<template>
  <div id="master">
      <form id="form" class="reportPothole" v-on:submit.prevent>
          <div id="sizeSelect">
              <label for="size">Size</label>
              <select v-model="pothole.size" name="size" id="size">
                  <option disabled default value="">Please select size</option>
                  <option value="small">Small</option>
                  <option value="medium">Medium</option>
                  <option value="large">Large</option>
              </select>
          </div>

          <div >

            <GmapAutocomplete v-if="!useCurrentLocation"
                @place_changed='setAddress'
            />
            <span v-if="useCurrentLocation" >Current Location Being Used</span>
            <button id="filterbutton" v-if="!useCurrentLocation" v-on:click="useCurrentLocation = !useCurrentLocation; geolocate()">Use Current Location</button>
            <button id="filterbutton" v-if="useCurrentLocation" v-on:click="useCurrentLocation = !useCurrentLocation">Lookup Address</button>
          </div>
          <div>

              <textarea v-model="pothole.description" name="description" id="description" cols="30" rows="10" placeholder="Please write a description"></textarea>
          </div>
          <div>
              <button id="filterbutton" v-on:click="submit" type="submit">Submit</button>
          </div>

      </form>

  </div>
</template>

<script>
import PotholeService from '../services/PotholeService.js'
import ServiceService from '../services/ServiceService.js'

export default {
    name: "pothole-form",
    data() {
        return {
            pothole: {
                size: "",
                description: "",
                latitude: null,
                longitude: null,
                address: null,
                user_id: this.$store.state.user.id

            },
            useCurrentLocation: false
        }
    },

    methods: {
        geolocate() {
            navigator.geolocation.getCurrentPosition(position => {
                this.pothole.address = ''
                this.pothole.latitude = position.coords.latitude
                this.pothole.longitude = position.coords.longitude

            });
        },
        submit() {
            PotholeService
                .add(this.pothole)
                .then( response => {
                    if (response.status == 201) {
                        alert('Pothole Reported')

                        this.refreshPotholes();
                        this.refreshServices();
                    } else if (response.status != 500) {
                        alert('Server not set up yet')
                    }

                })
        },
        setAddress(place) {
            this.pothole.address = place.formatted_address;
            this.pothole.latitude = place.geometry.location.lat();
            this.pothole.longitude = place.geometry.location.lng();
        },
        refreshPotholes() {
            let potholes = null;
            PotholeService.getList().then(response => {
                potholes = response.data;
                this.$store.commit("SET_POTHOLES", potholes)
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

    },
    created() {
      let potholes = null;
      PotholeService.getList().then(response => {
        potholes = response.data;
        this.$store.commit("SET_POTHOLES", potholes)
      })

    }

}
</script>

<style>

.reportPothole {
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: 40%;
  padding: 15px;
  background-color: #FF7D00 ;
  border: 5px solid #78290F;
  border-radius: 15px;
  margin-top: 10px;
}

#sizeSelect {
     font-family: 'Encode Sans', sans-serif;
  background-color: #FF7D00;
  border-radius: 25px;
  
 
}


</style>
