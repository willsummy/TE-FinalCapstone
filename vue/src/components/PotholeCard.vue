<template>
  <div>
    <div id="card" v-on:click="cardClick">
      <table id="potholecardtable">
          <tr id="potholecardtable">
            <th>Pothole ID</th>
            <td>{{pothole.pothole_id}}</td>
          </tr>
          <tr id="potholecardtable">
            <th>User ID</th>
            <td>{{pothole.user_id}}</td>
          </tr>
          <tr id="potholecardtable">
            <th>Date Reported</th>
            <td>{{pothole.dateReported}}</td>
          </tr>
          <tr id="potholecardtable">
            <th>Time Reported</th>
            <td>{{pothole.timeReported}}</td>
          </tr>
          <tr id="potholecardtable">
            <th>Address</th>
            <td>{{pothole.address}}</td>
          </tr>
          <tr id="potholecardtable">
            <th>Latitude</th>
            <td>{{pothole.latitude}}</td>
          </tr>
          <tr id="potholecardtable">
            <th>Longitude</th>
            <td>{{pothole.longitude}}</td>
          </tr>
          <tr id="potholecardtable">
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
          this.$router.push(`/pothole/${this.pothole.pothole_id}`)
      }
    },
    computed: {
      rankDisplay() {
        if (this.pothole.rank < 0) {
          return "Pothole Unranked"
        } else return this.pothole.rank
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

#potholecardtable{
  display: flex;
  flex-direction: column;
  border: 1px solid #FF7D00 ;
  text-align: center;
  padding: .2em;
}
</style>
