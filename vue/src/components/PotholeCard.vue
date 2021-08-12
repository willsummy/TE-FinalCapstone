<template>
  <div>
    <div id="card" v-on:click="cardClick">
      <div>
        <div>
          <span class="bold">Pothole ID: </span>
          <span>{{pothole.pothole_id}}</span>
        </div>
        <div>
          <span class="bold">Location: </span>
          <span>{{theLocation}}</span>
        </div>
      </div> 
      <div>
        <div>
          <span class="bold">Severity: </span>
          <span>{{rankDisplay}}</span>
        </div> 
        <div>
          <span class="bold">Size: </span>
          <span>{{pothole.size}}</span>
        </div>

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

.bold {
  font-weight: bold;
}
</style>
