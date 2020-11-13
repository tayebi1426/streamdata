import React from 'react'
import DefaultLayout from "../pages/layouts/DefaultLayout";

let LoginPage = React.lazy(() => import("../pages/LoginPage"));
let PersonList = React.lazy(() => import("../pages/PersonList"));
let AddPerson = React.lazy(() => import("../pages/AddPerson"));

const MAIN_ROUTES = [
    {path: '/person', component: PersonList,authorities:['ADMIN_USER']},
    {path: '/person/new', component: AddPerson,authorities:['ADMIN_USER']}
];

const Layout = (props) => <DefaultLayout {...props} mainRoutes={MAIN_ROUTES}/>;

const APP_ROUTES = [
    {path: '/login', component: LoginPage},
    {path: '/404', component: null},
    {path: '/', exact: false, component: Layout,authorities:['ADMIN_USER']}
];

export default APP_ROUTES;