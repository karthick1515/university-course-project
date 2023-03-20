package com.university.courseSelection.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.Exception.DoesnotExistsException;
import com.university.courseSelection.Exception.UnhandledException;
import com.university.courseSelection.dao.CourseDao;
import com.university.courseSelection.entiy.CoursesEntity;
import com.university.courseSelection.repository.ICourseRepository;

@Service
public class CoursesService implements ICoursesService {

	@Autowired
	private ICourseRepository iCourseRepository;
	
	@Override
	public ResponseEntity addCourse(CourseDao courseDao) {
		try {
			CoursesEntity coursesEntity = new CoursesEntity();
			coursesEntity.setCourseName(courseDao.getCourseName());
			coursesEntity.setCourseDuration(courseDao.getCourseDuration());
			coursesEntity.setCourseEndDate(courseDao.getCourseEndDate());
			coursesEntity.setCourseStartDate(courseDao.getCourseStartDate());
			coursesEntity.setCourseFee(courseDao.getCourseFee());
			coursesEntity = iCourseRepository.save(coursesEntity);
			return new ResponseEntity<>(coursesEntity,HttpStatus.OK);
		}
		catch(Exception e) {
			throw new UnhandledException("Something went wrong");
		}
	}

	@Override
	public ResponseEntity updateCourse(int id, CourseDao courseDao) {
		if(iCourseRepository.findById(id).isPresent()) {
			CoursesEntity coursesEntity = new CoursesEntity();
			coursesEntity.setCourseName(courseDao.getCourseName());
			coursesEntity.setCourseDuration(courseDao.getCourseDuration());
			coursesEntity.setCourseEndDate(courseDao.getCourseEndDate());
			coursesEntity.setCourseStartDate(courseDao.getCourseStartDate());
			coursesEntity.setCourseFee(courseDao.getCourseFee());
			coursesEntity.setCourseId(id);
			coursesEntity = iCourseRepository.save(coursesEntity);
			return new ResponseEntity<>(coursesEntity,HttpStatus.OK);
		}
		else {
			throw new DoesnotExistsException("Couse doesnt exists with this id: "+id);
		}
	}

	@Override
	public ResponseEntity removeCourse(int id) {
		if(iCourseRepository.findById(id).isPresent()) {
			CoursesEntity coursesEntity = iCourseRepository.findById(id).get(); 
			iCourseRepository.deleteById(id);
			return new ResponseEntity<>(coursesEntity,HttpStatus.OK);
		}
		else {
			throw new DoesnotExistsException("Couse doesnt exists with this id: "+id);
		}
	}

	@Override
	public ResponseEntity viewCourse(int id) {
		if(iCourseRepository.findById(id).isPresent()) {
			CoursesEntity coursesEntity = iCourseRepository.findById(id).get(); 
			return new ResponseEntity<>(coursesEntity,HttpStatus.OK);
		}
		else {
			throw new DoesnotExistsException("Couse doesnt exists with this id: "+id);
		}
	}

	@Override
	public ResponseEntity viewAllCourses() {
		return new ResponseEntity<>(iCourseRepository.findAll(),HttpStatus.OK);
	}

}
