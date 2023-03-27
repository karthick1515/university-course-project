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
import com.university.courseSelection.entity.CoursesEntity;
import com.university.courseSelection.services.ICoursesService;

@RestController
@RequestMapping("/course")
@CrossOrigin(value="http://localhost:3000")
public class CourseController {
	
	@Autowired
	private ICoursesService iCoursesService;
	
	@PostMapping("/add-course")
	ResponseEntity<CoursesEntity> addCourse(@Valid @RequestBody Course course) {
		return new ResponseEntity<CoursesEntity>(iCoursesService.addCourse(course),HttpStatus.OK);
	}

	@PutMapping("/update-course")
	ResponseEntity<CoursesEntity> updateCourse(@RequestParam int id,@Valid @RequestBody Course course) {
		return new ResponseEntity<CoursesEntity>(iCoursesService.updateCourse(id,course),HttpStatus.OK);
	}
	
	@DeleteMapping("/remove-course")
	ResponseEntity<CoursesEntity> removeCourse(@RequestParam int id) {
		return new ResponseEntity<CoursesEntity>(iCoursesService.removeCourse(id),HttpStatus.OK);
	}
	
	@GetMapping("/view-course")
	ResponseEntity<CoursesEntity> viewCourse(@RequestParam int id) {
		return new ResponseEntity<CoursesEntity>(iCoursesService.viewCourse(id),HttpStatus.OK);
	}
	
	@GetMapping("/view-all-courses")
	List<CoursesEntity> viewAllCourses() {
		return iCoursesService.viewAllCourses();
	}
}
