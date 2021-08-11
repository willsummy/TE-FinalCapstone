<template>
  <div>
    <div id="card" v-on:click="cardClick">
      <div>
        <span>Pothole ID: {{pothole.pothole_id}}</span>
        <span>Location: {{theLocation}}</span>
      </div> 
      <div>
        <span>Severity: {{rankDisplay}}</span>
        <span>Size: {{pothole.size}}</span>
      </div>
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
      },
      theLocation() {
        if (this.pothole.address.length <= 0) {
          return this.pothole.latitude + ", " + this.pothole.longitude
        } else return this.pothole.address
      }
    }

}
</script>

<style>
#card {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  background-color: #FF7D00;
  margin: 5px;
  padding: 15px;
  border-radius: 20px;
  box-shadow: 5px 5px #15616D;
  width: 80%;

}

#card > div {
  display: flex;
  flex-direction: column;
}

#potholecardtable{
  display: flex;
  flex-direction: column;
  border: 1px solid #FF7D00 ;
  text-align: center;
  padding: .2em;
}
</style>
