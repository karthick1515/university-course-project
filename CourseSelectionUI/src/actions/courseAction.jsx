import axios from 'axios';
import API from '../constants/api.json';

export const CourseAddAction = (obj)=> async dispatch=> {
  axios
    .post(API.addCourse,obj)
    .then((res)=>{
      dispatch({
        type:"ADD_COURSE",
        payload:res
      })

    })
    .catch((err)=>{
      dispatch({
        type:"ADD_COURSE_ERR",
        payload:err.response
      })
      alert("Someting went wrong could't Add course");
    });
};

export const getAllCourses = ()=> async dispatch=> {
  await axios
    .get(API.getAllCourses)
  .then((resp)=>{
    dispatch({
      type:"GET_ALL_COURSES",
      payload:resp.data
    })
  })
  .catch((err)=>{
    dispatch({
      type:"GET_ALL_COURSES_ERR",
      payload:err.response
    })
  });  
};

export const getCourse = (id)=> async dispatch=> { 
  await axios
    .get(API.getCourse+`/view-course?id=${id}`)
  .then((resp)=>{
    dispatch({
      type:"GET_COURSES",
      payload:resp.data
    })
  })
  .catch((err)=>{
    dispatch({
      type:"GET_COURSES_ERR",
      payload:err.response
    })
  });  
};


export const deleteCourse = (id)=> async dispatch=> { 
    await axios
      .delete(API.deleteCourse+`?id=${id}`)
    .then((resp)=>{
      dispatch({
        type:"DELETE_COURSE",
        payload:resp.data
      })
      alert("Course deleted")
    })
    .catch((err)=>{
      dispatch({
        type:"DELETE_COURSE_ERR",
        payload:err.response
      })
      alert("Course not deleted")
    });  
  };

  export const updateCourse = (obj)=> async dispatch=> { 
    await axios
      .put(API.updateCourse+`?id=${obj.courseId}`,obj)
    .then((resp)=>{
      dispatch({
        type:"UPDATE_COURSE",
        payload:resp.data
      })
      alert("Course update")
    })
    .catch((err)=>{
      dispatch({
        type:"UPDATE_COURSE_ERR",
        payload:err.response
      })
      alert("Course couldn't update")
    });  
  };
