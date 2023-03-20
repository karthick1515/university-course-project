package com.university.courseSelection.controller;

import java.time.LocalDate;
import java.util.Date;

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

import com.university.courseSelection.dao.AdmissionDao;
import com.university.courseSelection.services.IAdmissionService;

import lombok.Getter;

@RestController
@RequestMapping("/admission")
public class AdmissionController {
	
	@Autowired
	private IAdmissionService iAdmissionService;
	
	@PostMapping("/add-admission")
	ResponseEntity addAdmission(@Valid @RequestBody AdmissionDao admissionDao) {
		return iAdmissionService.addAdmission(admissionDao);
	}
	
	@PutMapping("/update-admission")
	ResponseEntity updateAdmission(@Valid @RequestParam int id,@Valid @RequestBody AdmissionDao admissionDao) {
		return iAdmissionService.updateAdmission(id,admissionDao);
	}
	@DeleteMapping("/cancel-admission")
	ResponseEntity cancelAdmission(@RequestParam int id) {
		return iAdmissionService.cancelAdmission(id);
	}
	
	@GetMapping("/show-all-admissions")
	ResponseEntity showAllAdmissionByCourseId() {
		return iAdmissionService.showAllAdmission();
	}
	
	@GetMapping("/show-admission-by-id")
	ResponseEntity showAllAdmissionByDate(@RequestParam int id) {
		return iAdmissionService.showAdmissionById(id);
	}
	
}
