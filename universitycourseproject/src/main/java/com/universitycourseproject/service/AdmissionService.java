package com.universitycourseproject.service;

import java.util.List;

import com.universitycourseproject.entities.Admission;
import com.universitycourseproject.entities.Course;
import com.universitycourseproject.exception.AlreadyExistException;
import com.universitycourseproject.exception.DataNotFoundException;

public interface AdmissionService {

	public Admission addAdmission(Admission admission)throws AlreadyExistException;
	public Admission removeAdmission(int admissionId) throws DataNotFoundException;
	public Admission updateAdmission(Admission admission) throws DataNotFoundException;
	public Admission viewAdmission(int admissionid) throws DataNotFoundException;
	public List<Course> viewAllAdmissions()throws DataNotFoundException;
}