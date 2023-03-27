package com.university.courseSelection.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.Course;
import com.university.courseSelection.entity.CoursesEntity;
import com.university.courseSelection.exception.DoesnotExistsException;
import com.university.courseSelection.exception.UnhandledException;
import com.university.courseSelection.repository.ICourseRepository;

@Service
public class CoursesService implements ICoursesService {

	@Autowired
	private ICourseRepository iCourseRepository;
	
	@Override
	public CoursesEntity addCourse(Course course) {
		try {
			CoursesEntity coursesEntity = new CoursesEntity();
			coursesEntity.setCourseName(course.getCourseName());
			coursesEntity.setCourseDuration(course.getCourseDuration());
			coursesEntity.setCourseEndDate(course.getCourseEndDate());
			coursesEntity.setCourseStartDate(course.getCourseStartDate());
			coursesEntity.setCourseFee(course.getCourseFee());
			coursesEntity = iCourseRepository.save(coursesEntity);
			return coursesEntity;
		}
		catch(Exception e) {
			throw new UnhandledException("Something went wrong");
		}
	}

	@Override
	public CoursesEntity updateCourse(int id, Course course) {
		if(iCourseRepository.findById(id).isPresent()) {
			CoursesEntity coursesEntity = new CoursesEntity();
			coursesEntity.setCourseName(course.getCourseName());
			coursesEntity.setCourseDuration(course.getCourseDuration());
			coursesEntity.setCourseEndDate(course.getCourseEndDate());
			coursesEntity.setCourseStartDate(course.getCourseStartDate());
			coursesEntity.setCourseFee(course.getCourseFee());
			coursesEntity.setCourseId(id);
			coursesEntity = iCourseRepository.save(coursesEntity);
			return coursesEntity;
		}
		else {
			throw new DoesnotExistsException("Couse doesnt exists with this id: "+id);
		}
	}

	@Override
	public CoursesEntity removeCourse(int id) {
		if(iCourseRepository.findById(id).isPresent()) {
			CoursesEntity coursesEntity = iCourseRepository.findById(id).get(); 
			iCourseRepository.deleteById(id);
			return coursesEntity;
		}
		else {
			throw new DoesnotExistsException("Couse doesnt exists with this id: "+id);
		}
	}

	@Override
	public CoursesEntity viewCourse(int id) {
		if(iCourseRepository.findById(id).isPresent()) {
			CoursesEntity coursesEntity = iCourseRepository.findById(id).get(); 
			return coursesEntity;
		}
		else {
			throw new DoesnotExistsException("Couse doesnt exists with this id: "+id);
		}
	}

	@Override
	public List<CoursesEntity> viewAllCourses() {
		return iCourseRepository.findAll();
	}

}
