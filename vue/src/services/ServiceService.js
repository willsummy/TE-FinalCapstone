import axios from 'axios'

export default {
    createService(newService) {
        return axios.post("/service", newService)
    },
    getList(pothole_id) {
        return axios.get(`/services/${pothole_id}`)
    }
}
