import React from 'react'
import {ImageUploader,Card, Col, Row} from '../../components'

class FileUploader extends React.Component {

    render() {
        return <React.Fragment>
            <Card title="Button Color">
                <Row>
                    <Col lg="1" md="1">
                        <ImageUploader name="df" label="label" onSelectImage={(imageInfo)=>console.debug({imageInfo})}/>
                    </Col>
                </Row>
            </Card>
        </React.Fragment>
    }
}

export default FileUploader