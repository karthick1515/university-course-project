import React, { useEffect, useState } from "react";
import { Navbar,Container,Nav  } from 'react-bootstrap';
import ViewCoursesTable from "./ViewCourseTable";
import { useDispatch, useSelector } from "react-redux";
import  { useNavigate } from 'react-router-dom';
import {getAllCourses,getCourse} from "./../actions/courseAction";
import AddCourse from "./AddCourse";
import ViewCommiteeMember from "./ViewCommiteeMember";
import {getCommittee,getAllCommittees} from "./../actions/committeeMemberAction";
import AddCommitteeMember from "./AddCommitteeMember";
import ViewApplicant from "./ViewApplicant";
import {getAllApplicants,getApplicant} from "./../actions/applicantAction";
import ViewAdmissions from "./ViewAdmissions";
import {getAdmission,getAllAdmissions} from "./../actions/admissionAction";

const StaffHome = () =>{
    const [viewCourses, setViewCourses] = useState(false);
    const [courseData, setCourseData] = useState([]);
    const [showAddCourseModal, setAddShowCourseModal] = useState(false);

    
    const [viewCommittee, setViewCommittee] = useState(false);
    const [committeeData, setCommitteeData] = useState([]);
    const [showAddCommitteeModal, setAddShowCommitteModal] = useState(false);

    
    const [viewApplicant, setViewApplicant] = useState(false);
    const [applicantData, setApplicantData] = useState([]);

    
    const [viewAdmission, setViewAdmission] = useState(false);
    const [admissionData, setAdmissionData] = useState([]);
    const [showAddAdmissionModal, setAddShowAdmissionModal] = useState(false);

    const dispatch = useDispatch();
    const navigate = useNavigate();

    const getAllCoursesSelector = useSelector((state)=>state.getAllCourses.getAllCoursesResp)
    const getAllCommitteesSelector = useSelector((state)=>state.getAllCommittees.getAllCommitteesResp)
    const getAllApplicantSelector = useSelector((state)=>state.getAllApplicants.getAllApplicantsResp)
    const getAllApplicationSelector = useSelector((state)=>state.getAllAdmissions.getAllAdmissionsResp)

    return(
        <>
            <Navbar collapseOnSelect expand="lg" bg="success" variant="dark">
                <Container fluid>
                    <Navbar.Brand href="/staffHome">CourseSelection <a href="/staffHome"></a></Navbar.Brand>
                    <Navbar.Toggle aria-controls="navbarScroll" />
                    <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                    >
                        
                        <Nav.Link href="/staffHome">Staff Home</Nav.Link>
                        <Nav.Link onClick={()=>{setAddShowCourseModal(true)}}>Add Course</Nav.Link>
                        <Nav.Link onClick={()=>{
                            setViewCommittee(false)
                            setViewApplicant(false)
                            setViewAdmission(false)
                            setCourseData([])
                            dispatch(getCourse(''))
                            dispatch(getAllCourses())
                            setCourseData(getAllCoursesSelector)
                            setViewCourses(!viewCourses)
                        }}>View Courses</Nav.Link>
                        <Nav.Link onClick={()=>{setAddShowCommitteModal(true)}}>Add Commitee Mem</Nav.Link>
                        <Nav.Link onClick={()=>{
                            setViewCourses(false)
                            setViewApplicant(false)
                            setViewAdmission(false)
                            setCommitteeData([])
                            dispatch(getCommittee(''))
                            dispatch(getAllCommittees())
                            setCommitteeData(getAllCommitteesSelector)
                            setViewCommittee(!viewCommittee)
                        }}>View Commitee Mem</Nav.Link>
                        <Nav.Link onClick={()=>{
                            setViewCourses(false)
                            setViewCommittee(false)
                            setViewAdmission(false)
                            setApplicantData([])
                            dispatch(getApplicant(''))
                            dispatch(getAllApplicants())
                            setApplicantData(getAllApplicantSelector)
                            setViewApplicant(!viewApplicant)
                        }}>View Applicant</Nav.Link>
                        <Nav.Link onClick={()=>{
                            setViewApplicant(false)
                            setViewCourses(false)
                            setViewCommittee(false)
                            setAdmissionData([])
                            dispatch(getAdmission(''))
                            dispatch(getAllAdmissions())
                            setAdmissionData(getAllApplicationSelector)
                            setViewAdmission(!viewAdmission)
                        }}>View Admissions</Nav.Link>

                        <Nav.Link href="/" style={{ paddingLeft: '380px' }}>Logout</Nav.Link>  
                        
                    </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            <AddCourse 
                show={showAddCourseModal}
                onHide={()=>{setAddShowCourseModal(false)}}
            />
            <AddCommitteeMember
                show={showAddCommitteeModal}
                onHide={()=>{setAddShowCommitteModal(false)}}
            />
            
            {
                viewCourses?
                <ViewCoursesTable data = {courseData}/>:
                null
            }
            {
                viewCommittee?
                <ViewCommiteeMember data = {committeeData}/>:
                null
            }
            {
                viewApplicant?
                <ViewApplicant data = {applicantData} />:
                null
            }
            {
                viewAdmission?
                <ViewAdmissions data = {admissionData} />:
                null
            }
    </>
    )
}

export default StaffHome;