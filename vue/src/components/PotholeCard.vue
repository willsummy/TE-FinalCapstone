<template>
  <div>
    <div id="card" v-on:click="cardClick">
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

table, th, td{
  display: flex;
  flex-direction: column;
  border: 1px solid black;
  text-align: center;
  padding: .2em;
}
</style>
