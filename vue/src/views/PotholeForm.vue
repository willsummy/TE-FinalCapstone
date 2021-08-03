<template>
  <div>
      <form v-on:submit.prevent>
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
              <label for="description">Description</label>
              <textarea v-model="pothole.description" name="description" id="description" cols="30" rows="10"></textarea>
          </div>
          <div>
              <button v-on:click="submit" type="submit">Submit</button>
          </div>

      </form>

  </div>
</template>

<script>
import PotholeService from '../services/PotholeService.js'

export default {
    name: "pothole-form",
    data() {
        return {
            pothole: {
                size: "",
                description: "",

            }
        }
    },

    methods: {
        submit() {

        },

    }

}
</script>

<style>

</style>,