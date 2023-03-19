package com.universitycourseproject.service;

import java.util.List;

import com.universitycourseproject.entities.Applicant;
import com.universitycourseproject.exception.AlreadyExistException;
import com.universitycourseproject.exception.DataNotFoundException;

public interface ApplicantService {
	public Applicant addApplicant(Applicant applicant)throws AlreadyExistException;
	public Applicant removeApplicant(int applicantId) throws DataNotFoundException;
	public Applicant updateApplicant(Applicant applicant) throws DataNotFoundException;
	public Applicant viewApplicant(int applicantid) throws DataNotFoundException;
	public List<Applicant> viewAllApplicants()throws DataNotFoundException;
}
