package com.university.courseSelection.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.Course;
import com.university.courseSelection.entiy.CoursesEntity;
import com.university.courseSelection.exception.DoesnotExistsException;
import com.university.courseSelection.exception.UnhandledException;
import com.university.courseSelection.repository.ICourseRepository;

@Service
public class CoursesService implements ICoursesService {

	@Autowired
	private ICourseRepository iCourseRepository;
	
	@Override
	public CoursesEntity addCourse(Course courseDao) {
		try {
			CoursesEntity coursesEntity = new CoursesEntity();
			coursesEntity.setCourseName(courseDao.getCourseName());
			coursesEntity.setCourseDuration(courseDao.getCourseDuration());
			coursesEntity.setCourseEndDate(courseDao.getCourseEndDate());
			coursesEntity.setCourseStartDate(courseDao.getCourseStartDate());
			coursesEntity.setCourseFee(courseDao.getCourseFee());
			coursesEntity = iCourseRepository.save(coursesEntity);
			return coursesEntity;
		}
		catch(Exception e) {
			throw new UnhandledException("Something went wrong");
		}
	}

	@Override
	public CoursesEntity updateCourse(int id, Course courseDao) {
		if(iCourseRepository.findById(id).isPresent()) {
			CoursesEntity coursesEntity = new CoursesEntity();
			coursesEntity.setCourseName(courseDao.getCourseName());
			coursesEntity.setCourseDuration(courseDao.getCourseDuration());
			coursesEntity.setCourseEndDate(courseDao.getCourseEndDate());
			coursesEntity.setCourseStartDate(courseDao.getCourseStartDate());
			coursesEntity.setCourseFee(courseDao.getCourseFee());
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
