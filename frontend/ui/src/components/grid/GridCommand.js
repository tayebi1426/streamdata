import React from 'react'
import PropTypes from 'prop-types'
import Icon from '../common/Icon';
import withTranslation from "../i18n/WithTranslation";

class GridCommand extends React.Component {

    render() {
        let {
            icon, iconSize, title, t, onClick,
            dataIndex,
            dataItem
        } = this.props;

        return <span className='data-grid-command' title={t(title)} onClick={onClick && onClick.bind(this,dataItem,dataIndex)}>
            <Icon code={icon} size={iconSize} mask={['far', 'circle']}/>
        </span>
    }
}

GridCommand.propTypes = {
    icon: PropTypes.string.isRequired,
    iconSize: PropTypes.string.isRequired,
    iconColor: PropTypes.string,
    title: PropTypes.string.isRequired,
    onClick: PropTypes.func,
    dataIndex: PropTypes.number,
    dataItem: PropTypes.object,
    t: PropTypes.func
};

GridCommand.defaultProps = {
    iconSize: "lg"
};


export default withTranslation(GridCommand)
