package com.university.courseSelection.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.university.courseSelection.dto.Admission;
import com.university.courseSelection.entiy.AdmissionEntity;
import com.university.courseSelection.services.IAdmissionService;

@RestController
@RequestMapping("/admission")
public class AdmissionController {

	@Autowired
	private IAdmissionService iAdmissionService;

	@PostMapping("/add-admission")
	public ResponseEntity<AdmissionEntity> addAdmission(@Valid @RequestBody Admission admission) {
		return new ResponseEntity<AdmissionEntity>(iAdmissionService.addAdmission(admission), HttpStatus.CREATED);
	}

	@PutMapping("/update-admission")
	public ResponseEntity<AdmissionEntity> updateAdmission(@Valid @RequestParam int id, @Valid @RequestBody Admission admission) {
		return new ResponseEntity<AdmissionEntity>(iAdmissionService.updateAdmission(id, admission), HttpStatus.OK);
	}

	@DeleteMapping("/cancel-admission")
	public ResponseEntity<AdmissionEntity> cancelAdmission(@RequestParam int id) {
		return new ResponseEntity<AdmissionEntity>(iAdmissionService.cancelAdmission(id), HttpStatus.OK);
	}

	@GetMapping("/show-all-admissions")
	public List<AdmissionEntity> showAllAdmissionByCourseId() {
		return iAdmissionService.showAllAdmission();
	}

	@GetMapping("/show-admission-by-id")
	public ResponseEntity<AdmissionEntity> showAllAdmissionByDate(@RequestParam int id) {
		return new ResponseEntity<AdmissionEntity>(iAdmissionService.showAdmissionById(id),HttpStatus.OK);
	}
}
