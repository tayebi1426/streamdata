import React from "react";
import {Button, Card, Checkbox, Field, Fieldset, Form, Row, Select, TextArea} from "../components";
import PersonService from '../service/PersonService'
import ZoneService from '../service/ZoneService'
import ZoneDataList from './data/zone.json'
import GenderDataList from './data/gender.json'
import messageService from "../service/messageService";

const ADD_ACCOUNT_RULES = {
    firstName: 'required',
    lastName: 'required',
    nationalCode: 'required|numeric',
    birthDate: 'required|date'
};

class AddPerson extends React.Component {
    initPersonData = {
        firstName: 'hadi',
        lastName: 'tayebi',
        fatherName: 'mohammad',
        nationalCode: '1861274629',
        birthDate: new Date(),
        gender: null,
        marriedState: true,
        contact: {
            mobile: '09307777245',
            tel: '09307777245',
            email: 'h.tayebi@demisc.com'
        },
        address: {
            province: {
                "id": 1,
                "code": "TEHRAN",
                "title": "تهران",
                "cities": [
                    {
                        "id": 1,
                        "code": "TEHRAN",
                        "title": "تهران"
                    },
                    {
                        "id": 1,
                        "code": "DAMAVAND",
                        "title": "دماوند"
                    },
                    {
                        "id": 1,
                        "code": "RODEHEN",
                        "title": "رودهن"
                    }
                ]
            },
            city:  {
                "id": 1,
                "code": "TEHRAN",
                "title": "تهران"
            },
            postalCode: 1234567890,
            fullAddress: 'parvin'
        },
        skills: []
    };

    state = {
        cities: []
    }

    componentDidMount() {
        //ZoneService.getProvince().then(provinceList => this.setState({provinceList}));
    messageService.onMessage().subscribe(message=>{
       console.log('msg : ',message);
    });
    }

    onChangeProvince = (e) => {
        this.setState({cities: e.value.cities});
    };
    onCancel = (e) => {
//        console.log(e);
        messageService.sendMessage("test ddd");
    };
    onSave = (formData) => {
        console.log(formData);
        PersonService.save(formData).then(r=>{
            console.debug("result : ",r);
        });
    };

    render() {
        return <Card title="employee.employee_info" collapse={true}>
            <Form initialValues={this.initPersonData}
                  validationRules={ADD_ACCOUNT_RULES}
                  onSubmit={this.onSave}>
                <Fieldset title="employee.personal_info">
                    <Row>
                        <Field name='firstName' label='person.firstName' type='text'/>
                        <Field name='lastName' label='person.lastName' type='text'/>
                        <Field name='fatherName' label='person.fatherName' type='text'/>
                        <Field name='nationalCode' label='person.nationalCode' type='number'/>
                        <Field name='birthDate' label='person.birthDate' type='date'/>
                        <Field name='gender' label='person.gender'>
                            <Select data={GenderDataList} keyField={'id'} textField={'title'}/>
                        </Field>
                        <Field name='marriedState' label={'person.marriedState'}>
                            <Checkbox/>
                        </Field>
                    </Row>
                </Fieldset>
                <Fieldset title="employee.contact_info">
                    <Row>
                        <Field name='contact.mobile' label='contact.mobile' type='text'/>
                        <Field name='contact.tel' label='contact.tel' type='text'/>
                        <Field name='contact.email' label='contact.email' type='text'/>
                    </Row>
                </Fieldset>
                <Fieldset title="employee.address_info">
                    <Row>
                        <Field name='address.province' label='address.province'>
                            <Select data={ZoneDataList} textField='title' onChange={this.onChangeProvince}/>
                        </Field>
                        <Field name='address.city' label='address.city'>
                            <Select data={this.state.cities} textField='title'/>
                        </Field>
                        <Field name='address.postalCode' label='address.postalCode' type='number'/>
                        <Field name='address.fullAddress' label='address.fullAddress'>
                            <TextArea/>
                        </Field>
                    </Row>

                </Fieldset>

                <Button title='cancel' isPrimary={false} color={'secondary'} onClick={this.onCancel} />
                <Button title='save' isPrimary={true}/>
            </Form>
        </Card>
    }
}

export default AddPerson;