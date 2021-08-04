<template>
  <div id="master">
      <form id="form" v-on:submit.prevent>
          <div>
              <label for="size">Size</label>
              <select v-model="pothole.size" name="size" id="size">
                  <option disabled default value="">Please select size</option>
                  <option value="small">Small</option>
                  <option value="medium">Medium</option>
                  <option value="large">Large</option>
              </select>
          </div>
          <div>
            <h2>Search and add a pin</h2>
            <GmapAutocomplete
                @place_changed='setAddress'
            />
          </div>
          <div>
              
              <textarea v-model="pothole.description" name="description" id="description" cols="30" rows="10" placeholder="Please write a description"></textarea>
          </div>
          <div>
              <button v-on:click="submit" type="submit">Submit</button>
          </div>

      </form>

  </div>
</template>

<script>
//import PotholeService from '../services/PotholeService.js'

export default {
    name: "pothole-form",
    data() {
        return {
            pothole: {
                size: "",
                description: "",
                lat: null,
                lng: null,
                address: null

            }
        }
    },

    methods: {
        submit() {
            console.log(this.pothole.lat())
            // PotholeService
            //     .add(this.pothole)
            //     .then( response => {
            //         if (response.status == 201) {
            //             alert('Pothole Reported')
            //         } else {
            //             alert('Server not set up yet')
            //         }
            //         this.$router.push('/')

            //     })
        },
        setAddress(place) {
            this.pothole.address = place.formatted_address;
            this.pothole.lat = place.geometry.location.lat();
            this.pothole.lng = place.geometry.location.lng();
        }

    }

}
</script>

<style>

#master {
    display: flex;
    flex-direction: column;
    align-items: center;
    
  }
  #form {
    display: flex;
    flex-direction: column;
    align-items: center;
    align-content: space-around;
    margin: auto;
    border-style: groove;
    border-color: black;
    padding-left: 150px;
    padding-right: 150px;
    padding-bottom: 50px;
    
  }

</style>
