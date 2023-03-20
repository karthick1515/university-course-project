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

import com.university.courseSelection.dao.CourseDao;
import com.university.courseSelection.dao.UniversityStaffDao;
import com.university.courseSelection.services.ICoursesService;
import com.university.courseSelection.services.IUniversityStaffService;

@RestController
@RequestMapping("/university-staff")
public class UniversityStaffController {
	
	@Autowired
	private IUniversityStaffService iUniversityStaffService;
	
	@Autowired
	private ICoursesService iCoursesService;
	
	@PostMapping("/add-staff")
	ResponseEntity addStaff(@Valid @RequestBody UniversityStaffDao universityStaffDao) {
		return iUniversityStaffService.addStaff(universityStaffDao);
	}
	
	@PutMapping("/update-staff")
	ResponseEntity updateStaff(@RequestParam int id,@Valid @RequestBody UniversityStaffDao universityStaffDao) {
		return iUniversityStaffService.updateStaff(id, universityStaffDao);
	}
	@DeleteMapping("/remove-staff")
	ResponseEntity removeStaff(@RequestParam int id) {
		return iUniversityStaffService.removeStaff(id);
	}
	@GetMapping("/view-staff")
	ResponseEntity viewStaff(@RequestParam int id) {
		return iUniversityStaffService.viewStaff(id);
	}
	@GetMapping("/view-all-staff")
	ResponseEntity viewAllStaff() {
		return iUniversityStaffService.viewAllStaff();
	}
	
	@PostMapping("/add-course")
	ResponseEntity addCourse(@Valid @RequestBody CourseDao courseDao) {
		return iCoursesService.addCourse(courseDao);
	}

	@PutMapping("/update-course")
	ResponseEntity updateCourse(@RequestParam int id,@Valid @RequestBody CourseDao courseDao) {
		return iCoursesService.updateCourse(id, courseDao);
	}
	
	@DeleteMapping("/remove-course")
	ResponseEntity removeCourse(@RequestParam int id) {
		return iCoursesService.removeCourse(id);
	}
	
	
}
