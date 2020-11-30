import React from "react";
import PropTypes from "prop-types";
import {Card, Col, Row} from "../components";
import {SUCCESS_LOGIN_URL} from './ApplicationConfig'
import LoginForm from './LoginForm'
import '../assets/css/sass/login.scss'

const LoginPage = ({history}) => {
    const onLoginSuccess = () => {
        history.push(SUCCESS_LOGIN_URL);
    };
    return <Row className='h-100'>
        <Col className="login-form" lg={3} md={3} sm={6} xs={12}>
            <Card>
                <Row>
                    <div style={{margin: 'auto'}}>
                        <img id='avatar' alt='avatar'/>
                    </div>
                </Row>
                <LoginForm onLoginSuccess={onLoginSuccess}/>
            </Card>
        </Col>
    </Row>
};
LoginPage.propTypes = {
    history: PropTypes.object
};
export default LoginPage;
