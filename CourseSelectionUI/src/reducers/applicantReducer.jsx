
export const addApplicant =  (state={
    addApplicantResp:""
  }, action) => {
      switch (action.type) {
        case "ADD_APPLICANT":
          return ({
            addApplicantResp: action.payload
          });
        case "ADD_APPLICANT_ERR":
          return({
            addApplicantResp:action.payload
          })
          case "RESET":
          return({
            addApplicantResp:""
          })
        default:
          return state;
      }
  };

  export const getAllApplicants =  (
    state={
        getAllApplicantsResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "GET_ALL_APPLICANTS":
            return({
                getAllApplicantsResp:action.payload
            })
          case "GET_ALL_APPLICANTS_ERR":
          return({
            getAllApplicantsResp:action.payload
          })
          case "RESET":
          return({
            getAllApplicantsResp:""
          })
          default:
            return state;
        }
  };

  
  export const getApplicant =  (
    state={
        getApplicantResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "GET_APPLICANTS":
            return({
                getApplicantResp:action.payload
            })
          case "GET_APPLICANTS_ERR":
          return({
            getApplicantResp:action.payload
          })
          case "RESET":
          return({
            getApplicantResp:""
          })
          default:
            return state;
        }
  };

  
  export const getApplicantCourseId =  (
    state={
        getApplicantCourseResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "GET_APPLICANTS_COURSES":
            return({
                getApplicantCourseResp:action.payload
            })
          case "GET_APPLICANTS_COURSES_ERR":
          return({
            getApplicantCourseResp:action.payload
          })
          case "RESET":
          return({
            getApplicantCourseResp:""
          })
          default:
            return state;
        }
  };

  
  export const deleteApplicant =  (
    state={
        deleteApplicantResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "DELETE_APPLICANT":
            return({
                deleteApplicantResp:action.payload
            })
          case "DELETE_APPLICANT_ERR":
          return({
            deleteApplicantResp:action.payload
          })
          case "RESET":
          return({
            deleteApplicantResp:""
          })
          default:
            return state;
        }
  };

  export const updateApplicant =  (
    state={
        updateApplicantResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "UPDATE_APPLICANT":
            return({
                updateApplicantResp:action.payload
            })
          case "UPDATE_APPLICANT_ERR":
          return({
            updateApplicantResp:action.payload
          })
          case "RESET":
          return({
            updateApplicantResp:""
          })
          default:
            return state;
        }
  };