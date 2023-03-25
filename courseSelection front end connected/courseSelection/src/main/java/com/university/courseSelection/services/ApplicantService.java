package com.university.courseSelection.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.AdmissionStatus;
import com.university.courseSelection.dto.Applicant;
import com.university.courseSelection.entiy.AdmissionEntity;
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
	public ApplicantEntity addApplicant(Applicant applicantDao) {
		try {
			if(iApplicantRepository.findByEmailId(applicantDao.getEmailId()).isEmpty()) {
				ApplicantEntity applicantEntity = new ApplicantEntity();
				applicantEntity.setAcademicgap(applicantDao.getAcademicgap());
				applicantEntity.setAddress(applicantDao.getAddress());
				applicantEntity.setApplicantDegree(applicantDao.getApplicantDegree());
				applicantEntity.setApplicantGraduationPercentage(applicantDao.getApplicantGraduationPercentage());
				applicantEntity.setApplicantName(applicantDao.getApplicantName());
				applicantEntity.setDateOfBirth(applicantDao.getDateOfBirth());
				applicantEntity.setEmailId(applicantDao.getEmailId());
				applicantEntity.setPassword(applicantDao.getPassword());
				applicantEntity.setGender(applicantDao.getGender());
				applicantEntity.setMobileNumber(applicantDao.getMobileNumber());
				applicantEntity.setPassOutYear(applicantDao.getPassOutYear());
				applicantEntity.setSchool(applicantDao.getSchool());
				applicantEntity = iApplicantRepository.save(applicantEntity);
				return applicantEntity;
			}
			else {
				throw new AlreadyExistsException("Applicant with same Email already exists: "+ applicantDao.getEmailId());
			}
		}
		catch(Exception e) {
			throw new UnhandledException("Something went wrong");
		}
	}

	@Override
	public ApplicantEntity updateApplicant(int id, Applicant applicantDao) {
		if(iApplicantRepository.findById(id).isPresent()) {
			ApplicantEntity applicantEntity = new ApplicantEntity();
			applicantEntity.setApplicantId(id);
			applicantEntity = iApplicantRepository.save(null);
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
			iApplicantRepository.deleteById(null);
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
	public List<ApplicantEntity> viewAllApplicant() {
		List<ApplicantEntity> applicantEntityList = iApplicantRepository.findAll();
		return applicantEntityList;	
	}

	@Override
	public List<Integer> getApplicantCourse(int id) {

		List<AdmissionEntity> admissionEntityList = iAdmissionRepository.findAll();
		List<Integer> courseList = new ArrayList<>();
		for(AdmissionEntity admissionEntity: admissionEntityList) {
			if(admissionEntity.getApplicantId().getApplicantId()==id) {
				courseList.add(admissionEntity.getCourseId().getCourseId());
			}
		}
		return courseList;	
	}
	
	
}
