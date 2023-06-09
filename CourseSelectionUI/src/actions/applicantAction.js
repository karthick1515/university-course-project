import axios from 'axios';
import API from '../constants/api.json';

export const addApplicant = (obj)=> async dispatch=> {
  axios
    .post(API.RedisterApplicant,obj)
    .then((res)=>{
      dispatch({
        type:"ADD_APPLICANT",
        payload:res
      })
      alert("Registered Successfully , Please login")
    })
    .catch((err)=>{
      dispatch({
        type:"ADD_APPLICANT_ERR",
        payload:err.response
      })
      alert("Already Registered with this email")
    });
};

export const getAllApplicants = ()=> async dispatch=> {
  await axios
    .get(API.getAllApplicant)
  .then((resp)=>{
    dispatch({
      type:"GET_ALL_APPLICANTS",
      payload:resp.data
    })
  })
  .catch((err)=>{
    dispatch({
      type:"GET_ALL_APPLICANTS_ERR",
      payload:err.response
    })
  });  
};

export const getApplicant = (id)=> async dispatch=> { 
  await axios
    .get(API.getApplicant+`/view-applicant?id=${id}`)
  .then((resp)=>{
    dispatch({
      type:"GET_APPLICANTS",
      payload:resp.data
    })
  })
  .catch((err)=>{
    dispatch({
      type:"GET_APPLICANTS_ERR",
      payload:err.response
    })
  });  
};

export const getApplicantCourseId = (id)=> async dispatch=> { 
  await axios
    .get(API.getApplicantCourse+`?id=${id}`)
  .then((resp)=>{
    dispatch({
      type:"GET_APPLICANTS_COURSES",
      payload:resp.data
    })
  })
  .catch((err)=>{
    dispatch({
      type:"GET_APPLICANTS_COURSES_ERR",
      payload:""
    })
    alert("your not applied for the courses")
  });  
};

export const deleteApplicant = (id)=> async dispatch=> { 
    await axios
      .delete(API.deleteApplicantMember+`?id=${id}`)
    .then((resp)=>{
      dispatch({
        type:"DELETE_APPLICANT",
        payload:resp.data
      })
      alert("Applicant deleted")
    })
    .catch((err)=>{
      dispatch({
        type:"DELETE_APPLICANT_ERR",
        payload:err.response
      })
      alert("Applicant not deleted")
    });  
  };

  export const updateApplicant = (obj)=> async dispatch=> { 
    await axios
      .put(API.updateApplicantMember+`?id=${obj.adminId}`,obj)
    .then((resp)=>{
      dispatch({
        type:"UPDATE_APPLICANT",
        payload:resp.data
      })
      alert("Applicant updated")
    })
    .catch((err)=>{
      dispatch({
        type:"UPDATE_APPLICANT_ERR",
        payload:err.response
      })
      alert("Couldn't update Applicant ")
    });  
  };
