package com.university.courseSelection.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.Exception.AlreadyExistsException;
import com.university.courseSelection.Exception.DoesnotExistsException;
import com.university.courseSelection.Exception.UnhandledException;
import com.university.courseSelection.dao.AdmissionStatus;
import com.university.courseSelection.dao.ApplicantDao;
import com.university.courseSelection.entiy.AdmissionEntity;
import com.university.courseSelection.entiy.ApplicantEntity;
import com.university.courseSelection.repository.IAdmissionRepository;
import com.university.courseSelection.repository.IApplicantRepository;

@Service
public class ApplicantService implements IApplicantService{

	@Autowired
	private IApplicantRepository iApplicantRepository;
	
	@Autowired
	private IAdmissionRepository iAdmissionRepository;
	
	@Override
	public ResponseEntity addApplicant(ApplicantDao applicantDao) {
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
				applicantEntity.setGender(applicantDao.getGender());
				applicantEntity.setMobileNumber(applicantDao.getMobileNumber());
				applicantEntity.setPassOutYear(applicantDao.getPassOutYear());
				applicantEntity.setSchool(applicantDao.getSchool());
				applicantEntity = iApplicantRepository.save(applicantEntity);
				return new ResponseEntity<>(applicantEntity,HttpStatus.OK);
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
	public ResponseEntity updateApplicant(int id, ApplicantDao applicantDao) {
		if(iApplicantRepository.findById(id).isPresent()) {
			ApplicantEntity applicantEntity = new ApplicantEntity();
			applicantEntity.setApplicantId(id);
			applicantEntity = iApplicantRepository.save(applicantEntity);
			return new ResponseEntity<>(applicantEntity,HttpStatus.OK);	
		}
		else {
			throw new DoesnotExistsException("Applicant with id doesnt exists: "+id);
		}
	}

	@Override
	public ResponseEntity deleteApplicant(int id) {
		if(iApplicantRepository.findById(id).isPresent()) {
			ApplicantEntity applicantEntity = iApplicantRepository.findById(id).get();
			iApplicantRepository.deleteById(id);
			return new ResponseEntity<>(applicantEntity,HttpStatus.OK);	
		}
		else {
			throw new DoesnotExistsException("Applicant with id doesnt exists: "+id);
		}
	}

	@Override
	public ResponseEntity viewApplicant(int id) {
		if(iApplicantRepository.findById(id).isPresent()) {
			ApplicantEntity applicantEntity = iApplicantRepository.findById(id).get();
			return new ResponseEntity<>(applicantEntity,HttpStatus.OK);	
		}
		else {
			throw new DoesnotExistsException("Applicant with id doesnt exists: "+id);
		}
	}

	@Override
	public ResponseEntity viewallApplicant() {
		return new ResponseEntity<>(iApplicantRepository.findAll(),HttpStatus.OK);
	}
	
	
}
