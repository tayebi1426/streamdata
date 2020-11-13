import React from 'react'
import {GridColumn as KGridColumn} from '@progress/kendo-react-grid';
import * as PropTypes from 'prop-types';


function GridColumn({title,...restProps}) {
    return <KGridColumn title={title + ' ---- '}  {...restProps}/>
}

GridColumn.defaultProps = {
    editable: false,
};

GridColumn.propTypes = {
    title: PropTypes.string.isRequired,
    field: PropTypes.string.isRequired,
    width: PropTypes.number,
    render: PropTypes.func,
    format: PropTypes.oneOf(['date', 'dateTime', 'currency'])

};

export default GridColumn;