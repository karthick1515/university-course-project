
export const getLogin =  (state={
    getLoginResp:""
  }, action) => {
      switch (action.type) {
        case "GET_LOGIN":
          return ({
            getLoginResp: action.payload
          });
        case "GET_LOGIN_ERR":
          return({
            getLoginResp:action.payload
          })
          case "RESET":
          return({
            getLoginResp:""
          })
        default:
          return state;
      }
  };

  export const registerLogin =  (
    state={
      registerLoginResp:""
    }, 
    action
    ) => {
        switch (action.type) {
          case "REGISTER_LOGIN":
            return({
              registerLoginResp:action.payload
            })
          case "REGISTER_LOGIN_ERR":
          return({
            registerLoginResp:action.payload
          })
          case "RESET":
          return({
            registerLoginResp:""
          })
          default:
            return state;
        }
  };