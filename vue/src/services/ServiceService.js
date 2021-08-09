import axios from 'axios'

export default {
    createService(newService) {
        return axios.post("/service", newService)
    },
    getList(pothole_id) {
        return axios.get(`/service/${pothole_id}`)
    },
    deleteService(pothole_id) {
        return axios.delete(`/service/${pothole_id}`)
    },
    setAsInspected(service_id) {
        return axios.put(`/service/${service_id}/inspected`)
    },
    setAsRepaired(service_id) {
        return axios.put(`service/${service_id}/repaired`)
    }
}
