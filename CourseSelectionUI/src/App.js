import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom"
import "bootstrap/dist/css/bootstrap.min.css"
import Home from "./components/Home";
import Login from "./components/Login";
import StaffHome from './components/StaffHome';
import CommitteeMemberHome from "./components/CommitteeMemberHome";
import ApplicantHome from './components/ApplicantHome';
function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* <Route path="/" element={<Home />} /> */}
        <Route path="/" element={<Login/>} />
        <Route path="/staffHome" element={<StaffHome />} />
        <Route path="/committeeMember-home" element={<CommitteeMemberHome />} />
        <Route path="/applicant-home" element={<ApplicantHome />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
