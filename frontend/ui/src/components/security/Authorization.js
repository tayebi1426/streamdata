import PropTypes from "prop-types";
import SecurityService from '../../service/SecurityService.js'

const Authorization = ({access, children}) => {
    return SecurityService.hasAuthority(access) ? children : null;
};

Authorization.propTypes = {
    access: PropTypes.array
};

export default Authorization;
