import axios from 'axios'


export default {
    add(pothole) {
        return axios.post('/pothole', pothole,)
    },

    getList() {
        return axios.get('/pothole')
    },

    delete(id) {
        return axios.delete(`/pothole${id}`)
    }
}
