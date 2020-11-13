import AuthTokenStorage from "../components/security/AuthTokenStorage";
import OAuth2Client from "../components/security/OAuth2Client";

class SecurityService {

    static isAuthenticated() {
        return SecurityService.getUserAccount() !== null;
    }

    static getUserAccount() {
        const userAccount = AuthTokenStorage.getToken();
        if (userAccount && userAccount['access_token']) {
            const base64Url = userAccount['access_token'].split('.')[1];
            const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
            let jsonPayload = decodeURIComponent(atob(base64).split('').map((c) => '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2)).join(''));
            jsonPayload = JSON.parse(jsonPayload);
            jsonPayload['access_token'] = userAccount['access_token'];
            return jsonPayload;
        } else {
            return null;
        }
    }

    static getUserAuthorities() {
        return SecurityService.getUserAccount()['authorities'];
    }

    static login(username, password) {
        AuthTokenStorage.removeToken();
        return OAuth2Client.takeToken(username, password).then((token) => {
            AuthTokenStorage.persistToken(token)
        }).catch((error) => {
            let errorMessage;
            if (!error.response) {
                errorMessage= 'error.network_connection';
            } else if (error.response.status === 400) {
                errorMessage= 'error.invalid_grant';
            }else{
                errorMessage='error.unhandled_error';
            }
             return Promise.reject(errorMessage);
        });
    }

    static logoutUser() {
        AuthTokenStorage.removeToken();
    }

    static hasAuthority(authorities) {
        let userAuthorities = SecurityService.getUserAuthorities();
        if (!userAuthorities || !authorities) {
            return false;
        }
        for (let authority of authorities) {
            if (userAuthorities.includes(authority)) {
                return true;
            }
        }
    }
}

export default SecurityService;
