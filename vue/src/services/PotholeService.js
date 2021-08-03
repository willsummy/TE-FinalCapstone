import axios from 'axios'

export default {
    add(pothole) {
        return axios.post('/pothole', pothole)
    }
}
