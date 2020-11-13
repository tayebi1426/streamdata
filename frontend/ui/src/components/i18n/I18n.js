import I18n from "i18next"
import I18nBackend from "./I18nBackend";
import {initReactI18next} from 'react-i18next'

let options = {
    initImmediate: false,
    preload: ['fa'],
    lng: 'fa',
    fallbackLng: 'fa',
    ns: ['app','error'],
    defaultNS: 'app',
    fallbackNS: false,
    debug: true
};

I18n.use(initReactI18next)
    .use(I18nBackend)
    .init(options);

export default I18n;