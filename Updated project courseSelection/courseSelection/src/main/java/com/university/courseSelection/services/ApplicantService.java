package com.university.courseSelection.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.Applicant;
import com.university.courseSelection.entiy.ApplicantEntity;
import com.university.courseSelection.exception.AlreadyExistsException;
import com.university.courseSelection.exception.DoesnotExistsException;
import com.university.courseSelection.exception.UnhandledException;
import com.university.courseSelection.repository.IAdmissionRepository;
import com.university.courseSelection.repository.IApplicantRepository;

@Service
public class ApplicantService implements IApplicantService{

	@Autowired
	private IApplicantRepository iApplicantRepository;
	
	@Autowired
	private IAdmissionRepository iAdmissionRepository;
	
	@Override
	public ApplicantEntity addApplicant(Applicant applicant) {
		try {
			if(iApplicantRepository.findByEmailId(applicant.getEmailId()).isEmpty()) {
				ApplicantEntity applicantEntity = new ApplicantEntity();
				applicantEntity.setAcademicgap(applicant.getAcademicgap());
				applicantEntity.setAddress(applicant.getAddress());
				applicantEntity.setApplicantDegree(applicant.getApplicantDegree());
				applicantEntity.setApplicantGraduationPercentage(applicant.getApplicantGraduationPercentage());
				applicantEntity.setApplicantName(applicant.getApplicantName());
				applicantEntity.setDateOfBirth(applicant.getDateOfBirth());
				applicantEntity.setEmailId(applicant.getEmailId());
				applicantEntity.setPassword(applicant.getPassword());
				applicantEntity.setGender(applicant.getGender());
				applicantEntity.setMobileNumber(applicant.getMobileNumber());
				applicantEntity.setPassOutYear(applicant.getPassOutYear());
				applicantEntity.setSchool(applicant.getSchool());
				applicantEntity = iApplicantRepository.save(applicantEntity);
				return applicantEntity;
			}
			else {
				throw new AlreadyExistsException("Applicant with same Email already exists: "+ applicant.getEmailId());
			}
		}
		catch(Exception e) {
			throw new UnhandledException("Something went wrong");
		}
	}

	@Override
	public ApplicantEntity updateApplicant(int id, Applicant applicant) {
		if(iApplicantRepository.findById(id).isPresent()) {
			ApplicantEntity applicantEntity = new ApplicantEntity();
			applicantEntity.setApplicantId(id);
			applicantEntity.setAcademicgap(applicant.getAcademicgap());
			applicantEntity.setAddress(applicant.getAddress());
			applicantEntity.setApplicantDegree(applicant.getApplicantDegree());
			applicantEntity.setApplicantGraduationPercentage(applicant.getApplicantGraduationPercentage());
			applicantEntity.setApplicantName(applicant.getApplicantName());
			applicantEntity.setDateOfBirth(applicant.getDateOfBirth());
			applicantEntity.setEmailId(applicant.getEmailId());
			applicantEntity.setPassword(applicant.getPassword());
			applicantEntity.setGender(applicant.getGender());
			applicantEntity.setMobileNumber(applicant.getMobileNumber());
			applicantEntity.setPassOutYear(applicant.getPassOutYear());
			applicantEntity.setSchool(applicant.getSchool());
			applicantEntity = iApplicantRepository.save(applicantEntity);
			return applicantEntity;	
		}
		else {
			throw new DoesnotExistsException("Applicant with id doesnt exists: "+id);
		}
	}

	@Override
	public ApplicantEntity deleteApplicant(int id) {
		if(iApplicantRepository.findById(id).isPresent()) {
			ApplicantEntity applicantEntity = iApplicantRepository.findById(id).get();
			iApplicantRepository.deleteById(id);
			return applicantEntity;	
		}
		else {
			throw new DoesnotExistsException("Applicant with id doesnt exists: "+id);
		}
	}

	@Override
	public ApplicantEntity viewApplicant(int id) {
		if(iApplicantRepository.findById(id).isPresent()) {
			ApplicantEntity applicantEntity = iApplicantRepository.findById(id).get();
			return applicantEntity;	
		}
		else {
			throw new DoesnotExistsException("Applicant with id doesnt exists: "+id);
		}
	}

	@Override
	public List<ApplicantEntity> viewallApplicant() {
		return iApplicantRepository.findAll();
	}
	
	
}
