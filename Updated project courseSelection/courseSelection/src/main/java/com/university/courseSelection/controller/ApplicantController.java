package com.university.courseSelection.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.university.courseSelection.dto.Applicant;
import com.university.courseSelection.entiy.ApplicantEntity;
import com.university.courseSelection.services.IApplicantService;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
	
	@Autowired
	private IApplicantService iApplicantService;
	
	@PostMapping("/add-applicant")
	public ResponseEntity<ApplicantEntity> addApplicant(@Valid @RequestBody Applicant applicant) {
		return new ResponseEntity<ApplicantEntity>(iApplicantService.addApplicant(applicant),HttpStatus.OK);
	}
	
	@PutMapping("/update-applicant")
	public ResponseEntity<ApplicantEntity> updateApplicant(@RequestParam int id, @Valid @RequestBody Applicant applicant) {
		return new ResponseEntity<ApplicantEntity>(iApplicantService.updateApplicant(id,applicant),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-applicant")
	public ResponseEntity<ApplicantEntity> deleteApplicant(@RequestParam int id) {
		return new ResponseEntity<ApplicantEntity>(iApplicantService.deleteApplicant(id),HttpStatus.OK);
	}
	
	@GetMapping("/view-applicant")
	public ResponseEntity<ApplicantEntity> viewApplicant(@RequestParam int id) {
		return new ResponseEntity<ApplicantEntity>(iApplicantService.viewApplicant(id),HttpStatus.OK);
	}
	
	@GetMapping("/view-all-applicant")
	public List<ApplicantEntity>viewAllApplicant() {
		return iApplicantService.viewallApplicant();
	}
}
