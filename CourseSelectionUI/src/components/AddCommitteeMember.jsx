import React,{useState,useEffect} from "react"
import { Modal,Button,Form,Table,Row } from 'react-bootstrap';
import { useDispatch, useSelector } from "react-redux";
import {committeeAddAction} from "../actions/committeeMemberAction";

const AddCommitteeMember = (props) =>{
     
    const dispatch = useDispatch();

    const handleAddcommittee = (obj) =>{
        // if(!(obj.committeeCode && obj.details && obj.committeeType && obj.committeeValue && obj.date) || obj.committeeType=="false" ){
        //     alert("all fields are mandatory");
        //     return;
        // }
        // obj.committeeValue = parseInt(obj.committeeValue)
        // if(obj.committeeValue<=0){
        //     alert("committee value cannot be less than or equal to 0");
        //     return;
        // }

        dispatch(committeeAddAction(obj));

        props.onHide()
    }
    

    const addcommitteeObj={
    }
    return(
        <>
        <Modal {...props}>
            <Modal.Header closeButton>
            <Modal.Title>Add Committee Member</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Name</Form.Label>
                    <Form.Control
                        type="Text"
                        autoFocus
                        placeholder="Committee Name"
                        onChange={(e)=>{addcommitteeObj.name=(e.target.value)}
                        }required
                    /><br />
                    <Form.Label>Contact</Form.Label>
                    <Form.Control
                        type="Text"
                        placeholder="Committee Duration"
                        onChange={(e)=>{
                            addcommitteeObj.adminContact=(e.target.value);
                        }}required
                    /><br />
                    <Form.Label>Email</Form.Label>
                    <Form.Control
                        type="Text"
                        placeholder="Email"
                        onChange={(e)=>{
                            addcommitteeObj.email=(e.target.value);
                        }}required
                    /><br />
                    <Form.Label>Password</Form.Label>
                    <Form.Control
                        type="Text"
                        placeholder="Password"
                        onChange={(e)=>{
                            addcommitteeObj.password=(e.target.value);
                        }}
                    /><br />
                </Form.Group>
                
            </Modal.Body>
            <Modal.Footer>
            <Button variant="secondary"  onClick={props.onHide}>
                Close
            </Button>
            <Button variant="primary" onClick={()=>{
                handleAddcommittee(addcommitteeObj);}}>
                Add
            </Button>
            </Modal.Footer>
        </Modal>
        </>
    )
}

export default AddCommitteeMember;