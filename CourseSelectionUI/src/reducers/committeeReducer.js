
export const addCommittee =  (state={
    addCommitteeResp:""
  }, action) => {
      switch (action.type) {
        case "ADD_COMMITTEE":
          return ({
            addCommitteeResp: action.payload
          });
        case "ADD_COMMITTEE_ERR":
          return({
            addCommitteeResp:action.payload
          })
          case "RESET":
          return({
            addCommitteeResp:""
          })
        default:
          return state;
      }
  };

  export const getAllCommittees =  (
    state={
        getAllCommitteesResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "GET_ALL_COMMITTEES":
            return({
                getAllCommitteesResp:action.payload
            })
          case "GET_ALL_COMMITTEES_ERR":
          return({
            getAllCommitteesResp:action.payload
          })
          case "RESET":
          return({
            getAllCommitteesResp:""
          })
          default:
            return state;
        }
  };

  
  export const getCommittee =  (
    state={
        getCommitteeResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "GET_COMMITTEES":
            return({
                getCommitteeResp:action.payload
            })
          case "GET_COMMITTEES_ERR":
          return({
            getCommitteeResp:action.payload
          })
          case "RESET":
          return({
            getCommitteeResp:""
          })
          default:
            return state;
        }
  };

  
  export const deleteCommittee =  (
    state={
        deleteCommitteeResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "DELETE_COMMITTEE":
            return({
                deleteCommitteeResp:action.payload
            })
          case "DELETE_COMMITTEE_ERR":
          return({
            deleteCommitteeResp:action.payload
          })
          case "RESET":
          return({
            deleteCommitteeResp:""
          })
          default:
            return state;
        }
  };

  export const updateCommittee =  (
    state={
        updateCommitteeResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "UPDATE_COMMITTEE":
            return({
                updateCommitteeResp:action.payload
            })
          case "UPDATE_COMMITTEE_ERR":
          return({
            updateCommitteeResp:action.payload
          })
          case "RESET":
          return({
            updateCommitteeResp:""
          })
          default:
            return state;
        }
  };