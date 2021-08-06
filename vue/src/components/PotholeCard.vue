<template>
  <div>
    <div id="card" v-on:click="cardClick">
      <p>Pothole: {{pothole.pothole_id}}</p>
      <p>{{pothole.user_id}}</p>
      <p>{{pothole.date_reported}}</p>
      <p>{{pothole.time_reported}}</p>
      <p>{{pothole.address}}</p>
      <p>{{pothole.latitude}}</p>
      <p>{{pothole.longitude}}</p>
      <p>{{pothole.description}}</p>
      <p>{{pothole.size}}</p>
    </div>

  </div>
</template>

<script>

export default {
    name: 'pothole-card',
    props: ['pothole'],
    methods: {
      cardClick() {
        if (this.$store.state.user.authorities[0].name === "ROLE_ADMIN") {
          this.$router.push(`/pothole/${this.pothole.pothole_id}`)
        } else {
          const splitAddress = this.pothole.address.split(",");
          const splitZip = splitAddress[splitAddress.length - 2].split(" ")
          const zipcode = splitZip[2];
          this.$store.commit("SET_ZIP_FILTER", zipcode)
        }
      }
    }

}
</script>

<style>
#card {
  background-color: lightgray;
  margin: 5px;
  padding: 5px;
  width: 80%;
}
</style>
