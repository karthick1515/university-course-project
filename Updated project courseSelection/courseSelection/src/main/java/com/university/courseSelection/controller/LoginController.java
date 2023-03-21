package com.university.courseSelection.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.university.courseSelection.entiy.AdmissionCommiteeMemberEntiy;
import com.university.courseSelection.entiy.ApplicantEntity;
import com.university.courseSelection.entiy.UniversityStaffMemberEntity;
import com.university.courseSelection.services.ILoginService;

@RestController
public class LoginController {
	
	@Autowired
	private ILoginService iLoginService;
	
	@GetMapping("/login-as-applicant")
	ResponseEntity<ApplicantEntity> loginAsApplicant(@Valid @RequestParam String email, @RequestParam String password) {
		return new ResponseEntity<ApplicantEntity>(iLoginService.loginAsApplicant(email,password),HttpStatus.OK);
	}

	@GetMapping("/login-as-admission-commitee-member")
	ResponseEntity<AdmissionCommiteeMemberEntiy> loginAsAdmissionCommiteeMember(@RequestParam String email, @RequestParam String password) {
		return new ResponseEntity<AdmissionCommiteeMemberEntiy>(iLoginService.loginAsAdmissionCommiteeMember(email,password),HttpStatus.OK);
	}
	@GetMapping("/login-as-university-staff-member")
	ResponseEntity<UniversityStaffMemberEntity> loginAsuniversityStaffMember(@RequestParam String email, @RequestParam String password) {
		return new ResponseEntity<UniversityStaffMemberEntity>(iLoginService.loginAsuniversityStaffMember(email,password),HttpStatus.OK);
	}
}
