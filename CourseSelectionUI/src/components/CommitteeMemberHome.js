import React, {useState } from "react";
import { Navbar,Container,Nav  } from 'react-bootstrap';
import ViewAdmissions from "./ViewAdmissions";
import { useDispatch, useSelector } from "react-redux";
import {getAdmission,getAllAdmissions} from "../actions/admissionAction";
import {getAllApplicants,getApplicant} from "../actions/applicantAction";
import ViewApplicant from "./ViewApplicant"
import CommonHome from "./CommonHomePage";

const CommitteeMemberHome = () =>{
    const[viewhome,setviewhome]=useState(true);
    const [viewApplicant, setViewApplicant] = useState(false);
    const [applicantData, setApplicantData] = useState([]);
    const getAllApplicantSelector = useSelector((state)=>state.getAllApplicants.getAllApplicantsResp)

    const [viewAdmission, setViewAdmission] = useState(false);
    const [admissionData, setAdmissionData] = useState([]);
    const getAllApplicationSelector = useSelector((state)=>state.getAllAdmissions.getAllAdmissionsResp)

    const dispatch = useDispatch();
    return(
        <>
            <Navbar collapseOnSelect expand="lg" bg="success" variant="dark">
                <Container fluid>
                    <Navbar.Brand href="/committeeMember-home">CourseSelection <a href="/committeeMember-home"></a></Navbar.Brand>
                    <Navbar.Toggle aria-controls="navbarScroll" />
                    <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                    >
                        <Nav.Link onClick={()=>{setviewhome(true)
                    setViewApplicant(false)
                    setViewAdmission(false)
                    }
                       
                    }>Committe Member Home</Nav.Link>
                       
                        <Nav.Link onClick={()=>{
                            setviewhome(false)
                            setViewApplicant(false)
                            setAdmissionData([])
                            dispatch(getAdmission(''))
                            dispatch(getAllAdmissions())
                            setAdmissionData(getAllApplicationSelector)
                            setViewAdmission(!viewAdmission)
                        }}>View Admissions</Nav.Link>
                        
                        
                        <Nav.Link onClick={()=>{
                            setviewhome(false)
                            setViewAdmission(false)
                            setApplicantData([])
                            dispatch(getApplicant(''))
                            dispatch(getAllApplicants())
                            setApplicantData(getAllApplicantSelector)
                            setViewApplicant(!viewApplicant)
                        }}>View Applicant</Nav.Link>
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
                viewAdmission?
                <ViewAdmissions data = {admissionData} user={"COMMITTEE_MEMBER"} />:
                null
            }
            {
                viewApplicant?
                <ViewApplicant data = {applicantData} />:
                null
            }
        </>
        
    )
}

export default CommitteeMemberHome;