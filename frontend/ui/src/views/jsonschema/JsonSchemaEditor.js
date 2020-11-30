import React from 'react'
import TreeComponent from "../../demo/ui/TreeComponent";

let data= [
    {id:1, name : 'Node 1',expanded:false, hasChildren:true,
        items:[{id:3, name : 'Node 1.1', hasChildren:true}]},
    {id:2, name : 'Node 2', hasChildren:true}
]
class JsonSchemaEditor extends React.Component{
    render() {
        return (
            <div>
                <TreeComponent data={data} />
            </div>
        );
    }
}
export default JsonSchemaEditor;