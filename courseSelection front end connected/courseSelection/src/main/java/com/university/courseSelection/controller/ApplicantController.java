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
import com.university.courseSelection.entiy.AdmissionEntity;
import com.university.courseSelection.entiy.ApplicantEntity;
import com.university.courseSelection.entiy.CoursesEntity;
import com.university.courseSelection.services.IApplicantService;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
	
	@Autowired
	private IApplicantService iApplicantService;
	
	@PostMapping("/add-applicant")
	ResponseEntity<ApplicantEntity> addApplicant(@Valid @RequestBody Applicant applicantDao) {
		return new ResponseEntity<ApplicantEntity>(iApplicantService.addApplicant(applicantDao),HttpStatus.OK);
	}
	
	@PutMapping("/update-applicant")
	ResponseEntity<ApplicantEntity> updateApplicant(@RequestParam int id, @Valid @RequestBody Applicant applicantDao) {
		return new ResponseEntity<ApplicantEntity>(iApplicantService.updateApplicant(id,applicantDao),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-applicant")
	ResponseEntity<ApplicantEntity> deleteApplicant(@RequestParam int id) {
		return new ResponseEntity<ApplicantEntity>(iApplicantService.deleteApplicant(id),HttpStatus.OK);
	}
	
	@GetMapping("/view-applicant")
	ResponseEntity<ApplicantEntity> viewApplicant(@RequestParam int id) {
		return new ResponseEntity<ApplicantEntity>(iApplicantService.viewApplicant(id),HttpStatus.OK);
	}
	
	@GetMapping("/view-all-applicant")
	List<ApplicantEntity> viewAllApplicant() {
		return iApplicantService.viewAllApplicant();
	}
	
	@GetMapping("/get-applicant-course")
	List<Integer> getApplicantCourse(@RequestParam int id) {
		return iApplicantService.getApplicantCourse(id);
	}
	
}
