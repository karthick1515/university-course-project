import React,{useState,useEffect} from "react"
import { Modal,Button,Form,Table,Row } from 'react-bootstrap';
import { useDispatch, useSelector } from "react-redux";
import {CourseAddAction} from "../actions/courseAction";

const AddCourse = (props) =>{
     
    const dispatch = useDispatch();

    const handleAddcourse = (obj) =>{
        // if(!(obj.courseCode && obj.details && obj.courseType && obj.courseValue && obj.date) || obj.courseType=="false" ){
        //     alert("all fields are mandatory");
        //     return;
        // }
        // obj.courseValue = parseInt(obj.courseValue)
        // if(obj.courseValue<=0){
        //     alert("course value cannot be less than or equal to 0");
        //     return;
        // }

        dispatch(CourseAddAction(obj));

        console.log(obj)
        props.onHide()
    }
    

    const addcourseObj={
    }
    return(
        <>
        <Modal {...props}>
            <Modal.Header closeButton>
            <Modal.Title>Add Course</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Course Name</Form.Label>
                    <Form.Control
                        type="Text"
                        autoFocus
                        placeholder="Course Name"
                        onChange={(e)=>{addcourseObj.courseName=(e.target.value)}}
                    /><br />
                    <Form.Label>Details</Form.Label>
                    <Form.Control
                        type="Text"
                        placeholder="Course Duration"
                        onChange={(e)=>{
                            addcourseObj.courseDuration=(e.target.value);
                        }}
                    /><br />
                    <Form.Label>Start Date</Form.Label>
                    <Form.Control
                        type="date"
                        onChange={(e)=>{
                            addcourseObj.courseStartDate=(e.target.value);
                        }}
                    /><br />
                    <Form.Label>End Date</Form.Label>
                    <Form.Control
                        type="date"
                        onChange={(e)=>{
                            addcourseObj.courseEndDate=(e.target.value);
                        }}
                    /><br />
                    <Form.Label>Fee</Form.Label>
                    <Form.Control
                        type="Number"
                        placeholder="Course Fee"
                        onChange={(e)=>{
                            addcourseObj.courseFee=(e.target.value);
                        }}
                    /><br />
                </Form.Group>
                
            </Modal.Body>
            <Modal.Footer>
            <Button variant="secondary"  onClick={props.onHide}>
                Close
            </Button>
            <Button variant="primary" onClick={()=>{
                handleAddcourse(addcourseObj);}}>
                Add Course
            </Button>
            </Modal.Footer>
        </Modal>
        </>
    )
}

export default AddCourse;