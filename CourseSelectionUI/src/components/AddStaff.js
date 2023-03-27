import React from "react"
import { Modal,Button,Form} from 'react-bootstrap';
import { useDispatch } from "react-redux";
import { StaffAddAction } from "../actions/staffAction";

const AddStaff = (props) =>{
    
    const dispatch = useDispatch();
    let addstaffObj={}
    const handleAddstaff = (e) =>{
        e.preventDefault();
        if(!/^[a-zA-Z\s]*$/.test(addstaffObj.role)){
            alert("Role should contain only alphabets ");
           return;
        }        
       else if(!/^\S+@\S+\.\S+$/.test(addstaffObj.email)){
            alert("Please enter a valid email address.");
            return;
        }
     else if(addstaffObj.password.length < 3 || addstaffObj.password.length > 15){
            alert("Password should be between 3 to 15 characters.");
            return;
        }
        
      else{
            dispatch(StaffAddAction(addstaffObj));
            console.log(addstaffObj);
            return true;
        }
    }
    

    return(
        <><center><br/>
            <h4> Add Staff</h4>
            <form className="form-outline w-50" onSubmit={
        handleAddstaff}>
    <div className="form-group">
        <label htmlFor="staffRole">Staff Role</label>
        <input
            type="text"
            className="form-control"
            id="staffRole"
            placeholder="Role Name"
            onChange={(e) => {
                addstaffObj.role = (e.target.value);
            }}
            required
        />
    </div>
    <br />
    <div className="form-group">
        <label htmlFor="staffEmail">Staff Email</label>
        <input
            type="email"
            className="form-control"
            id="staffEmail"
            placeholder="Staff Email"
            onChange={(e) => {
                addstaffObj.email = (e.target.value);
            }}
            required
        />
    </div>
    <br />
    <div className="form-group">
        <label htmlFor="staffPassword">Staff Password</label>
        <input
            type="password"
            className="form-control"
            id="staffPassword"
            placeholder="Staff password"
            onChange={(e) => {
                addstaffObj.password = (e.target.value);
            }}
            required
        />
    </div>
    <br />
    <button className="btn btn-primary" type="submit">Add Staff</button>
</form>
</center>
    </>
    
    )
}

export default AddStaff;