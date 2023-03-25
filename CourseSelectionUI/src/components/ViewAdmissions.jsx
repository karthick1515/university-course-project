import React,{useRef,useState,useEffect} from "react";
import { Navbar,Container,Nav,Dropdown,Modal,Button,Form,Table,Row } from 'react-bootstrap';
import { useDispatch, useSelector } from "react-redux";
import {getAdmission,updateAdmission} from "./../actions/admissionAction";

const ViewAdmissions = ({data,user}) =>{
    
    const [admissionData,setAdmissionData] = useState(data);
    const [admissionEditModal,setAdmissionEditModal] = useState(false);
    const [editAdmissionData,setEditAdmissionData] = useState(false);
    const admissionId = useRef('');
    const dispatch = useDispatch();
    const getAdmissionSelector = useSelector((state)=>state.getAdmission.getAdmissionResp)

    useEffect(()=>{
        if(getAdmissionSelector && !getAdmissionSelector.data)
        setAdmissionData([getAdmissionSelector])
    },[getAdmissionSelector])


    const EditAdmission = (props)=>{
        let val = props.data;
        if(!val) return;
        val = {
            admissionId: val.admissionId,
            courseId: val.courseId && val.courseId.courseId,
            applicantId: val.applicantId.applicantId,
            admissionDate: val.admissionDate,
            admissionStatu: val.admissionStatus,
            appliedDate: val.appliedDate
          }
         return(
             <Modal {...props}>
                 <Modal.Header closeButton>
                 <Modal.Title>Edit Admission</Modal.Title>
                 </Modal.Header>
                 <Modal.Body>
                     <Form.Group className="mb-3" >
                         <Form.Label>Status</Form.Label>
                         <Form.Select 
                            type="Text"
                            autoFocus
                            placeholder="Status"
                            onChange={(e)=>{val.admissionStatus=(e.target.value)}}
                            required
                        >
                            <option value="Applied">Applied</option>
                            <option value="Pending">Pending</option>
                            <option value="Confirmed">Confirmed</option>
                            <option value="Rejected">Rejected</option>
                        </Form.Select>
                        <Form.Label>Admission Date</Form.Label>
                        <Form.Control
                            type="date"
                            placeholder={val? val.admissionDate : null}
                            onChange={(e)=>{
                                val.admissionDate=(e.target.value);
                            }}
                        /><br />
                     </Form.Group>
                     
                 </Modal.Body>
                 <Modal.Footer>
                 <Button variant="secondary"  onClick={props.onHide}>
                     Close
                 </Button>
                 <Button variant="primary" onClick={()=>{
                     dispatch(updateAdmission(val))
                     setAdmissionEditModal(false)
                 }}>
                     Update
                 </Button>
                 </Modal.Footer>
             </Modal>
         )
     }

    return(
        <>
            <EditAdmission 
                data={editAdmissionData}
                show={admissionEditModal}
                onHide={()=>{setAdmissionEditModal(false)}}
            />
            <div style = {{padding:"200px",paddingTop:"20px"}}>
                <h3>Admissions</h3><br/>
                <div class="">
                    <h5 style={{display: "inline-block"}}>Search Admissions</h5> &nbsp;&nbsp;&nbsp;
                    <input type="text" ref={admissionId} class="" placeholder="Admissions ID"/>&nbsp;&nbsp;&nbsp;
                    <button type="submit" class="btn btn-primary" onClick={()=>{dispatch(getAdmission(admissionId.current.value))}}>Search</button>
                </div>
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
                            {
                                user=="COMMITTEE_MEMBER"?
                                <th>Action</th>:
                                null
                            }
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
                                        {
                                            user=="COMMITTEE_MEMBER"?
                                            <td>
                                                <button onClick={()=>{
                                                    setEditAdmissionData(val)
                                                    setAdmissionEditModal(true)
                                                    }}>Edit Status</button>
                                            </td>:
                                            null
                                        }
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

export default ViewAdmissions;