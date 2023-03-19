package com.universitycourseproject.service;

import java.util.List;

import com.universitycourseproject.entities.Course;
import com.universitycourseproject.exception.AlreadyExistException;
import com.universitycourseproject.exception.DataNotFoundException;

public interface CourseService {
	public Course addCourse(Course course)throws AlreadyExistException;
	public Course removeCourse(int courseId) throws DataNotFoundException;
	public Course updateCourse(Course course) throws DataNotFoundException;
	public Course viewCourse(int courseid) throws DataNotFoundException;
	public List<Course> viewAllCourses()throws DataNotFoundException;
}
