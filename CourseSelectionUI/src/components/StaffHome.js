import React, { useState } from "react";
import { Navbar,Container,Nav  } from 'react-bootstrap';
import ViewCoursesTable from "./ViewCourseTable";
import { useDispatch, useSelector } from "react-redux";
import {getAllCourses, getCourse} from "../actions/courseAction";
import AddCourse from "./AddCourse";
import ViewCommiteeMember from "./ViewCommiteeMember";
import {getAllCommittees, getCommittee} from "../actions/committeeMemberAction";
import AddCommitteeMember from "./AddCommitteeMember";
import ViewApplicant from "./ViewApplicant";
import {getAllApplicants, getApplicant} from "../actions/applicantAction";
import ViewAdmissions from "./ViewAdmissions";
import {getAdmission, getAllAdmissions} from "../actions/admissionAction";
import AddStaff from "./AddStaff";
import {getAllStaffs, getStaff } from "../actions/staffAction";
import ViewStaffs from "./ViewStaffs";
import CommonHome from "./CommonHomePage";
const StaffHome = () =>{
    const [viewCourses, setViewCourses] = useState(false);
    const [courseData, setCourseData] = useState([]);
    const [showAddCourseModal, setAddShowCourseModal] = useState(false);
    const[showAddStaffModal,setshowAddStaffModal]=useState(false);

    const [viewCommittee, setViewCommittee] = useState(false);
    const [committeeData, setCommitteeData] = useState([]);
    const [showAddCommitteeModal, setAddShowCommitteModal] = useState(false);

    
    const [viewApplicant, setViewApplicant] = useState(false);
    const [applicantData, setApplicantData] = useState([]);

    const[viewhome,setviewhome]=useState(true);
    const[viewstaff,setViewStaff]=useState(false);
    const [viewAdmission, setViewAdmission] = useState(false);
    const [admissionData, setAdmissionData] = useState([]);
    const[staffData,setStaffData]=useState([]);
   

    const dispatch = useDispatch();
   

    const getAllCoursesSelector = useSelector((state)=>state.getAllCourses.getAllCoursesResp);
    const getAllCommitteesSelector = useSelector((state)=>state.getAllCommittees.getAllCommitteesResp);
    const getAllApplicantSelector = useSelector((state)=>state.getAllApplicants.getAllApplicantsResp);
    const getAllApplicationSelector = useSelector((state)=>state.getAllAdmissions.getAllAdmissionsResp);
    const getAllStaffSelector=useSelector((state)=>state.getAllStaffs.getAllStaffsResp);
    
    return(
        <>
            <Navbar collapseOnSelect expand="lg" bg="success" variant="dark">
                <Container fluid>
                    <Navbar.Brand href="/">CourseSelection</Navbar.Brand>
                    <Navbar.Toggle aria-controls="navbarScroll" />
                    <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                    >
                        <Nav.Link onClick={()=>{setviewhome(true)
                      setshowAddStaffModal(false)
                    setAddShowCourseModal(false)
                    setAddShowCommitteModal(false)
                     setViewApplicant(false)
                     setViewCourses(false)
                     setViewCommittee(false)
                     setViewStaff(false)
                    }
                       
                    }>Staff Home</Nav.Link>
                        
                        <Nav.Link onClick={()=>{setAddShowCourseModal(true)
                         setshowAddStaffModal(false)
                         setviewhome(false)
                         setAddShowCommitteModal(false)
                            setViewCommittee(false)
                            setViewApplicant(false)
                            setViewAdmission(false)
                            setViewStaff(false)
                            setViewCourses(false)
                        }}>Add Course</Nav.Link>
                        <Nav.Link onClick={()=>{
                            setshowAddStaffModal(false)
                             setAddShowCourseModal(false)
                            setviewhome(false)
                            setViewCommittee(false)
                            setAddShowCommitteModal(false)
                            setViewApplicant(false)
                            setViewAdmission(false)
                            setViewStaff(false)
                            setCourseData([])
                            dispatch(getCourse(''))
                            dispatch(getAllCourses())
                            setCourseData(getAllCoursesSelector)
                            setViewCourses(!viewCourses)
                        }}>View Courses</Nav.Link>
                        <Nav.Link onClick={()=>{
                             setAddShowCourseModal(false)
                            setAddShowCommitteModal(true)
                      setshowAddStaffModal(false)
                      setViewCourses(false)
                      setviewhome(false)
                           
                            setViewCourses(false)
                            setViewApplicant(false)
                            setViewAdmission(false)
                            setViewStaff(false)
                            setViewCommittee(false)
                        }}>Add Commitee Mem</Nav.Link>
                        <Nav.Link onClick={()=>{
                            setAddShowCommitteModal(false)
                             setAddShowCourseModal(false)
                             setshowAddStaffModal(false)
                           setviewhome(false)
                           
                            setViewCourses(false)
                            setViewApplicant(false)
                            setViewAdmission(false)
                            setViewStaff(false)
                            setCommitteeData([])
                           dispatch(getCommittee(''))
                            dispatch(getAllCommittees())
                            setCommitteeData(getAllCommitteesSelector)
                            setViewCommittee(!viewCommittee)
                        }}>View Commitee Mem</Nav.Link>
                        <Nav.Link onClick={()=>{
                            setAddShowCommitteModal(false)
                             setAddShowCourseModal(false)
                            setshowAddStaffModal(false)
                             setAddShowCourseModal(false)
                            setviewhome(false)
                            setViewCourses(false)
                            setViewCommittee(false)
                            setViewAdmission(false)
                            setViewStaff(false)
                            setApplicantData([])
                            dispatch(getApplicant(''))
                            dispatch(getAllApplicants())
                            setApplicantData(getAllApplicantSelector)
                            setViewApplicant(!viewApplicant)
                        }}>View Applicant</Nav.Link>
                        <Nav.Link onClick={()=>{
                           setAddShowCommitteModal(false)
                             setAddShowCourseModal(false)
                            setviewhome(false)
                            setshowAddStaffModal(false)
                            setViewApplicant(false)
                            setViewCourses(false)
                            setViewCommittee(false)
                            setViewStaff(false)
                            setAdmissionData([])
                            dispatch(getAdmission(''))
                           
                            dispatch(getAllAdmissions())
                            setAdmissionData(getAllApplicationSelector)
                            setViewAdmission(!viewAdmission)
                        }}>View Admissions</Nav.Link>
                        
                        <Nav.Link onClick={()=>{
                            setshowAddStaffModal(false)
                            setAddShowCommitteModal(false)
                             setAddShowCourseModal(false)
                            setviewhome(false)
                            console.log(getAllStaffSelector);
                            setViewCourses(false)
                            setViewCommittee(false)
                            setViewAdmission(false)
                            setViewStaff(false)
                          dispatch(getStaff(''))
                            dispatch(getAllStaffs())
                            setStaffData(getAllStaffSelector)
                            console.log(staffData);
                            setViewStaff(!viewstaff)
                        }}>View Staffs</Nav.Link>

                   <Nav.Link onClick={()=>{setshowAddStaffModal(true)
                   setviewhome(false)
                   setAddShowCommitteModal(false)
                 
                   setViewApplicant(false)
                   setViewCourses(false)
                   setViewCommittee(false)
                   setViewStaff(false)
                   setAddShowCourseModal(false)
                }}>Add Staff</Nav.Link>
                        <Nav.Link href="/login" style={{ paddingLeft: '380px' }}>Logout</Nav.Link>  
                        
                    </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            {
                showAddCourseModal?
            <AddCourse  
            />:
            null
}
{ showAddCommitteeModal?
            <AddCommitteeMember
            />:
            null
}
            {showAddStaffModal?
            <AddStaff/>:
            null
}
             {
    viewhome?
    <CommonHome/>:
    null
}
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
            {
                viewstaff?
                <ViewStaffs data={staffData}/>:
                null
            }
            
    </>
    )
}

export default StaffHome;