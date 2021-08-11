<template>
<div id="googlemap">
    <div id="map">
        <div id="report-filter">
            <div>
                <button id="toggleReport" v-on:click="toggleReport" v-if="!isReportOpen">Report A Pothole</button>
                <button id="closeForm" v-on:click="toggleReport" v-if="isReportOpen">Close Report</button>
            </div>



            <select  v-model="filterType" name="filterType" id="filterType">
                <option disabled default value="">Please select type of filter</option>
                <option value="zipcode">Zipcode</option>
                <option value="city">City</option>
                <option value="user_id">My Submissions</option>
            </select>


            <div id="zipfilter" v-if="filterType == 'zipcode'">
                <label for="zipcode">Filter by Zipcode</label>
                <input type="text" id="zipcode" v-model="zipcode" />
                <button type="submit" v-on:click.prevent="set_filter(zipcode)">Filter</button>
                <button type="submit" v-on:click.prevent="reset_filter">View All</button>
            </div>

            <div id="cityfilter" v-if="filterType == 'city'">
                <label for="city">Filter by City</label>
                <input type="text" id="city" v-model="city" />
                <button type="submit" v-on:click.prevent="set_filter(city)">Filter</button>
                <button type="submit" v-on:click.prevent="reset_filter">View All</button>
            </div>

            <div id="userfilter" v-if="filterType == 'user_id'">
                <label for="user_id">My Submissions</label>
                <button type="submit" v-on:click.prevent="set_filter(city)">Filter</button>
                <button type="submit" v-on:click.prevent="reset_filter">View All</button>
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
            isReportOpen: false
        }
    },
    components: {
        GoogleMap,
        PotholeList,
        PotholeForm

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
    height: 400px;
}

#map {
    width: 100%;
    height: inherit;
}

#map-form {
    flex-grow: 1;
    width: 100%;
    height: inherit;
    border-style: solid;
}

#list {
    flex-grow: 1;
    width: 100%;
    height: inherit;
    overflow-y: scroll;
}

#report-filter {
    display: flex;
    justify-content: space-between;
}

</style>
