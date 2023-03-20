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
import com.university.courseSelection.services.ICoursesService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private ICoursesService iCoursesService;
	
	@PostMapping("/add-course")
	ResponseEntity addCourse(@Valid @RequestBody CourseDao courseDao) {
		return iCoursesService.addCourse(courseDao);
	}

	@PutMapping("/update-course")
	ResponseEntity updateCourse(@RequestParam int id,@Valid @RequestBody CourseDao courseDao) {
		return iCoursesService.updateCourse(id,courseDao);
	}
	
	@DeleteMapping("/remove-course")
	ResponseEntity removeCourse(@RequestParam int id) {
		return iCoursesService.removeCourse(id);
	}
	
	@GetMapping("/view-course")
	ResponseEntity viewCourse(@RequestParam int id) {
		return iCoursesService.viewCourse(id);
	}
	
	@GetMapping("/view-all-courses")
	ResponseEntity viewAllCourses() {
		return iCoursesService.viewAllCourses();
	}
}
