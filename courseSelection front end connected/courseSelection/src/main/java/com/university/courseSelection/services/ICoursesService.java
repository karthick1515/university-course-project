package com.university.courseSelection.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.Course;
import com.university.courseSelection.entiy.CoursesEntity;

@Service
public interface ICoursesService {

	CoursesEntity addCourse(Course courseDao);

	CoursesEntity updateCourse(int id, Course courseDao);

	CoursesEntity removeCourse(int id);

	CoursesEntity viewCourse(int id);

	List<CoursesEntity> viewAllCourses();

}
