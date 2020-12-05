import React, {Component} from "react";
import {NavLink, withRouter} from "react-router-dom";
import PerfectScrollbar from "react-perfect-scrollbar";
import {Nav, NavItem} from "reactstrap";
import {I18Massage} from '../../../components'

class Sidebar extends Component {

    render() {
        return (
            <div className="sidebar">
                <div className="main-menu">
                    <div className="scroll">
                        <SidebarMenu/>
                    </div>
                </div>
                <div className="sub-menu">
                    <div className="scroll">
                    </div>
                </div>
            </div>
        );
    }
}

const SidebarMenu = () => {
    return <PerfectScrollbar options={{suppressScrollX: true, wheelPropagation: false}}>
        <Nav vertical className="list-unstyled">
            <NavItem className="active">
                <NavLink
                    to="/schema/objectDefinitionList"
                    onClick={e => {
                        console.debug('e : ', e);
                    }
                    }>
                    <i className="iconsminds-shop-4"/>
                    <I18Massage code="employee.employee_info"/>
                </NavLink>
            </NavItem>
        </Nav>
    </PerfectScrollbar>
};
export default withRouter(Sidebar);
