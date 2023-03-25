import axios from 'axios';
import API from '../constants/api.json';

export const addAdmission = (obj)=> async dispatch=> {
  axios
    .post(API.addAdmission,obj)
    .then((res)=>{
      dispatch({
        type:"ADD_ADMISSION",
        payload:res
      })
      alert("Applies Successfully")
    })
    .catch((err)=>{
      dispatch({
        type:"ADD_ADMISSION_ERR",
        payload:err.response
      })
      alert("Failed to apply");
    });
};

export const getAllAdmissions = ()=> async dispatch=> {
  await axios
    .get(API.getAllAdmission)
  .then((resp)=>{
    dispatch({
      type:"GET_ALL_ADMISSIONS",
      payload:resp.data
    })
  })
  .catch((err)=>{
    dispatch({
      type:"GET_ALL_ADMISSIONS_ERR",
      payload:err.response
    })
  });  
};

export const getAdmission = (id)=> async dispatch=> { 
  await axios
    .get(API.getAdmission+`?id=${id}`)
  .then((resp)=>{
    dispatch({
      type:"GET_ADMISSIONS",
      payload:resp.data
    })
  })
  .catch((err)=>{
    dispatch({
      type:"GET_ADMISSIONS_ERR",
      payload:err.response
    })
  });  
};


export const deleteAdmission = (id)=> async dispatch=> { 
    await axios
      .delete(API.deleteAdmission+`?id=${parseInt(id)}`)
    .then((resp)=>{
      dispatch({
        type:"DELETE_ADMISSION",
        payload:resp.data
      })
      alert("Admission Canceled")
    })
    .catch((err)=>{
      dispatch({
        type:"DELETE_ADMISSION_ERR",
        payload:err.response
      })
      alert("Admission not canceled")
    });  
  };

  export const updateAdmission = (obj)=> async dispatch=> { 
    await axios
      .put(API.updateAdmission+`?id=${obj.admissionId}`,obj)
    .then((resp)=>{
      dispatch({
        type:"UPDATE_ADMISSION",
        payload:resp.data
      })
      alert("Admission update")
    })
    .catch((err)=>{
      dispatch({
        type:"UPDATE_ADMISSION_ERR",
        payload:err.response
      })
      alert("Admission couldn't update")
    });  
  };
