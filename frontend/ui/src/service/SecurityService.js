import OAuthProvider from "../components/security/OAuthProvider";

class SecurityService {

    static isAuthenticated() {
        return SecurityService.getCurrentUser() != null;
    }

    static getCurrentUser() {
        try {
            return SecurityService.authProvider.getUser();
        } catch (e) {
            console.error(e);
            return null;
        }
    }

    static login(username, password) {
        SecurityService.logoutUser();
        return SecurityService.authProvider.takeToken(username, password);
    }

    static logoutUser() {
        SecurityService.authProvider.logout();
    }
    static getUserAccessToken() {
        try {
            return SecurityService.authProvider.getUserAccessToken();
        } catch (e) {
            console.error(e);
            return null;
        }
    }

    static hasAuthority(authorities) {
        if (!authorities) {
            return false;
        }
        try {
            let userAuthorities = SecurityService.authProvider.getUserAuthorities();
            if (!userAuthorities) {
                return false;
            }
            for (let authority of authorities) {
                if (userAuthorities.includes(authority)) {
                    return true;
                }
            }
        }catch (e) {
            console.log(e);
            return false;
        }
    }

    static authProvider

    static inti() {
        if (!SecurityService.authProvider) {
            SecurityService.authProvider = new OAuthProvider();
        }
        return SecurityService.authProvider;
    }

}

export default SecurityService;
