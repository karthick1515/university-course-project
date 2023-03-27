import React,{useRef,useState,useEffect} from "react";
import { Table} from 'react-bootstrap';
import { useDispatch, useSelector } from "react-redux";
import { getStaff } from "../actions/staffAction";


const ViewStaffs = ({data}) =>{
    console.log(data);
    const [staffData,setStaffData] = useState(data);
    const staffId = useRef('');
    const dispatch = useDispatch();
    const getStaffSelector = useSelector((state)=>state.getStaff.getStaffResp)

    useEffect(()=>{
        if(getStaffSelector && !getStaffSelector.data)
        setStaffData([getStaffSelector])
    },[getStaffSelector])
    
    return(
        <>
            <div style = {{padding:"200px",paddingTop:"20px"}}>
                <h3>Staffs</h3><br/>
                <div class="">
                    <h5 style={{display: "inline-block"}}>Search Staffs</h5> &nbsp;&nbsp;&nbsp;
                    <input type="text" ref={staffId} class="" placeholder="Staff ID"/>&nbsp;&nbsp;&nbsp;
                    <button type="submit" class="btn btn-primary" onClick={()=>{dispatch(getStaff(staffId.current.value))}}>Search</button>
                </div>
                <Table>
                    <thead>
                        <tr>
                            <th>Staff Id</th>
                            <th>Role</th>
                            <th>Email</th>
                            <th>Password</th>
                                                      
                        </tr>
                    </thead>
                    <tbody>
                        {
                            staffData && staffData.map((val)=>{
                                return(
                                    <tr>
                                        <td>{val.staffId}</td>
                                        <td>{val.role}</td>
                                        <td>{val.email}</td>
                                        <td>{val.password}</td>
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

export default ViewStaffs;