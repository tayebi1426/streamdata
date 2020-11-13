import React from "react";
import PropTypes from "prop-types";

import { Input} from "./index";

class  Switch extends React.Component{

    onChange=({checked,event})=>{
      console.log('Switch.onChange : ',checked);
    };
    render() {
        return   <div className="custom-control custom-checkbox">
            <Input type='checkbox' className={'custom-control-input'}/>
        </div>
    }
}
Switch.propTypes = {
    "checked":PropTypes.bool,
    "defaultChecked":PropTypes.bool,
    "disabled":PropTypes.bool,
    "onClick":PropTypes.func,
    "onChange":PropTypes.func,
    "className":PropTypes.string,
    "checkedChildren":PropTypes.string,
    "unCheckedChildren":PropTypes.string
};
Switch.defaultProps = {
    className: "custom-switch custom-switch-primary"
};

export default Switch;
