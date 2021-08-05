import axios from 'axios'


export default {
    add(pothole) {
        return axios.post('/pothole', pothole,)
    },

    getList(pothole) {
        return axios.get('/pothole')
    }
}
