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
      alert("Applied Successfully")
    })
    .catch((err)=>{
      dispatch({
        type:"ADD_ADMISSION_ERR",
        payload:err.response
      })
      alert("Already applied for a Course please check or cancel the application and apply again for this course");
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
    .get(API.getAdmission+`/show-admission-by-id?id=${id}`)
  .then((resp)=>{
    dispatch({
      type:"GET_ADMISSIONS",
      payload:resp.data
    })
    alert("ok");
  })
  .catch((err)=>{
    dispatch({
      type:"GET_ADMISSIONS_ERR",
      payload:err.response
    })
  });  
};

export const getAdmissionByApplicant = (id)=> async dispatch=> { 
  await axios
    .get(API.getAdmisssionByApplicantId+`?id=${parseInt(id)}`)
  .then((resp)=>{
    dispatch({
      type:"GET_ADMISSION_BY_APPLICANT_ID",
      payload:resp.data
   
    })
    console.log(resp.data);
  })
  .catch((err)=>{
    dispatch({
      type:"ADMISSION_RESET",
      payload:""
    })
    alert("Your Not applied for a Course")
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
