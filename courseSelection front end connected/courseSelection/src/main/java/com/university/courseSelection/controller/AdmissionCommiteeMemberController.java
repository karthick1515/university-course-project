package com.university.courseSelection.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.university.courseSelection.dto.AdmissionCommiteeMember;
import com.university.courseSelection.entiy.AdmissionCommiteeMemberEntiy;
import com.university.courseSelection.services.IAdmissionCommiteeMemberService;

@RestController
@CrossOrigin(value="http://localhost:3000")
@RequestMapping("/admission-commitee-member")
public class AdmissionCommiteeMemberController {
	
	@Autowired
	private IAdmissionCommiteeMemberService iAdmissionCommiteeMemberService;
	
	@PostMapping("/add-commitee-member")
	ResponseEntity<AdmissionCommiteeMemberEntiy> addCommiteeMemeber(@Valid @RequestBody AdmissionCommiteeMember admissionCommiteeMemberDao) {
		return new ResponseEntity<AdmissionCommiteeMemberEntiy>(iAdmissionCommiteeMemberService.addCommiteeMemeber(admissionCommiteeMemberDao),HttpStatus.OK);
	}
	
	@PutMapping("/update-commitee-member")
	ResponseEntity<AdmissionCommiteeMemberEntiy> updateCommiteeMember(@Valid @RequestParam int id,@Valid @RequestBody AdmissionCommiteeMember admissionCommiteeMemberDao) {
		return new ResponseEntity<AdmissionCommiteeMemberEntiy>(iAdmissionCommiteeMemberService.updateCommiteeMember(id,admissionCommiteeMemberDao),HttpStatus.OK);
	}
	
	@GetMapping("/view-commitee-member")
	ResponseEntity<AdmissionCommiteeMemberEntiy> viewCommiteeMember(@Valid @RequestParam int id) {
		return new ResponseEntity<AdmissionCommiteeMemberEntiy>(iAdmissionCommiteeMemberService.viewCommiteeMember(id),HttpStatus.OK);
	}
	
	@GetMapping("/view-all-commitee-member")
	List<AdmissionCommiteeMemberEntiy>viewAllCommiteeMember() {
		return iAdmissionCommiteeMemberService.viewAllCommiteeMember();
	}
	
	@DeleteMapping("/remove-commitee-member")
	ResponseEntity<AdmissionCommiteeMemberEntiy> removeCommiteeMember(@Valid @RequestParam int id) {
		return new ResponseEntity<AdmissionCommiteeMemberEntiy>(iAdmissionCommiteeMemberService.removeCommiteeMember(id),HttpStatus.OK);
	}
	
}
