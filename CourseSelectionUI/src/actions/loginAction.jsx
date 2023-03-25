import axios from 'axios';
import API from '../constants/api.json';

export const loginAction = (email,password,role)=> async dispatch=> {
    const url = API.login[role];
  axios
    .get(url+`?email=${email}&password=${password}`)
    .then((res)=>{
      dispatch({
        type:"GET_LOGIN",
        payload:res
      })

    })
    .catch((err)=>{
      dispatch({
        type:"GET_LOGIN_ERR",
        payload:err.response
      })
      alert("Login Failed");
    });
};

export const registerApplicantAction = (role,obj)=> async dispatch=> {
    const url = API[role]
  await axios
    .post(url, obj)
  .then((resp)=>{
    dispatch({
      type:"REGISTER_LOGIN",
      payload:resp.data
    })
    alert("Registeration Success Please SignIn")
  })
  .catch((err)=>{
    dispatch({
      type:"REGISTER_LOGIN_ERR",
      payload:err.response
    })
    alert("registeration failed")
  });  
};