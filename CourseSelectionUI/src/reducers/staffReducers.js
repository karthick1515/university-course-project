
export const addstaff =  (state={
    addCourseResp:""
  }, action) => {
      switch (action.type) {
        case "ADD_STAFF":
          return ({
            addStaffResp: action.payload
          });
        case "ADD_STAFF_ERR":
          return({
            addStaffResp:action.payload
          })
          case "RESET":
          return({
            addStaffResp:""
          })
        default:
          return state;
      }
  };

  export const getAllStaffs =  (
    state={
        getAllStaffsResp:""
    },
    action
    ) => {
        switch (action.type) {
          case "GET_ALL_STAFFS":
            return({
                getAllStaffsResp:action.payload
            })
          case "GET_ALL_STAFFS_ERR":
          return({
            getAllStaffsResp:action.payload
          })
          case "RESET":
          return({
            getAllStaffsResp:""
          })
          default:
            return state;
        }
  };

  export const getStaff=  (
    state={
        getStaffResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "GET_STAFF":
            return({
                getStaffResp:action.payload
            })
          case "GET_STAFF_ERR":
          return({
            getStaffResp:action.payload
          })
          case "RESET":
          return({
            getStaffResp:""
          })
          default:
            return state;
        }
  };
