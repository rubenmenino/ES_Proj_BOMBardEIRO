import axios from 'axios'

const FIREFIGHTERS_API_BASE_URL = "http://localhost:8091/fighters/env";

class FireServices {
    getFireEnv() {
        return axios.get(FIREFIGHTERS_API_BASE_URL);
    }
}

export default new FireServices();
