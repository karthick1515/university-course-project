package com.university.courseSelection.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.university.courseSelection.services.ILoginService;

@RestController
public class LoginController {
	
	@Autowired
	private ILoginService iLoginService;
	
	@GetMapping("/login-as-applicant")
	ResponseEntity loginAsApplicant(@Valid @RequestParam String email, @RequestParam String password) {
		return iLoginService.loginAsApplicant(email,password);
	}

	@GetMapping("/login-as-admission-commitee-member")
	ResponseEntity loginAsAdmissionCommiteeMember(@RequestParam String email, @RequestParam String password) {
		return iLoginService.loginAsAdmissionCommiteeMember(email,password);
	}
	@GetMapping("/login-as-university-staff-member")
	ResponseEntity loginAsuniversityStaffMember(@RequestParam String email, @RequestParam String password) {
		return iLoginService.loginAsuniversityStaffMember(email,password);
	}
}
