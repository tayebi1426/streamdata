import {XhrRequest} from '../components'

const BACKEND_URL = 'http://127.0.0.1:9001';

class PersonService {
   static save = (person) => {
        return XhrRequest.post(`${BACKEND_URL}/person/save`, person);
    }
}

export default PersonService;