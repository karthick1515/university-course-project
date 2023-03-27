import React, { useEffect, useRef, useState } from "react";
import { Modal,Button,Form,Table} from 'react-bootstrap';
import { useDispatch, useSelector } from "react-redux";
import {getCourse,getAllCourses,deleteCourse,updateCourse} from "../actions/courseAction";
import {addAdmission,deleteAdmission} from "../actions/admissionAction";
import {getApplicantCourseId} from "../actions/applicantAction";


const ViewCoursesTable = ({data,user}) =>{
    const courseId = useRef('');
    const dispatch = useDispatch();
    const [courseData,setCourseData] = useState(data);
    const [showEditCourseModal,setShowEditCourseModal] = useState(false);
    const [editCourseData,setEditCourseData] = useState('');
    const getCourseSelector = useSelector((state)=>state.getCourse.getCourseResp)

    
    const loginResp = useSelector((state)=>state.getLogin.getLoginResp)
    const applicantCourseSelector = useSelector((state)=>state.getApplicantCourseId.getApplicantCourseResp)

    const onDeleteCourse = (val)=>{
        if (window.confirm(`Are you sure, you want to delete ${val.courseName}`)) {
            dispatch(deleteCourse(val.courseId))
            dispatch(getAllCourses());   
      }  
    }

    const onApply = (val) =>{
        const obj = {
            courseId:val.courseId,
            applicantId:loginResp.data && loginResp.data.applicantId,
            admissionDate:"",
            admissionStatus: "Applied",
            appliedDate:new Date(),
        }
        dispatch(addAdmission(obj))
        dispatch(getApplicantCourseId(loginResp.data.applicantId))
    }
    
    const onCancel = (val)=>{
        if (window.confirm(`Are you sure, you want to Cancel application for course ${val.courseName}`)) {
            dispatch(deleteAdmission(loginResp.data.applicantId))
            dispatch(getApplicantCourseId(loginResp.data.applicantId))
            dispatch(getAllCourses());   
      }  
    }
    const EditCourse = (props)=>{
        const val = props.data;
         return(
             <Modal {...props}>
                 <Modal.Header closeButton>
                 <Modal.Title>Edit Course</Modal.Title>
                 </Modal.Header>
                 <Modal.Body>
                     <Form.Group className="mb-3" >
                         <Form.Label>Course Name</Form.Label>
                         <Form.Control
                             type="Text"
                             autoFocus
                             placeholder={val? val.courseName : null}
                             onChange={(e)=>{val.courseName=(e.target.value)}}
                         /><br />
                         <Form.Label>Duration</Form.Label>
                         <Form.Control
                             type="Text"
                             placeholder={val? val.courseDuration : null}
                             onChange={(e)=>{val.courseDuration=(e.target.value)}}
                         /><br />
                         <Form.Label>Start Date</Form.Label>
                        <Form.Control
                            type="date"
                            placeholder={val? val.courseStartDate : null}
                            onChange={(e)=>{
                                val.courseStartDate=(e.target.value);
                            }}
                        /><br />
                        <Form.Label>End Date</Form.Label>
                        <Form.Control
                            type="date"
                            placeholder={val? val.courseEndDate : null}
                            onChange={(e)=>{
                                val.courseEndDate=(e.target.value);
                            }}
                        /><br />
                         <Form.Label>Fee</Form.Label>
                         <Form.Control
                             type="Number"
                             placeholder={val? val.courseFee : null}
                             onChange={(e)=>{val.courseFee=(e.target.value)}}
                         /><br />
                     </Form.Group>
                     
                 </Modal.Body>
                 <Modal.Footer>
                 <Button variant="secondary"  onClick={props.onHide}>
                     Close
                 </Button>
                 <Button variant="primary" onClick={()=>{
                     dispatch(updateCourse(val))
                     setShowEditCourseModal(false)
                 }}>
                     Update
                 </Button>
                 </Modal.Footer>
             </Modal>
         )
     }

    useEffect(()=>{
        if(getCourseSelector && !getCourseSelector.data)
            setCourseData([getCourseSelector])
    },[getCourseSelector])
    return(
        <>
            <EditCourse 
                data={editCourseData}
                show={showEditCourseModal}
                onHide={()=>{setShowEditCourseModal(false)}}
            />
            <div style = {{padding:"200px",paddingTop:"20px"}}>
                <h3>Courses</h3><br/>
                <div class="">
                    <h5 style={{display: "inline-block"}}>Search Course</h5> &nbsp;&nbsp;&nbsp;
                    <input type="text" ref={courseId} class="" id="exampleFormControlInput1" placeholder="Course ID"/>&nbsp;&nbsp;&nbsp;
                    <button type="submit" class="btn btn-primary" onClick={()=>{dispatch(getCourse(courseId.current.value))}}>Search</button>
                </div>
                <Table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Duration</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                            <th>Fee</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            courseData&& courseData.map((val)=>{
                                return(
                                    <tr>
                                        <td>{val.courseId}</td>
                                        <td>{val.courseName}</td>
                                        <td>{val.courseDuration}</td>
                                        <td>{val.courseStartDate}</td>
                                        <td>{val.courseEndDate}</td>
                                        <td>{val.courseFee}</td>
                                        <td>
                                            {
                                               user ==="APPLICANT"?
                                               <>
                                                <button 
                                                onClick={()=>{onApply(val)}} 
                                                disabled = { applicantCourseSelector && applicantCourseSelector.length>0 }
                                                >Apply</button>
                                                {
                                                    applicantCourseSelector && applicantCourseSelector.includes(val.courseId)?
                                                    <button onClick={()=>{onCancel(val)}}>Cancel</button>:
                                                    null
                                                }
                                                </>:
                                               <>
                                                     <button onClick={()=>{
                                                        setEditCourseData(val);
                                                        setShowEditCourseModal(true);
                                                    }}>Edit</button> &nbsp;&nbsp;&nbsp;&nbsp;
                                                    <button onClick={()=>onDeleteCourse(val)}>Delete</button>
                                               </>
                                            }
                                           
                                        </td>
                                    </tr>
                                )
                            })
                        }
                        
                    </tbody>
                </Table>
            </div>
        </>
    )
}
export default ViewCoursesTable;