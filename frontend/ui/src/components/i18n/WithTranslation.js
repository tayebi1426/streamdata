import React from 'react';
import {withTranslation} from 'react-i18next';

export default (Component, ns) => {
    return withTranslation()(({tReady : ignored,i18n, ...restProps}) => <Component  {...restProps}/>)

    //return withTranslation(ns)(Component)
}