package com.university.courseSelection.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.university.courseSelection.dao.AdmissionCommiteeMemberDao;
import com.university.courseSelection.services.IAdmissionCommiteeMemberService;

@RestController
@RequestMapping("/admission-commitee-member")
public class AdmissionCommiteeMemberController {
	
	@Autowired
	private IAdmissionCommiteeMemberService iAdmissionCommiteeMemberService;
	
	@PostMapping("/add-commitee-member")
	ResponseEntity addCommiteeMemeber(@Valid @RequestBody AdmissionCommiteeMemberDao admissionCommiteeMemberDao) {
		return iAdmissionCommiteeMemberService.addCommiteeMemeber(admissionCommiteeMemberDao);
	}
	
	@PutMapping("/update-commitee-member")
	ResponseEntity updateCommiteeMember(@Valid @RequestParam int id,@Valid @RequestBody AdmissionCommiteeMemberDao admissionCommiteeMemberDao) {
		return iAdmissionCommiteeMemberService.updateCommiteeMember(id,admissionCommiteeMemberDao);
	}
	
	@GetMapping("/view-commitee-member")
	ResponseEntity viewCommiteeMember(@Valid @RequestParam int id) {
		return iAdmissionCommiteeMemberService.viewCommiteeMember(id);
	}
	
	@DeleteMapping("/remove-commitee-member")
	ResponseEntity removeCommiteeMember(@Valid @RequestParam int id) {
		return iAdmissionCommiteeMemberService.removeCommiteeMember(id);
	}
	
}
