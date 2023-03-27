import React, { useEffect, useRef, useState } from "react";
import { Modal,Button,Form,Table } from 'react-bootstrap';
import { useDispatch, useSelector } from "react-redux";
import {getCommittee,getAllCommittees,deleteCommittee,updateCommittee} from "../actions/committeeMemberAction";

const ViewCommiteeMember = ({data}) =>{
    const committeeId = useRef('');
    const dispatch = useDispatch();
    const [committeeData,setCommitteeData] = useState(data);
    const [showEditCommitteeModal,setShowEditCommitteeModal] = useState(false);
    const [editCommitteeeData,setEditCommitteeData] = useState('');
    const getCommitteeSelector = useSelector((state)=>state.getCommittee.getCommitteeResp);
    console.log(getCommitteeSelector);
    useEffect(()=>{
        if(getCommitteeSelector && !getCommitteeSelector.data)
        setCommitteeData([getCommitteeSelector])
        console.log(committeeData);
    },[getCommitteeSelector])


    const onDeleteCommittee = (val)=>{
        if (window.confirm(`Are you sure, you want to delete ${val.name}`)) {
            dispatch(deleteCommittee(val.adminId))
            dispatch(getAllCommittees());   
      }  
    }
    console.log(committeeData);
    const EditCommittee = (props)=>{
        const val = props.data;
         return(
             <Modal {...props}>
                 <Modal.Header closeButton>
                 <Modal.Title>Edit Committee</Modal.Title>
                 </Modal.Header>
                 <Modal.Body>
                     <Form.Group className="mb-3" >
                         <Form.Label>Name</Form.Label>
                         <Form.Control
                             type="Text"
                             autoFocus
                             placeholder={val? val.name : null}
                             onChange={(e)=>{val.name=(e.target.value)}}
                         /><br />
                         <Form.Label>Contact</Form.Label>
                         <Form.Control
                             type="Text"
                             placeholder={val? val.adminContact : null}
                             onChange={(e)=>{val.adminContact=(e.target.value)}}
                         /><br />
                         <Form.Label>Email</Form.Label>
                        <Form.Control
                            type="Text"
                            placeholder={val? val.email : null}
                            onChange={(e)=>{
                                val.email=(e.target.value);
                            }}
                        /><br />
                        <Form.Label>Password</Form.Label>
                        <Form.Control
                            type="Text"
                            placeholder={val? val.password : null}
                            onChange={(e)=>{
                                val.password=(e.target.value);
                            }}
                        /><br />
                     </Form.Group>
                     
                 </Modal.Body>
                 <Modal.Footer>
                 <Button variant="secondary"  onClick={props.onHide}>
                     Close
                 </Button>
                 <Button variant="primary" onClick={()=>{
                     dispatch(updateCommittee(val))
                     setShowEditCommitteeModal(false)
                 }}>
                     Update
                 </Button>
                 </Modal.Footer>
             </Modal>
         )
     }
     console.log(committeeData);

    return(
        <>
            <EditCommittee 
                data={editCommitteeeData}
                show={showEditCommitteeModal}
                onHide={()=>{setShowEditCommitteeModal(false)}}
            />
            <div style = {{padding:"200px",paddingTop:"20px"}}>
                <h3>Commitee Members</h3><br/>
                <div class="">
                    <h5 style={{display: "inline-block"}}>Search Committee Member</h5> &nbsp;&nbsp;&nbsp;
                    <input type="text" ref={committeeId} class="" placeholder="Committee Member ID" />&nbsp;&nbsp;&nbsp;
                    <button type="submit" class="btn btn-primary" onClick={()=>{dispatch(getCommittee(committeeId.current.value))}}>Search</button>
                </div>
                <Table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Contact</th>
                            <th>Email</th>
                            <th>Password</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            committeeData && committeeData.map((val)=>{
                                return(
                                    <tr>
                                        <td>{val.adminId}</td>
                                        <td>{val.name}</td>
                                        <td>{val.adminContact}</td>
                                        <td>{val.email}</td>
                                        <td>{val.password}</td>
                                        <td>
                                            <button onClick={()=>{
                                                setEditCommitteeData(val);
                                                setShowEditCommitteeModal(true);
                                            }}>Edit</button> &nbsp;&nbsp;&nbsp;&nbsp;
                                            <button onClick={()=>onDeleteCommittee(val)}>Delete</button>
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

export default ViewCommiteeMember