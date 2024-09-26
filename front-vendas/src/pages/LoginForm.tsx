import { useForm } from 'react-hook-form'
import {DevTool} from '@hookform/devtools'

// import jwtDecode, { JwtPayload } from 'jwt-decode'
// import Cookies from "universal-cookie";
import { request, setAuthHeader, setUsername } from '../helpers/axios_helper';

// type MyToken ={
//   name: string;
//   exp: number;
//   // whatever else is in the JWT.
// }

// let renderCount = 0;

type FormValues = {
    username: string;
    password: string;
};
export const LoginForm = () => {

  // const cookies = new Cookies();

  // const logout = () => {
  //     cookies.remove('token');
  // }

  

  // const login =  (token : string) => {
  //   // const decoded: JwtPayload = jwtDecode(token);
    

      
  //     // cookies.set('user', decoded, {
  //     //     expires: new Date(decoded.exp * 1000),
  //     // });

  //     cookies.set('token', token);
  // }

    const form = useForm<FormValues>();
    const { register, control, handleSubmit} = form;
    // const {name, ref, onChange, onBlur} = register('username');

    const onSubmit = async (body: FormValues) => {
      console.log(body);
      try {
        const response = await request("POST", "/auth/login", {
          login: body.username,
          password: body.password,
        });
        // login(response.data.token);
        console.log(response.data);
        setAuthHeader(response.data.token);
        setUsername(response.data.username);
        alert("Bem-vindo, " + response.data.username);
      } catch (error) {

        setAuthHeader(null);
        // logout();
        console.error(error);
        alert("Usuário ou senha inválidos");
      }
      
    }
    // renderCount++;
    // console.log(cookies.get('token'));
    return (
      <div>
        {/* <h1>Login Form ({renderCount/2})</h1> */}
        <h2>Login</h2>
  
        <form onSubmit={handleSubmit(onSubmit)}>
          <label htmlFor="username">Username</label>
          <input type="text" id="username" {...register("username")}/>
  
          <label htmlFor="password">E-mail</label>
          <input type="password" id="email" {...register("password")}/>
  
  
          <button>Submit</button>
        </form>
        <DevTool control={control}/>
      </div>
    );
  };