import axios from 'axios'

export default {
    createService(newService) {
        return axios.post("/service", newService)
    },
    getList(pothole_id) {
        return axios.get(`/service/${pothole_id}/list`)
    },
    deleteService(id) {
        return axios.delete(`/service/${id}`)
    },
    deleteServicesByPothole(pothole_id) {
        return axios.delete(`/service-all/${pothole_id}`)
    },
    setStatus(service) {
        return axios.put('/service/status', service)
    }
}
