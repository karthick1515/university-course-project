import React,{useState,useEffect} from "react"
import { Modal,Button,Form,Table,Row } from 'react-bootstrap';
import { useDispatch, useSelector } from "react-redux";
import { StaffAddAction } from "../actions/staffAction";

const AddStaff = (props) =>{
     
    const dispatch = useDispatch();

    const handleAddstaff = (obj) =>{
               dispatch(StaffAddAction(obj));

        console.log(obj)
        props.onHide()
    }
    

    const addstaffObj={
    }
    return(
        <>
        <Modal {...props}>
            <Modal.Header closeButton>
            <Modal.Title>Add Staff</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Staff Role</Form.Label>
                    <Form.Control
                        type="Text"
                        autoFocus
                        placeholder="Role Name"
                        onChange={(e)=>{addstaffObj.role=(e.target.value)}}
                    /><br />
                    <Form.Label>Staff Email</Form.Label>
                    <Form.Control
                        type="Text"
                        placeholder="Staff Email"
                        onChange={(e)=>{
                            addstaffObj.email=(e.target.value);
                        }}
                    /><br />
                    <Form.Label>Staff Password</Form.Label>
                    <Form.Control
                        type="Text"
                        placeholder="Staff password"
                        onChange={(e)=>{
                            addstaffObj.password=(e.target.value);
                        }}
                    /><br />
                </Form.Group>
                
            </Modal.Body>
            <Modal.Footer>
            <Button variant="secondary"  onClick={props.onHide}>
                Close
            </Button>
            <Button variant="primary" onClick={()=>{
                handleAddstaff(addstaffObj);}}>
                Add Staff
            </Button>
            </Modal.Footer>
        </Modal>
        </>
    )
}

export default AddStaff;