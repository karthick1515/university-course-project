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

import com.university.courseSelection.dto.Course;
import com.university.courseSelection.dto.UniversityStaff;
import com.university.courseSelection.entity.CoursesEntity;
import com.university.courseSelection.entity.UniversityStaffMemberEntity;
import com.university.courseSelection.services.ICoursesService;
import com.university.courseSelection.services.IUniversityStaffService;

@RestController
@CrossOrigin(value="http://localhost:3000")
@RequestMapping("/university-staff")

public class UniversityStaffController {
	
	@Autowired
	private IUniversityStaffService iUniversityStaffService;
	
	@Autowired
	private ICoursesService iCoursesService;
	
	@PostMapping("/add-staff")
	ResponseEntity<UniversityStaffMemberEntity> addStaff(@Valid @RequestBody UniversityStaff universityStaffDao) {
		return new ResponseEntity<UniversityStaffMemberEntity>(iUniversityStaffService.addStaff(universityStaffDao),HttpStatus.OK);
	}
	
	@PutMapping("/update-staff")
	ResponseEntity<UniversityStaffMemberEntity> updateStaff(@RequestParam int id,@Valid @RequestBody UniversityStaff universityStaffDao) {
		return new ResponseEntity<UniversityStaffMemberEntity>(iUniversityStaffService.updateStaff(id, universityStaffDao),HttpStatus.OK);
	}
	@DeleteMapping("/remove-staff")
	ResponseEntity<UniversityStaffMemberEntity> removeStaff(@RequestParam int id) {
		return new ResponseEntity<UniversityStaffMemberEntity>(iUniversityStaffService.removeStaff(id),HttpStatus.OK);
	}
	@GetMapping("/view-staff")
	ResponseEntity<UniversityStaffMemberEntity> viewStaff(@RequestParam int id) {
		return new ResponseEntity<UniversityStaffMemberEntity>(iUniversityStaffService.viewStaff(id),HttpStatus.OK);
	}
	@GetMapping("/view-all-staff")
	List<UniversityStaffMemberEntity> viewAllStaff() {
		return iUniversityStaffService.viewAllStaff();
	}
	
	@PostMapping("/add-course")
	ResponseEntity<CoursesEntity> addCourse(@Valid @RequestBody Course courseDao) {
		return new ResponseEntity<CoursesEntity>(iCoursesService.addCourse(courseDao),HttpStatus.OK);
	}

	@PutMapping("/update-course")
	ResponseEntity<CoursesEntity>  updateCourse(@RequestParam int id,@Valid @RequestBody Course courseDao) {
		return new ResponseEntity<CoursesEntity>(iCoursesService.updateCourse(id, courseDao),HttpStatus.OK);
	}
	
	@DeleteMapping("/remove-course")
	ResponseEntity<CoursesEntity>  removeCourse(@RequestParam int id) {
		return new ResponseEntity<CoursesEntity>(iCoursesService.removeCourse(id),HttpStatus.OK);
	}
	
	
}
