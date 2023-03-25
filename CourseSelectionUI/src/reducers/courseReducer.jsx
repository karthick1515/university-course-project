
export const addCourse =  (state={
    addCourseResp:""
  }, action) => {
      switch (action.type) {
        case "ADD_COURSE":
          return ({
            addCourseResp: action.payload
          });
        case "ADD_COURSE_ERR":
          return({
            addCourseResp:action.payload
          })
          case "RESET":
          return({
            addCourseResp:""
          })
        default:
          return state;
      }
  };

  export const getAllCourses =  (
    state={
        getAllCoursesResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "GET_ALL_COURSES":
            return({
                getAllCoursesResp:action.payload
            })
          case "GET_ALL_COURSES_ERR":
          return({
            getAllCoursesResp:action.payload
          })
          case "RESET":
          return({
            getAllCoursesResp:""
          })
          default:
            return state;
        }
  };

  
  export const getCourse =  (
    state={
        getCourseResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "GET_COURSES":
            return({
                getCourseResp:action.payload
            })
          case "GET_COURSES_ERR":
          return({
            getCourseResp:action.payload
          })
          case "RESET":
          return({
            getCourseResp:""
          })
          default:
            return state;
        }
  };

  
  export const deleteCourse =  (
    state={
        deleteCourseResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "DELETE_COURSE":
            return({
                deleteCourseResp:action.payload
            })
          case "DELETE_COURSE_ERR":
          return({
            deleteCourseResp:action.payload
          })
          case "RESET":
          return({
            deleteCourseResp:""
          })
          default:
            return state;
        }
  };

  export const updateCourse =  (
    state={
        updateCourseResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "UPDATE_COURSE":
            return({
                updateCourseResp:action.payload
            })
          case "UPDATE_COURSE_ERR":
          return({
            updateCourseResp:action.payload
          })
          case "RESET":
          return({
            updateCourseResp:""
          })
          default:
            return state;
        }
  };