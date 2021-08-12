<template>
<div id="googlemap">
    <div id="map">
        <div id="report-filter" v-if="hasUserStatus">
            <div>
                <button id="toggleReport" v-on:click="toggleReport" v-if="!isReportOpen">Report A Pothole</button>
                <button id="closeForm" v-on:click="toggleReport" v-if="isReportOpen">Close Report</button>
            </div>

            <button id="filterbutton" type="submit" v-on:click.prevent="reset_filter">View All</button>

            <select class="filterSelect" v-model="filterType" name="filterType" id="filterType">
                <option disabled default value="">Please select type of filter</option>
                <option value="zipcode">Zipcode</option>
                <option value="city">City</option>
                <option value="user_id">My Submissions</option>
            </select>


            <div id="zipfilter" v-if="filterType == 'zipcode'">
                <label for="zipcode">Filter by Zipcode</label>
                <input type="text" id="filterinput" v-model="zipcode" />
                <button id="filterbutton" type="submit" v-on:click.prevent="set_filter(zipcode)">Filter</button>
               
            </div>

            <div id="cityfilter" v-if="filterType == 'city'">
                <label for="city">Filter by City</label>
                <input type="text" id="filterinput" v-model="city" />
                <button id="filterbutton" type="submit" v-on:click.prevent="set_filter(city)">Filter</button>
                
            </div>

            <div id="userfilter" v-if="filterType == 'user_id'">
                <label for="user_id">My Submissions</label>
                <button id="filterbutton" type="submit" v-on:click.prevent="set_filter(city)">Filter</button>
                
            </div>
        </div>
        <div id="map-form">
            <GoogleMap v-if="!isReportOpen" />
            <pothole-form v-if="isReportOpen" />
        </div>

    </div>
    <div id="list">
        <pothole-list v-bind:potholes="$store.state.potholes"/>
    </div>

</div>
</template>

<script>
import PotholeForm from '../components/PotholeForm'
import GoogleMap from '../components/GoogleMap.vue'
import PotholeList from '../components/PotholeList.vue';
import PotholeService from '../services/PotholeService.js'

export default {
    name: "view-potholes",
    data() {
        return {
            zipcode: '',
            city: '',
            user_id: null,
            filterType: '',
            isReportOpen: false,

        }
    },
    components: {
        GoogleMap,
        PotholeList,
        PotholeForm

    },
    computed: {
        hasUserStatus() {
        return this.$store.state.token !== ""
      },
    },
    methods: {
        set_filter(filter) {
            this.$store.commit("SET_FILTER", {"filter": filter, "filterType": this.filterType})
        },
        reset_filter() {
            this.$store.commit("RESET_FILTER")
            this.$store.commit("RESET_FILTER_TYPE")
            this.zipcode = ''
        },
        toggleReport() {
            this.isReportOpen = !this.isReportOpen
        }
    },
    created() {
        this.$store.commit("RESET_FILTER")
        let potholes = null;
        PotholeService.getList().then(response => {
        potholes = response.data;
        this.$store.commit("SET_POTHOLES", potholes)
    })

  }


}
</script>

<style>

#googlemap {
    display: flex;
    flex-direction: row;
    height: 600px;
}

#map {
    width: 100%;
    height: 100%;
}

#map-form {
    flex-grow: 1;
    width: 100%;
    height: 96%;
}

#list {
    flex-grow: 1;
    width: 100%;
    height: inherit;
    overflow-y: scroll;
}

#list::-webkit-scrollbar {
    background: #FF7D00;
    width: 20px;
    
}

#list::-webkit-scrollbar-track {
    border-radius: 10px;
}

#list::-webkit-scrollbar-thumb {
    background: #15616D;
    border-radius: 10px;
}

#list::-webkit-scrollbar-thumb:hover {
    background: #001524;
}
#report-filter {
    display: flex;
    justify-content: space-between;
    margin-bottom: 5px;
}

#filterbutton{
    font-family: 'Encode Sans', sans-serif;
}

#filterbutton:hover {
    background-color: #ffecd1;
    
}

#filterinput {
    background-color: #ffecd1;
    
}

#toggleReport, .filterSelect, #zipfilter, #cityfilter, #userfilter, #closeForm {

  font-family: 'Encode Sans', sans-serif;
  background-color: #FF7D00;
  border-radius: 25px;
  box-shadow: 5px 5px #15616D;
  padding: 10px;
}


</style>
