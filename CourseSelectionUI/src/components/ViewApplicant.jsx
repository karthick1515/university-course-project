import React,{useRef,useState,useEffect} from "react";
import { Navbar,Container,Nav,Dropdown,Modal,Button,Form,Table,Row } from 'react-bootstrap';
import { useDispatch, useSelector } from "react-redux";
import {getApplicant} from "./../actions/applicantAction";

const ViewApplicant = ({data}) =>{
    
    const [applicantData,setApplicantData] = useState(data);
    const applicantId = useRef('');
    const dispatch = useDispatch();
    const getApplicantSelector = useSelector((state)=>state.getApplicant.getApplicantResp)

    useEffect(()=>{
        if(getApplicantSelector && !getApplicantSelector.data)
        setApplicantData([getApplicantSelector])
    },[getApplicantSelector])

    return(
        <>
            <div style = {{padding:"200px",paddingTop:"20px"}}>
                <h3>Applicants</h3><br/>
                <div class="">
                    <h5 style={{display: "inline-block"}}>Search Applicants</h5> &nbsp;&nbsp;&nbsp;
                    <input type="text" ref={applicantId} class="" placeholder="Applicants ID"/>&nbsp;&nbsp;&nbsp;
                    <button type="submit" class="btn btn-primary" onClick={()=>{dispatch(getApplicant(applicantId.current.value))}}>Search</button>
                </div>
                <Table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Mobile Number</th>
                            <th>Degree</th>
                            <th>email</th>
                            <th>Gender</th>
                            <th>address</th>
                            <th>shool</th>
                            <th>Percentage</th>
                            <th>Pass out year</th>
                            <th>DOB</th>
                            <th>Academic Gap</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            applicantData && applicantData.map((val)=>{
                                return(
                                    <tr>
                                        <td>{val.applicantId}</td>
                                        <td>{val.applicantName}</td>
                                        <td>{val.mobileNumber}</td>
                                        <td>{val.applicantDegree}</td>
                                        <td>{val.emailId}</td>
                                        <td>{val.gender}</td>
                                        <td>{val.address}</td>
                                        <td>{val.school}</td>
                                        <td>{val.applicantGraduationPercentage}</td>
                                        <td>{val.passOutYear}</td>
                                        <td>{val.dateOfBirth}</td>
                                        <td>{val.academicgap}</td>
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

export default ViewApplicant;