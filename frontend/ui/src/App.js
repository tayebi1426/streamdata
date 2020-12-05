import React, {Suspense} from 'react';
import {BrowserRouter} from 'react-router-dom';
import {Provider} from "react-redux";
import axios from "axios";
import {SwitchRouter} from './components'
import configStore from './redux'
import appRoutes from './routing'
import './assets'

import SecurityService from './service/SecurityService'

SecurityService.inti();

axios.interceptors.request.use((config) => {
    console.log('axios pre send request', config);
    const userAccessToken = SecurityService.getUserAccessToken();
    if (userAccessToken) {
        config.headers.Authorization = `Bearer ${userAccessToken}`;
    }

    return config;
}, (error) => {

    console.debug('error : ', error);

    return Promise.reject(error);
});
/*

axios.interceptors.response.use((config) => {
    console.log('axios pre send request',config);

}, (error) => {
    console.debug('error : ',error);
if(error.response.status)
    return Promise.reject(error);
});
*/


const appStore = configStore();

const PageLoading = () => <div>Loading...</div>;

const App = () => {
    document.body.classList.add("rtl");
    document.body.classList.remove("ltr");

    return <Provider store={appStore}>
        <BrowserRouter>
            <Suspense fallback={<PageLoading/>}>
                <SwitchRouter routes={appRoutes}/>
            </Suspense>
        </BrowserRouter>
    </Provider>
};

export default App;