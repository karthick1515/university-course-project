import axios from 'axios';
import API from '../constants/api.json';

export const StaffAddAction = (obj)=> async dispatch=> {
    axios
      .post(API.addstaff,obj)
      .then((res)=>{
        dispatch({
          type:"ADD_STAFF",
          payload:res
        })
        alert("Staff added successfully");
      })
      .catch((err)=>{
        dispatch({
          type:"ADD_STAFF_ERR",
          payload:err.response
        })
        alert("Staff already added with this mail");
      });
  };
  
  export const getAllStaffs = ()=> async dispatch=> {
    await axios
      .get(API.getAllStaffs)
    .then((resp)=>{
      dispatch({
        type:"GET_ALL_STAFFS",
        payload:resp.data
      })
    })
    .catch((err)=>{
      dispatch({
        type:"GET_ALL_STAFFS_ERR",
        payload:err.response
      })
    });  
  };
  
  export const getStaff = (id)=> async dispatch=> { 
    await axios
      .get(API.getStaff+`/view-staff?id=${id}`)
    .then((resp)=>{
      dispatch({
        type:"GET_STAFF",
        payload:resp.data
      })
    })
    .catch((err)=>{
      dispatch({
        type:"GET_STAFF_ERR",
        payload:err.response
      })
    });  
  };
  
  
  
  