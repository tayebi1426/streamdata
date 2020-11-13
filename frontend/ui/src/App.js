import React, {Suspense} from 'react';
import {BrowserRouter} from 'react-router-dom';
import {Provider} from "react-redux";
import {SwitchRouter,XhrRequest} from './components'
import configStore from './redux'
import appRoutes from './routing'
import axios from 'axios'
import Security from "./service/SecurityService";
import './assets'
XhrRequest.registerResponseInterceptors();
/*
axios.interceptors.request.use((config) => {
    console.log('axios pre send request',config);
    const userAccount =  Security.getUserAccount();
    if ( userAccount && userAccount['access_token'] != null ) {
        config.headers.Authorization = `Bearer ${userAccount['access_token']}`;
    }
    return config;
}, (error) => {

    console.debug('error : ',error);

    return Promise.reject(error);
});
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