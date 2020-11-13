import {XhrRequest} from '../components'

const BACKEND_URL = 'http://127.0.0.1:9001';

class ZoneService {
    static getProvince = () => {
       return XhrRequest.get(`${BACKEND_URL}/zone/province`);
    }
}

export default ZoneService;