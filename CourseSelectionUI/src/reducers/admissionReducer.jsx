
export const addAdmission =  (state={
    addAdmissionResp:""
  }, action) => {
      switch (action.type) {
        case "ADD_ADMISSION":
          return ({
            addAdmissionResp: action.payload
          });
        case "ADD_ADMISSION_ERR":
          return({
            addAdmissionResp:action.payload
          })
          case "RESET":
          return({
            addAdmissionResp:""
          })
        default:
          return state;
      }
  };

  export const getAllAdmissions =  (
    state={
        getAllAdmissionsResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "GET_ALL_ADMISSIONS":
            return({
                getAllAdmissionsResp:action.payload
            })
          case "GET_ALL_ADMISSIONS_ERR":
          return({
            getAllAdmissionsResp:action.payload
          })
          case "RESET":
          return({
            getAllAdmissionsResp:""
          })
          default:
            return state;
        }
  };

  
  export const getAdmission =  (
    state={
        getAdmissionResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "GET_ADMISSIONS":
            return({
                getAdmissionResp:action.payload
            })
          case "GET_ADMISSIONS_ERR":
          return({
            getAdmissionResp:action.payload
          })
          case "RESET":
          return({
            getAdmissionResp:""
          })
          default:
            return state;
        }
  };

  export const getAdmissionByApplicantId =  (
    state={
        getAdmissionByApplicantResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "GET_ADMISSION_BY_APPLICANT_ID":
            return({
              getAdmissionByApplicantResp:action.payload
            })
          case "GET_ADMISSIONS_ADMISSION_BY_APPLICANT_ID_ERR":
          return({
            getAdmissionByApplicantResp:action.payload
          })
          case "ADMISSION_RESET":
          return({
            getAdmissionByApplicantResp:""
          })
          default:
            return state;
        }
  };

  export const deleteAdmission =  (
    state={
        deleteAdmissionResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "DELETE_ADMISSION":
            return({
                deleteAdmissionResp:action.payload
            })
          case "DELETE_ADMISSION_ERR":
          return({
            deleteAdmissionResp:action.payload
          })
          case "RESET":
          return({
            deleteAdmissionResp:""
          })
          default:
            return state;
        }
  };

  export const updateAdmission =  (
    state={
        updateAdmissionResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "UPDATE_ADMISSION":
            return({
                updateAdmissionResp:action.payload
            })
          case "UPDATE_ADMISSION_ERR":
          return({
            updateAdmissionResp:action.payload
          })
          case "RESET":
          return({
            updateAdmissionResp:""
          })
          default:
            return state;
        }
  };