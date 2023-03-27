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
  const[showSignin,setshowSignin]=useState(true);
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

    if(val.applicantName.match(!/^[a-zA-Z\s]*$/) || val.applicantName.trim() === ""){
        alert("Please enter a valid applicant name");
    }
    else if(val.mobileNumber <= 0){
        alert("Please enter a valid mobile number");
    }
    else if(val.applicantDegree.match(!/^[a-zA-Z\s]*$/) || val.applicantDegree.trim() === ""){
        alert("Please enter a valid applicant degree");
    }
    else if(val.applicantGraduationPercentage <= 0){
        alert("Please enter a valid graduation percentage");
    }
    else if(!val.emailId.match(/^[a-zA-Z0-9._%+-]+@gmail\.com$/)){
        alert("Please enter a valid email id");
    }
    else if(val.password.length > 15 || val.password.length < 3){
        alert("Password should be between 3 to 15 characters");
    }
    else if(val.passOutYear <= 0){
        alert("Please enter a valid pass out year");
    }
    else if(new Date(val.dateOfBirth) >= new Date()){
        alert("Please enter a valid date of birth");
    }
    else if(val.academicgap < 0){
        alert("Please enter a valid academic gap");
    }
    else{
        dispatch(addApplicant(val));
        setshowRegisterModel(false);
        setshowSignin(true);
    }
    
  };
  
    
  const RegisterModel = (props)=>{
   
    return(
      <>
      <center>
        <h4>Registration Form</h4>
      <Form onSubmit={handleRegister}>
        <Form.Group>
  <div class="form-outline w-50">
    <label htmlFor="applicantName" className="form-label">Applicant Name</label>
    <input type="text" autoFocus className="form-control" id="applicantName" placeholder="Enter Applicant Name" onChange={(e) => { val.applicantName = e.target.value }} required />
  </div>
  <div class="form-outline w-50">
    <label htmlFor="mobileNumber" className="form-label">Mobile Number</label>
    <input type="number" className="form-control" id="mobileNumber" placeholder="Enter Mobile Number" onChange={(e) => { val.mobileNumber = e.target.value }} required />
  </div>
  <div class="form-outline w-50">
    <label htmlFor="applicantDegree" className="form-label">Applicant Degree</label>
    <input type="text" className="form-control" id="applicantDegree" placeholder="Enter Applicant Degree" onChange={(e) => { val.applicantDegree = e.target.value }} required />
  </div>
  <div class="form-outline w-50">
    <label htmlFor="graduationPercentage" className="form-label">Graduation percentage</label>
    <input type="number" className="form-control" id="graduationPercentage" placeholder="Enter Graduation percentage" onChange={(e) => { val.applicantGraduationPercentage = e.target.value }} required />
  </div>
  <div class="form-outline w-50">
    <label htmlFor="emailId" className="form-label">Email Id</label>
    <input type="email" className="form-control" id="emailId" placeholder="Enter Email Id" onChange={(e) => { val.emailId = e.target.value }} required />
  </div>
  <div class="form-outline w-50">
    <label htmlFor="password" className="form-label">Password</label>
    <input type="password" className="form-control" id="password" placeholder="Enter Password" onChange={(e) => { val.password = e.target.value }} required />
  </div>
  <div class="form-outline w-50">
  <label htmlFor="gender" className="form-label">Gender</label>
  <select className="form-select" id="gender" onChange={(e) => { val.gender = e.target.value }} required>
    <option value="">Select Gender</option>
    <option value="male">Male</option>
    <option value="female">Female</option>
  </select>
</div>
  <div class="form-outline w-50">
    <label htmlFor="address" className="form-label">Address</label>
    <input type="text" className="form-control" id="address" placeholder="Enter Address" onChange={(e) => { val.address = e.target.value }} required />
  </div>
  <div class="form-outline w-50">
    <label htmlFor="school" className="form-label">School</label>
    <input type="text" className="form-control" id="school" placeholder="Enter School" onChange={(e) => { val.school = e.target.value }} required />
  </div>
  <div class="form-outline w-50">
    <label htmlFor="passOutYear" className="form-label">Pass Out Year</label>
    <input type="number" className="form-control" id="passOutYear" placeholder="Enter Pass Out Year" onChange={(e) => { val.passOutYear = e.target.value }} required />
  </div>
  <div class="form-outline w-50">
    <label htmlFor="dateOfBirth" className="form-label">Date Of Birth</label>
    <input type="date" className="form-control" id="dateOfBirth" onChange={(e) => { val.dateOfBirth = e.target.value }} required />
  </div>
  <div class="form-outline w-50">
  <label htmlFor="Acandemic gap" className="form-label">Academic gap</label>
  <input type="number" className="form-control" id="academicgap" placeholder="Enter Academic Gap" onChange={(e)=>{val.academicgap=e.target.value}} required /></div>
  </Form.Group>
<br/>
  <Button variant="secondary" onClick={(e)=>{
     setshowRegisterModel(false);
     setshowSignin(true);
  }}>
    Close
  </Button>
<>{"   "}</>
  <Button type="submit" variant="primary" >
    Register
  </Button>
</Form>
</center>
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
              setshowSignin(false);
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
        {
          showRegisterModel?
                <RegisterModel
        />:
        null
        }
        {
          showSignin?
      <div>
        <div className="app">
          <div className="login-form">
            <div className="title">Sign In</div>
            {renderForm}
           
          </div>
        </div>
      </div>
      : null
      }
    </>
  );
}

export default Login;