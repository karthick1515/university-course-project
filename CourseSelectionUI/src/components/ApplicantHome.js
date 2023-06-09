import React, { useEffect, useState } from "react";
import { Navbar,Container,Nav  } from 'react-bootstrap';
import { useDispatch, useSelector } from "react-redux";
import {getAllCourses,getCourse} from "../actions/courseAction";
import ViewCoursesTable from "./ViewCourseTable";
import {getApplicantCourseId} from "../actions/applicantAction";
import { getAdmissionByApplicant} from "../actions/admissionAction";
import {Table} from 'react-bootstrap';
import CommonHome from "./CommonHomePage";
const ApplicantHome = () =>{
    const [viewCourses, setViewCourses] = useState(false);
    const [courseData, setCourseData] = useState([]);
    const getAllCoursesSelector = useSelector((state)=>state.getAllCourses.getAllCoursesResp);
    const loginResp = useSelector((state)=>state.getLogin.getLoginResp);
    const getAdmissionByApplicantIdSelector=useSelector((state)=>state.getAdmissionByApplicantId.getAdmissionByApplicantResp);

    
    const [admissionData, setAdmissionData] = useState([]);
   const[viewhome,setviewhome]=useState(true);
    const [viewAdmission, setViewAdmission] = useState(false);
    useEffect(()=>{
        if(getAdmissionByApplicantIdSelector && !getAdmissionByApplicantIdSelector.data)
        setAdmissionData([getAdmissionByApplicantIdSelector])
        console.log(getAdmissionByApplicantIdSelector.data);
    },[getAdmissionByApplicantIdSelector])
    
   
    const dispatch = useDispatch();
    return(
        <>
            <Navbar collapseOnSelect expand="lg" bg="success" variant="dark">
                <Container fluid>
                    <Navbar.Brand href="/login">CourseSelection</Navbar.Brand>
                    <Navbar.Toggle aria-controls="navbarScroll" />
                    <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                    >
                        <Nav.Link onClick={()=>{setviewhome(true)
                    setViewAdmission(false)  
                    setViewCourses(false)  
                    }
                       
                    }>Applicant Home</Nav.Link>
                       
                        <Nav.Link onClick={()=>{
                            setviewhome(false)
                            setCourseData([])
                            dispatch(getCourse(''))
                            dispatch(getAllCourses())
                            dispatch(getApplicantCourseId(loginResp.data.applicantId))
                            setCourseData(getAllCoursesSelector)
                            setViewCourses(!viewCourses)
                            setViewAdmission(false)
                        }}>View Courses</Nav.Link>
                        <Nav.Link onClick={()=>{ 
                             
                             setviewhome(false)
                            dispatch(getAdmissionByApplicant(loginResp.data.applicantId));
                            setAdmissionData([])
                            setViewAdmission(!viewAdmission)
                             setViewCourses(false)}}
                            >View Admission Status</Nav.Link>
                    <Nav.Link href="/login" style={{ paddingLeft: '780px' }}>Logout</Nav.Link>  
                    </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            {
    viewhome?
    <CommonHome/>:
    null
}
            {
                viewCourses?
                <ViewCoursesTable data = {courseData} user={"APPLICANT"}/>:
                null
            }
            {
                viewAdmission?
            
             <Table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Admission Date</th>
                            <th>Status</th>
                            <th>Applied Date</th>
                            <th>Applicant Name</th>
                            <th>Mobile Number</th>
                            <th>School</th>
                            <th>Percentage</th>
                            <th>Pass Out Year</th>
                            <th>Gender</th> 
                            <th>Course Name</th>
                            <th>Course Duration</th>
                            <th>Course Fee</th>
                            </tr>
                    </thead>
                    <tbody>
                        {
                            admissionData && admissionData.map((val)=>{
                                console.log(val)
                                return(
                                    <tr>
                                        <td>{val.admissionId}</td>
                                        <td>{val.admissionDate}</td>
                                        <td>{val.admissionStatus}</td>
                                        <td>{val.appliedDate}</td>
                                        <td>{val.applicantId.applicantName}</td>
                                        <td>{val.applicantId.mobileNumber}</td>
                                        <td>{val.applicantId.school}</td>
                                        <td>{val.applicantId.applicantGraduationPercentage}</td>
                                        <td>{val.applicantId.passOutYear}</td>
                                        <td>{val.applicantId.gender}</td>
                                        <td>{val.courseId.courseName}</td>
                                        <td>{val.courseId.courseDuration}</td>
                                        <td>{val.courseId.courseFee}</td>
                                        </tr>
                                )
                            })
                        }
                        
                    </tbody>
                </Table>:
                null}
        </>
        
    )
}

export default ApplicantHome;