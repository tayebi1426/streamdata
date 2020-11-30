import React from 'react'
import DefaultLayout from "../views/layouts/DefaultLayout";

let LoginPage = React.lazy(() => import("../views/LoginPage"));
let PersonList = React.lazy(() => import("../views/PersonList"));
let AddPerson = React.lazy(() => import("../views/AddPerson"));
let JsonSchemaEditor = React.lazy(() => import("../views/jsonschema/JsonSchemaEditor"));

const MAIN_ROUTES = [
    {path: '/person', component: PersonList,authorities:['ADMIN_USER']},
    {path: '/person/new', component: AddPerson,authorities:['ADMIN_USER']},
    {path: '/json/jsonSchemaEditor', component: JsonSchemaEditor}
];

const Layout = (props) => <DefaultLayout {...props} mainRoutes={MAIN_ROUTES}/>;

const APP_ROUTES = [
    {path: '/login', component: LoginPage},
    {path: '/404', component: null},
    {path: '/', exact: false, component: Layout}
];

export default APP_ROUTES;