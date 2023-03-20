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

import com.university.courseSelection.dao.AdmissionStatus;
import com.university.courseSelection.dao.ApplicantDao;
import com.university.courseSelection.services.IApplicantService;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
	
	@Autowired
	private IApplicantService iApplicantService;
	
	@PostMapping("/add-applicant")
	ResponseEntity addApplicant(@Valid @RequestBody ApplicantDao applicantDao) {
		return iApplicantService.addApplicant(applicantDao);
	}
	
	@PutMapping("/update-applicant")
	ResponseEntity updateApplicant(@RequestParam int id, @Valid @RequestBody ApplicantDao applicantDao) {
		return iApplicantService.updateApplicant(id,applicantDao);
	}
	
	@DeleteMapping("/delete-applicant")
	ResponseEntity deleteApplicant(@RequestParam int id) {
		return iApplicantService.deleteApplicant(id);
	}
	
	@GetMapping("/view-applicant")
	ResponseEntity viewApplicant(@RequestParam int id) {
		return iApplicantService.viewApplicant(id);
	}
	@GetMapping("/view-all-applicant")
	ResponseEntity viewApplicantByStatus(@Valid @RequestParam AdmissionStatus admissionStatus) {
		return iApplicantService.viewallApplicant();
	}
}
