import React, { useEffect, useState } from "react";
import { Navbar,Container,Nav  } from 'react-bootstrap';
import { useDispatch, useSelector } from "react-redux";
import {getAllCourses,getCourse} from "../actions/courseAction";
import ViewCoursesTable from "./ViewCourseTable";
import {getApplicantCourseId} from "../actions/applicantAction";


const ApplicantHome = () =>{
    const [viewCourses, setViewCourses] = useState(false);
    const [courseData, setCourseData] = useState([]);
    const [showAddCourseModal, setAddShowCourseModal] = useState(false);
    const getAllCoursesSelector = useSelector((state)=>state.getAllCourses.getAllCoursesResp)
    const loginResp = useSelector((state)=>state.getLogin.getLoginResp)
    
    const dispatch = useDispatch();
    return(
        <>
            <Navbar collapseOnSelect expand="lg" bg="success" variant="dark">
                <Container fluid>
                    <Navbar.Brand href="/applicant-home">CourseSelection <a href="/applicant-home"></a></Navbar.Brand>
                    <Navbar.Toggle aria-controls="navbarScroll" />
                    <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                    >
                        
                        <Nav.Link onClick={()=>{
                            setCourseData([])
                            dispatch(getCourse(''))
                            dispatch(getAllCourses())
                            dispatch(getApplicantCourseId(loginResp.data.applicantId))
                            setCourseData(getAllCoursesSelector)
                            setViewCourses(!viewCourses)
                        }}>View Courses</Nav.Link>
                    <Nav.Link href="/" style={{ paddingLeft: '780px' }}>Logout</Nav.Link>  
                    </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>

            {
                viewCourses?
                <ViewCoursesTable data = {courseData} user={"APPLICANT"}/>:
                null
            }
        </>
        
    )
}

export default ApplicantHome;