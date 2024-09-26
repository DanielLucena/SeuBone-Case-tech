import jwtDecode from 'jwt-decode';
import Cookies from "universal-cookie";

const cookies = new Cookies();

export const logout = () => {
    cookies.remove('token');
}

export const login =  (token : string) => {
    const decoded= jwtDecode(token);

    
    cookies.set('user', decoded, {
        expires: new Date(decoded.exp * 1000),
    });

    cookies.set('token', token, {
        expires: new Date(decoded.exp * 1000),
    });
}