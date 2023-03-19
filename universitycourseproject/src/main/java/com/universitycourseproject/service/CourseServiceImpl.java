package com.universitycourseproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.universitycourseproject.entities.Applicant;
import com.universitycourseproject.entities.Course;
import com.universitycourseproject.exception.AlreadyExistException;
import com.universitycourseproject.exception.DataNotFoundException;
import com.universitycourseproject.repository.CourseRepo;

public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepo courserepo;
	@Override
	public Course addCourse(Course course) throws AlreadyExistException {
		
		Optional<Course> optional=courserepo.findById(course.getCourseId());
		if(optional.isPresent()) {
			throw new AlreadyExistException("Course Already Exist");
		}else 
		{
			Course addedcourse=courserepo.save(course);
			return addedcourse;
		}
	}

	@Override
	public Course removeCourse(int courseId) throws DataNotFoundException {
		Optional<Course> optional=courserepo.findById(courseId);
		if(optional.isEmpty() ) {
			throw new DataNotFoundException("There is no course with this Id");
		}
		else {
			courserepo.deleteById(courseId);
			return optional.get();
		}
		
	}

	@Override
	public Course updateCourse(Course course) throws DataNotFoundException {
		Optional<Course> optional=courserepo.findById(course.getCourseId());
		if(optional.isEmpty()) {
			throw new DataNotFoundException("Course is not available with the given Id");
		}else 
		{
			Course updatedcourse=courserepo.save(course);
			return updatedcourse;
		}
	}

	@Override
	public Course viewCourse(int courseid) throws DataNotFoundException {
		Optional<Course> optional=courserepo.findById(courseid);
		if(optional.isEmpty()) {
			throw new DataNotFoundException("Course is not available with the given Id");
		}else 
		{
			
			return optional.get();
		}
	}

	@Override
	public List<Course> viewAllCourses() throws DataNotFoundException {
		
		List<Course> list=courserepo.findAll();
		if(list.isEmpty()) {
			throw new DataNotFoundException("No courses in the database");
		}
		else {
			return list;
		}
	}

}
