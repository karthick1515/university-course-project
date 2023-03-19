package com.universitycourseproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.universitycourseproject.entities.Applicant;
import com.universitycourseproject.exception.AlreadyExistException;
import com.universitycourseproject.exception.DataNotFoundException;
import com.universitycourseproject.repository.ApplicantRepo;

public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	private ApplicantRepo applicantrepo;
	@Override
	public Applicant addApplicant(Applicant applicant) throws AlreadyExistException {
		Optional<Applicant> optional1=applicantrepo.findEmailId(applicant.getEmailId());
		Optional<Applicant> optional2=applicantrepo.findById(applicant.getApplicantId());
		if(optional1.isPresent() || optional2.isPresent()) {
			throw new AlreadyExistException("Applicant Already Exist");
		}else 
		{
			Applicant addedapplicant=applicantrepo.save(applicant);
			return addedapplicant;
		}
		
	}

	@Override
	public Applicant removeApplicant(int applicantId) throws DataNotFoundException {
		Optional<Applicant> optional=applicantrepo.findById(applicantId);
		if(optional.isEmpty() ) {
			throw new DataNotFoundException("There is no applicant with this Id");
		}
		else {
			applicantrepo.deleteById(applicantId);
			return optional.get();
		}
	}

	@Override
	public Applicant updateApplicant(Applicant applicant) throws DataNotFoundException {
		
		Optional<Applicant> optional=applicantrepo.findById(applicant.getApplicantId());
		if(optional.isEmpty() ) {
			throw new DataNotFoundException("Can't find applicant enter the valid applicantid to update");
		}
		else {
			Applicant updatedapplicant=applicantrepo.save(applicant);
			return updatedapplicant;
		}
	}

	@Override
	public Applicant viewApplicant(int applicantid) throws DataNotFoundException {
		
		Optional<Applicant> optional=applicantrepo.findById(applicantid);
		if(optional.isEmpty() ) {
			throw new DataNotFoundException("Can't find applicant");
		}
		else {
			
			return optional.get();
		}
	}

	@Override
	public List<Applicant> viewAllApplicants() throws DataNotFoundException {
		
		List<Applicant> list=applicantrepo.findAll();
		if(list.isEmpty()) {
			throw new DataNotFoundException("No applicants in the database");
		}
		else {
			return list;
		}
		
	}

}
