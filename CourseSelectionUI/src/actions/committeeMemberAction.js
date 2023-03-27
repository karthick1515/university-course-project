import axios from 'axios';
import API from '../constants/api.json';

export const committeeAddAction = (obj)=> async dispatch=> {
  axios
    .post(API.addCommitteeMember,obj)
    .then((res)=>{
      dispatch({
        type:"ADD_COMMITTEE",
        payload:res
      })
      alert("Committee Member added Successfully")
    })
    .catch((err)=>{
      dispatch({
        type:"ADD_COMMITTEE_ERR",
        payload:err.response
      })
      alert("Someting went wrong could't Add committee");
    });
};

export const getAllCommittees = ()=> async dispatch=> {
  await axios
    .get(API.getAllMembers)
  .then((resp)=>{
    dispatch({
      type:"GET_ALL_COMMITTEES",
      payload:resp.data
    })
  })
  .catch((err)=>{
    dispatch({
      type:"GET_ALL_COMMITTEES_ERR",
      payload:err.response
    })
  });  
};

export const getCommittee = (id)=> async dispatch=> { 
  await axios
    .get(API.getCommitteeMember+`/view-commitee-member?id=${id}`)
  .then((resp)=>{
    dispatch({
      type:"GET_COMMITTEES",
      payload:resp.data
    })
    
  })
  .catch((err)=>{
    dispatch({
      type:"GET_COMMITTEES_ERR",
      payload:err.response
    })
    alert("There is no Committee member in this id");
  });  
};


export const deleteCommittee = (id)=> async dispatch=> { 
    await axios
      .delete(API.deleteCommitteeMember+`?id=${id}`)
    .then((resp)=>{
      dispatch({
        type:"DELETE_COMMITTEE",
        payload:resp.data
      })
      alert("Committee deleted")
    })
    .catch((err)=>{
      dispatch({
        type:"DELETE_COMMITTEE_ERR",
        payload:err.response
      })
      alert("Committee not deleted")
    });  
  };

  export const updateCommittee = (obj)=> async dispatch=> { 
    await axios
      .put(API.updateCommitteeMember+`?id=${obj.adminId}`,obj)
    .then((resp)=>{
      dispatch({
        type:"UPDATE_COMMITTEE",
        payload:resp.data
      })
      alert("Committee update")
    })
    .catch((err)=>{
      dispatch({
        type:"UPDATE_COMMITTEE_ERR",
        payload:err.response
      })
      alert("Committee couldn't update")
    });  
  };