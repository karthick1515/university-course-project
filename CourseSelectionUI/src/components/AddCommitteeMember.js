import React from "react"
import {Button,Form } from 'react-bootstrap';
import { useDispatch} from "react-redux";
import {committeeAddAction} from "../actions/committeeMemberAction";

const AddCommitteeMember = (props) =>{
     
    const dispatch = useDispatch();
    let addcommitteeObj={ }
    const handleAddcommittee = (e) =>{
        e.preventDefault();
        if (!/^[a-zA-Z\s]*$/.test(addcommitteeObj.name)) {
            alert("Name should contain only alphabets.");
           
        }
    
       else if (addcommitteeObj.adminContact.length <= 0 || addcommitteeObj.adminContact.length !== 10) {
            alert("Contact should contain 10 digits.");
           
        }
    
       else if (/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(addcommitteeObj.email)) {
            alert("Enter the valid email.");
           
        }
    
      else if (addcommitteeObj.password.length < 3 || addcommitteeObj.password.length > 15) {
            alert("Password should be between 3 to 15 characters.");
           
        }

       else {
            dispatch(committeeAddAction(addcommitteeObj));
            
        }
    }
    
    return(
        <><center><br/>
        <h4>Add Committe Member</h4>
        <form className="form-outline w-50" onSubmit={
           
            handleAddcommittee}>
                <div className="form-group">
                    <label htmlFor="name">Name</label>
                    <input
                        type="text"
                        className="form-control"
                        id="name"
                        placeholder="Committee Member Name"
                        onChange={(e)=>{addcommitteeObj.name=(e.target.value)}
                        }required
                    /><br />
                </div>
                <div className="form-group">
                    <label htmlFor="contact">Contact</label>
                    <input
                        type="number"
                        className="form-control"
                        id="contact"
                        placeholder="Committee Member Contact"
                        onChange={(e)=>{
                            addcommitteeObj.adminContact=(e.target.value);
                        }}required
                    /><br />
                </div>
                <div className="form-group">
                    <label htmlFor="email">Email</label>
                    <input
                        type="email"
                        className="form-control"
                        id="email"
                        placeholder="Email"
                        onChange={(e)=>{
                            addcommitteeObj.email=(e.target.value);
                        }}required
                    /><br />
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password</label>
                    <input
                        type="password"
                        className="form-control"
                        id="password"
                        placeholder="Password"
                        onChange={(e)=>{
                            addcommitteeObj.password=(e.target.value);
                        }}
                    /><br />
                </div>
                <button type="submit" className="btn btn-primary">Add Committee Member</button>
        </form>

            </center>
        </>
    )
}

export default AddCommitteeMember;