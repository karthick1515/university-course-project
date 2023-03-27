import React from "react"
import { Modal,Button,Form} from 'react-bootstrap';
import { useDispatch} from "react-redux";
import {CourseAddAction} from "../actions/courseAction";

const AddCourse = (props) =>{
     
    const dispatch = useDispatch();
    let addcourseObj={}
    const handleAddcourse = (e) =>{
        e.preventDefault();
                
        if(!/^[a-zA-Z\s.]*$/.test(addcourseObj.courseName)){
            alert("Course name should contain only alphabets and dots.");
           
        }        
    
    else if(addcourseObj.courseDuration<=0){
            alert("Duration should not less than 0");
           
        }
    
       else if(new Date(addcourseObj.courseStartDate) < new Date()){
            alert("Start date should be a future date.");
           
        }
    
        
       else if(new Date(addcourseObj.courseEndDate) < new Date()){
            alert("End date should be a future date.");
           
        }
    
       
       else if(addcourseObj.courseFee < 0){
            alert("Course fee should not be less than 0.");
           
        }
    
    else{
            dispatch(CourseAddAction(addcourseObj));
            console.log(addcourseObj);
            
        }
    }
    

    
    return(
        <>
        <center><br/>
            <h4>Add Course</h4>
            <form onSubmit={handleAddcourse}>
  <div className="form-outline w-50 mb-4">
    <label htmlFor="courseName" className="form-label">Course Name</label>
    <input 
      type="text"
      id="courseName"
      className="form-control"
      autoFocus
      placeholder="Course Name"
      onChange={(e) => {
        addcourseObj.courseName = e.target.value;
      }}
      required
    />
  </div>
  <div className="form-outline w-50 mb-4">
    <label htmlFor="duration" className="form-label">Duration</label>
    <input 
      type="number"
      id="duration"
      className="form-control"
      placeholder="Course Duration"
      onChange={(e) => {
        addcourseObj.courseDuration = e.target.value;
      }}
      required
    />
  </div>
  <div className="form-outline w-50 mb-4">
    <label htmlFor="startDate" className="form-label">Start Date</label>
    <input 
      type="date"
      id="startDate"
      className="form-control"
      onChange={(e) => {
        addcourseObj.courseStartDate = e.target.value;
      }}
      required
    />
  </div>
  <div className="form-outline w-50 mb-4">
    <label htmlFor="endDate" className="form-label">End Date</label>
    <input 
      type="date"
      id="endDate"
      className="form-control"
      onChange={(e) => {
        addcourseObj.courseEndDate = e.target.value;
      }}
      required
    />
  </div>
  <div className="form-outline w-50 mb-4">
    <label htmlFor="fee" className="form-label">Fee</label>
    <input 
      type="number"
      id="fee"
      className="form-control"
      placeholder="Course Fee"
      onChange={(e) => {
        addcourseObj.courseFee = e.target.value;
      }}
      required
    />
  </div>
<button
type="submit"
className="btn btn-primary">
Add Course
  </button>
</form>
</center>
        </>
    )
}

export default AddCourse;