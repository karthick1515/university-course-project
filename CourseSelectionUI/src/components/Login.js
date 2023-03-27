import React, { useEffect, useState } from "react";
import { Modal,Button,Form} from 'react-bootstrap';
import { useDispatch, useSelector } from "react-redux";
import  { useNavigate } from 'react-router-dom'
import {loginAction} from "../actions/loginAction"
import { Navbar,Container,Nav  } from 'react-bootstrap';
import {getApplicantCourseId,addApplicant} from "../actions/applicantAction";

const  Login = () => {
  
  const [errorMessages, setErrorMessages] = useState({});
  const [showRegisterModel, setshowRegisterModel] = useState(false);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const [roleValue,setRoleValue] = useState();
  const loginResp = useSelector((state)=>state.getLogin.getLoginResp)

  useEffect(()=>{
    if(loginResp && loginResp.status==200){
      if(roleValue=="APPLICANT"){
        dispatch(getApplicantCourseId(loginResp.data.applicantId))
        navigate("/applicant-home")
      }
      else if(roleValue=="STAFF")
        navigate("/staffHome")
      else if(roleValue=="COMMITEE")
        navigate("/committeeMember-home")
    }
  },[loginResp])
  let val = { }
  const handleRegister = (event) => {
    event.preventDefault();
    
    const form = event.target;
    
    if (form.checkValidity()) {
      dispatch(addApplicant(val));
      setshowRegisterModel(false);
    } else {
      // update placeholder values of invalid inputs
      const invalidInputs = form.querySelectorAll(':invalid');
      invalidInputs.forEach((input) => {
        input.placeholder = 'Required';
      });
    }
  };
  
    
  const RegisterModel = (props)=>{
   
    return(
      <>
      <Modal {...props}>
        <Form onSubmit={handleRegister}>
          <Modal.Header closeButton>
          <Modal.Title>Applicant Register</Modal.Title>
          </Modal.Header>
          <Modal.Body>
              <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                  <Form.Label>Applicant Name</Form.Label>
                  <Form.Control
                      type="Text"
                      autoFocus
                      placeholder="Applicant Name"
                      onChange={(e)=>{val.applicantName=(e.target.value)}} 
                      required
                  /><br />
                  <Form.Label>Mobile Number</Form.Label>
                  <Form.Control
                      type="Text"
                      placeholder="Mobile Number"
                      onChange={(e)=>{
                        val.mobileNumber=(e.target.value);

                      }}
                      required
                  /><br />
                  <Form.Label>Applicant Degree</Form.Label>
                  <Form.Control
                      type="Text"
                      placeholder="Applicant Degree"
                      onChange={(e)=>{
                        val.applicantDegree=(e.target.value);
                      }}
                      required
                  /><br />
                  <Form.Label>Graduation percentage</Form.Label>
                  <Form.Control
                     type="Text"
                     placeholder="Graduation percentage"
                     onChange={(e)=>{
                      val.applicantGraduationPercentage=(e.target.value);
                     }}required
                  /><br />
                  <Form.Label>Email Id</Form.Label>
                  <Form.Control
                     type="Text"
                     placeholder="Email Id"
                     onChange={(e)=>{
                      val.emailId=(e.target.value);
                     }} required
                  /><br />
                  <Form.Label>Password</Form.Label>
                  <Form.Control
                     type="Text"
                     placeholder=" Password"
                     onChange={(e)=>{
                      val.password=(e.target.value);
                     }} required
                  /><br />
                  <Form.Label>Gender</Form.Label>
                  <Form.Control
                     type="Text"
                     placeholder="Gender"
                     onChange={(e)=>{
                      val.gender=(e.target.value);
                     }} required
                  /><br />
                  <Form.Label>Address</Form.Label>
                  <Form.Control
                     type="Text"
                     placeholder="Address"
                     onChange={(e)=>{
                      val.address=(e.target.value);
                     }} required
                  /><br />
                  <Form.Label>School</Form.Label>
                  <Form.Control
                     type="Text"
                     placeholder="School"
                     onChange={(e)=>{
                      val.school=(e.target.value);
                     }} required
                  /><br />
                  <Form.Label>Pass Out Year</Form.Label>
                  <Form.Control
                      type="Number"
                      placeholder="Pass Out Year"
                      onChange={(e)=>{
                        val.passOutYear=(e.target.value);
                      }} required
                  /><br />
                  <Form.Label>Date Of Birth</Form.Label>
                  <Form.Control
                      type="date"
                      onChange={(e)=>{
                        val.dateOfBirth=(e.target.value);
                      }} required
                  /><br />
                  <Form.Label>Academic Gap</Form.Label>
                  <Form.Control
                      type="Number"
                      placeholder="Academic Gap"
                      onChange={(e)=>{
                        val.academicgap=(e.target.value);
                      }} required
                  /><br />
              </Form.Group>
              
          </Modal.Body>
          <Modal.Footer>
          <Button variant="secondary"  onClick={props.onHide}>
              Close
          </Button>
        
          <input type="submit" value="Register" class="btn btn-success h-75 pr-3" variant="primary" onClick={handleRegister} />
      
          </Modal.Footer>
          </Form>
      </Modal>
      </>
  )
 }
  

  const errors = {
    uname: "invalid username",
    pass: "invalid password",
    role: "Choose a Role"
  };

  const handleSubmit = (event) => {
    event.preventDefault();
  
    const form = event.target;
  
    if (form.checkValidity()) {
      // submit form
      var { uname, pass, role } = document.forms[0];
      setRoleValue(role.value)
      dispatch(loginAction(uname.value,pass.value,role.value))
      console.log(uname.value,pass.value,role.value)
    } else {
      // show error message
      const invalidInputs = form.querySelectorAll(':invalid');
      invalidInputs.forEach((input) => {
        input.setCustomValidity('Please fill out this field');
      });
      form.reportValidity();
    }
  };
  
  const renderForm = (
    <div className="form">
      <form onSubmit={handleSubmit}>
        <div className="input-container">
          <label>Email </label>
          <input type="text" name="uname" required />
        </div>
        <div className="input-container">
          <label>Password </label>
          <input type="password" name="pass" required />
        </div>
        <div className="input-container">
          <label>Role </label>
        </div>
        <div>
          <input type="radio" value="APPLICANT" name="role" required class="w-25" />Applicant
          <input type="radio" value="STAFF" name="role" required class="w-25" />Staff
          <input type="radio" value="COMMITEE" name="role" required class="w-25" />Commitee Member
        </div>
        <div className="button-container pt-3">
          <input type="submit" class="btn btn-success h-75 pr-3" value="Sign In" />
        </div>
        <div className="button-container pt-3">
          <Form.Label>New Applicant</Form.Label>
        </div>
        <div className="button-container pt-3">
          <input
            type="button"
            class="btn btn-dark h-75 pl-3"
            value="Register"
            onClick={(e) => {
              setshowRegisterModel(true);
            }}
          />
        </div>
      </form>
    </div>
  );
  
  return (
    <>
      <Navbar collapseOnSelect expand="lg" bg="success" variant="dark">
            <Container fluid>
                <Navbar.Brand href="/">CourseSelection <a href="/"></a></Navbar.Brand>
                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse id="navbarScroll">
                <Nav
                    className="me-auto my-2 my-lg-0"
                    style={{ maxHeight: '100px' }}
                    navbarScroll
                >
                    
                    <Nav.Link href="/">Home</Nav.Link>
                </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
        <RegisterModel
          show={showRegisterModel}
          onHide={()=>{setshowRegisterModel(false)}}
        />
      <div>
        <div className="app">
          <div className="login-form">
            <div className="title">Sign In</div>
            {renderForm}
          </div>
        </div>
      </div>
    </>
  );
}

export default Login;