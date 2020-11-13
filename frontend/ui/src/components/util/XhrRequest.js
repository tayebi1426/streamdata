import axios from 'axios'

const POST_METHOD = 'POST';

const METHOD_CONFIG_NAME = 'method';
const DEFAULT_POST_HEADER = {'Content-Type': 'application/json; charset=utf-8'};

const DEFAULT_REQUEST_TIMEOUT = process.env['REACT_APP_DEFAULT_REQUEST_TIMEOUT'];

axios.defaults.headers.post = DEFAULT_POST_HEADER;
axios.defaults.headers.put = DEFAULT_POST_HEADER;
axios.defaults.timeout = DEFAULT_REQUEST_TIMEOUT || 10000;

class XhrRequest {

    static get(url, params, headers) {
        return XhrRequest.callRequest(XhrRequest.createRequest({url, params, headers}))
    }

    static post(url, data, headers) {
        let req = XhrRequest.createRequest({url, [METHOD_CONFIG_NAME]: POST_METHOD, data, headers});
        return XhrRequest.callRequest(req);
    }

    static createRequest(config) {
        return axios.request(config);
    }

    static callRequest(promise) {
        return promise.then(response => response.data);
    }

    static setBaseURL(baseURL) {
        axios.defaults.baseURL = baseURL;
    }

    static updateDefaultHeader(header) {
        axios.defaults.headers = Object.assign({}, axios.defaults.headers, header)
    }

    static registerRequestInterceptors(onFulfilled, onRejected) {
        if (!onFulfilled) {
            onFulfilled = (config) => {
                return config;
            }
        }
        if (!onRejected) {
            onRejected = (error) => {
                return Promise.reject(error);
            }
        }
        axios.interceptors.request.use(onFulfilled, onRejected);
    }

    static registerResponseInterceptors(onFulfilled, onRejected) {
        if (!onFulfilled) {
            onFulfilled = (config) => {
                return config;
            }
        }
        if (!onRejected) {
            onRejected = (error) => {
                console.debug('error : ',error);
                return Promise.reject(error);
            }
        }
        axios.interceptors.response.use(onFulfilled, onRejected);
    }
}


export default XhrRequest;
