package com.universitycourseproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.universitycourseproject.entities.Admission;
import com.universitycourseproject.entities.Applicant;
import com.universitycourseproject.entities.Course;
import com.universitycourseproject.exception.AlreadyExistException;
import com.universitycourseproject.exception.DataNotFoundException;
import com.universitycourseproject.repository.AdmissionRepo;
import com.universitycourseproject.repository.ApplicantRepo;
import com.universitycourseproject.repository.CourseRepo;

public class AdmissionServiceImpl implements AdmissionService{

	@Autowired
	private AdmissionRepo admissionrepo;
	@Autowired
	private CourseRepo courserepo;
	@Autowired
	private ApplicantRepo applicantrepo;
	@Override
	public Admission addAdmission(Admission admission,int courseId,int applicantId) throws AlreadyExistException,DataNotFoundException {
		Optional<Course> course=courserepo.findById(courseId);
		Optional<Applicant> applicant=applicantrepo.findById(applicantId);
		if(course.isPresent()) {
		admission.setCourse(course.get());
		if(applicant.isPresent()) {
			admission.setApplicant(applicant.get());
		}
		else {
			throw new DataNotFoundException("The applicant is not found with this Id"+applicantId);
		}
		}
		else {
			throw new DataNotFoundException("The course is not found with this Id"+courseId);
		}
		
		Admission addedadmission=admissionrepo.save(admission);
		return addedadmission;
	}

	@Override
	public Admission removeAdmission(int admissionId) throws DataNotFoundException {
		Optional<Admission> optional=admissionrepo.findById(admissionId);
		if(optional.isEmpty() ) {
			throw new DataNotFoundException("There is no admission with this Id");
		}
		else {
			admissionrepo.deleteById(admissionId);
			return optional.get();
		}
		
	}

	@Override
	public Admission updateAdmission(Admission admission) throws DataNotFoundException {
		Optional<Admission> optional=admissionrepo.findById(admission.getAdmissionId());
		if(optional.isEmpty()) {
			throw new DataNotFoundException("Admission is not available with the given Id");
		}else 
		{
			Admission updatedadmission=admissionrepo.save(admission);
			return updatedadmission;
		}
	}

	@Override
	public Admission viewAdmission(int admissionid) throws DataNotFoundException {
		Optional<Admission> optional=admissionrepo.findById(admissionid);
		if(optional.isEmpty()) {
			throw new DataNotFoundException("Admission is not available with the given Id");
		}else 
		{
			
			return optional.get();
		}
	}

	@Override
	public List<Admission> viewAllAdmissions() throws DataNotFoundException {
		List<Admission> list=admissionrepo.findAll();
		if(list.isEmpty()) {
			throw new DataNotFoundException("No Admissions in the database");
		}
		else {
			return list;
		}
		
	}

}
