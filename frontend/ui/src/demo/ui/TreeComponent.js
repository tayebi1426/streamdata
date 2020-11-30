import React from 'react'
import {Card} from '../../components'
import {TreeView} from '@progress/kendo-react-treeview';

class TreeComponent extends React.Component {
state={
    data:this.props.data
}

    onExpandChange = (e) => {
        console.debug('e : ', e);
        e.item.expended=!e.item.expended;
    };

    render() {
        return <React.Fragment>
            <Card title="Tab Component (Dynamic)">
                <TreeView dir="rtl"
                          data={this.state.data}
                          expandIcons={true}
                          textField="name"
                          getHierarchicalIndexById={(arg) => {
                              console.log('getHierarchicalIndexById : ', arg);
                          }}
                          onItemClick={this.props.onItemClick}
                          onExpandChange={this.onExpandChange} />
            </Card>
        </React.Fragment>
    }
}

export default TreeComponent