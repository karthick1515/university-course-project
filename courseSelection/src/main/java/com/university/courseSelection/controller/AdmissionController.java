package com.university.courseSelection.controller;

import java.time.LocalDate;
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

import com.university.courseSelection.dto.Admission;
import com.university.courseSelection.entity.AdmissionEntity;
import com.university.courseSelection.exception.AlreadyExistsException;
import com.university.courseSelection.services.IAdmissionService;

@RestController
@RequestMapping("/admission")
@CrossOrigin(value="http://localhost:3000")
public class AdmissionController {
	
	@Autowired
	private IAdmissionService iAdmissionService;
	
	@PostMapping("/add-admission")
	ResponseEntity<AdmissionEntity> addAdmission(@Valid @RequestBody Admission admissionDao) throws AlreadyExistsException{
		if(iAdmissionService.showAdmissionByApplicantId(admissionDao.getApplicantId())==null) {
		return new ResponseEntity<AdmissionEntity>(iAdmissionService.addAdmission(admissionDao),HttpStatus.OK);
		}else {
			throw new AlreadyExistsException("Applicant already applied for a Course");
		}
	}
	
	@PutMapping("/update-admission")
	ResponseEntity<AdmissionEntity> updateAdmission(@Valid @RequestParam int id,@Valid @RequestBody Admission admissionDao) {
		return new ResponseEntity<AdmissionEntity>(iAdmissionService.updateAdmission(id,admissionDao),HttpStatus.OK);
	}
	@DeleteMapping("/cancel-admission")
	ResponseEntity<AdmissionEntity> cancelAdmission(@RequestParam int id) {
		return new ResponseEntity<AdmissionEntity>(iAdmissionService.cancelAdmission(id),HttpStatus.OK);
	}
	
	@GetMapping("/show-all-admission-by-courseId")
	List<AdmissionEntity> showAllAdmissionByCourseId(@RequestParam int courseId) {
		return iAdmissionService.showAllAdmissionByCourseId(courseId);
	}
	
	@GetMapping("/show-admission-by-applicantid")
	ResponseEntity<AdmissionEntity> showAllAdmissionByDate(@RequestParam int id) {
		return new ResponseEntity<AdmissionEntity>(iAdmissionService.showAdmissionByApplicantId(id),HttpStatus.OK);
	}
	

	@GetMapping("/show-all-admission")
	List<AdmissionEntity> showAllAdmission() {
		return iAdmissionService.showAllAdmission();
	}
	
	@GetMapping("/show-admission-by-id")
	ResponseEntity<AdmissionEntity> showAdmissionById(@RequestParam int id) {
		return new ResponseEntity<AdmissionEntity>(iAdmissionService.showAdmissionById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("cancel-admission-for-appplicant")
	ResponseEntity<AdmissionEntity> cancelAdmissionForAppplicant(@RequestParam int id) {
		return new ResponseEntity<AdmissionEntity>(iAdmissionService.cancelAdmissionForAppplicant(id),HttpStatus.OK);
	}
}
