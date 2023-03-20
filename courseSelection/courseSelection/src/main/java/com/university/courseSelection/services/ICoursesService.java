package com.university.courseSelection.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dao.CourseDao;

@Service
public interface ICoursesService {

	ResponseEntity addCourse(CourseDao courseDao);

	ResponseEntity updateCourse(int id, CourseDao courseDao);

	ResponseEntity removeCourse(int id);

	ResponseEntity viewCourse(int id);

	ResponseEntity viewAllCourses();

}
