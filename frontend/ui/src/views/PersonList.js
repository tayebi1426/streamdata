import React from "react";
import {
    Button,
    Card,
    DataGrid,
    EditCommand,
    GridColumn,
    GridCommand,
    GridCommands,
    GridToolbar,
    withTranslation
} from "../components";

class PersonList extends React.Component {

    addItem = () => {
        let {history}=this.props;
        history.push('/person/new');

    };
    onEdit = (item, idx) => {
        console.log('onEdit : ', item, idx);
    };

    render() {
        return <Card collapse={true} title="personList">
            <DataGrid readUrl={'http://localhost:9001/person/list'}
                      editField="inEdit"
                      showIndex={true}
                      selectionMode={false}>
                <GridToolbar>
                    <Button title='add' onClick={this.addItem}/>
                </GridToolbar>

                <GridColumn field="firstName" title="person.firstName"/>
                <GridColumn field="lastName" title="person.lastName"/>
                <GridColumn field="nationalCode" title="person.nationalCode"/>
                <GridColumn field="birthDate" title="person.birthDate" format="date" />

                <GridCommands>
                    <EditCommand onClick={this.onEdit}/>
                    <GridCommand icon="trash-alt" title="delete"/>
                </GridCommands>
            </DataGrid>
        </Card>
    }
}

export default withTranslation(PersonList);