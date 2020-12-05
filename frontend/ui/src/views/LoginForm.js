import React, {useState} from "react";
import PropTypes from "prop-types";
import {Button, Col, Field, Form, I18Massage, Input, Link, Row} from "../components";
import SecurityService from '../service/SecurityService'


const LOGIN_FORM_RULES = {
    username: 'required',
    password: 'required'
};

const LoginForm = ({onLoginSuccess}) => {
    const [invalidLogin, setInvalidLogin] = useState(null);
    const onLogin = ({username, password}) => {
        setInvalidLogin(null);
        SecurityService.login(username, password)
            .then(onLoginSuccess)
            .catch((errorMessage) => {
                setInvalidLogin(errorMessage);
            });
    };
    return <Form initialValues={{username: 'admin', password: 'Admin@1234_'}}
                 validationRules={LOGIN_FORM_RULES}
                 onSubmit={onLogin}>
        <Row>
            <Col className='invalidLoginMessage mt-3'>
                {invalidLogin &&
                <I18Massage code={invalidLogin}/>}
            </Col>
        </Row>
        <Row>
            <Field className='col-10 offset-1' name="username" label="loginPage.username">
                <Input/>
            </Field>
        </Row>
        <Row>
            <Field className='col-10 offset-1' name="password" label="loginPage.password">
                <Input type='password'/>
            </Field>
        </Row>
        <Row className="mt-2 mb-4">
            <Col className="col-6 offset-1">
                <Link to='/forgotPassword' title='loginPage.forgotPassword'/>
            </Col>
        </Row>
        <Row className="mb-5">
            <Col className='col-10 offset-1'>
                <Button type='submit'
                        isPrimary={true}
                        title='loginPage.login'
                        className='w-100'/>
            </Col>
        </Row>
    </Form>
};
LoginForm.propTypes = {
    onLoginSuccess: PropTypes.func
};
export default LoginForm;
