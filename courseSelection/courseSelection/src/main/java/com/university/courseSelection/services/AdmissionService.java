package com.university.courseSelection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.Exception.DoesnotExistsException;
import com.university.courseSelection.Exception.UnhandledException;
import com.university.courseSelection.dao.AdmissionDao;
import com.university.courseSelection.entiy.AdmissionEntity;
import com.university.courseSelection.repository.IAdmissionRepository;
import com.university.courseSelection.repository.IApplicantRepository;
import com.university.courseSelection.repository.ICourseRepository;

@Service
public class AdmissionService implements IAdmissionService{

	@Autowired
	private IAdmissionRepository iAdmissionRepository;
	
	@Autowired
	private ICourseRepository iCourseRepository;
	
	@Autowired
	private IApplicantRepository iApplicantRepository;
	
	@Override
	public ResponseEntity addAdmission(AdmissionDao admissionDao) {
		try {
			if(iCourseRepository.findById(admissionDao.getCourseId()).isPresent()){
				if(iApplicantRepository.findById(admissionDao.getApplicationId()).isPresent()) {
					AdmissionEntity admissionEntity = new AdmissionEntity();
					admissionEntity.setAdmissionDate(admissionDao.getAdmissionDate());
					admissionEntity.setAdmissionStatus(admissionDao.getAdmissionStatus());
					admissionEntity.setApplicantId(iApplicantRepository.findById(admissionDao.getApplicationId()).get());
					admissionEntity.setCourseId(iCourseRepository.findById(admissionDao.getCourseId()).get());
					admissionEntity.setAppliedDate(admissionDao.getAppliedDate());
					iAdmissionRepository.save(admissionEntity);
					return new ResponseEntity<>(admissionEntity,HttpStatus.OK);
				}
				else {
					throw new DoesnotExistsException("Applicant doesn't esists with id: "+admissionDao.getApplicationId());
				}
			}
			else {
				throw new DoesnotExistsException("Couse Id Doesn't exist with id: "+admissionDao.getCourseId());
			}
		}
		catch(Exception e) {
			throw new UnhandledException("Something went wrong");
		}
	}

	@Override
	public ResponseEntity updateAdmission(int id, AdmissionDao admissionDao) {
		if(iAdmissionRepository.findById(id).isPresent()) {
			if(iCourseRepository.findById(admissionDao.getCourseId()).isPresent()){
				if(iApplicantRepository.findById(admissionDao.getApplicationId()).isPresent()) {
					AdmissionEntity admissionEntity = new AdmissionEntity();
					admissionEntity.setAdmissionDate(admissionDao.getAdmissionDate());
					admissionEntity.setAdmissionStatus(admissionDao.getAdmissionStatus());
					admissionEntity.setApplicantId(iApplicantRepository.findById(admissionDao.getApplicationId()).get());
					admissionEntity.setCourseId(iCourseRepository.findById(admissionDao.getCourseId()).get());
					admissionEntity.setAdmissionId(id);
					admissionEntity.setAppliedDate(admissionDao.getAdmissionDate());
					admissionEntity = iAdmissionRepository.save(admissionEntity);
					return new ResponseEntity<>(admissionEntity,HttpStatus.OK);
				}
				else {
					throw new DoesnotExistsException("Applicant doesn't exists with id: "+admissionDao.getApplicationId());
				}
			}
			else {
				throw new DoesnotExistsException("Couse Id Doesn't exist with id: "+admissionDao.getCourseId());
			}
		
		}
		else {
			throw new DoesnotExistsException("Admission doesnt esists: "+id);
		}
	}

	@Override
	public ResponseEntity cancelAdmission(int id) {

		if(iAdmissionRepository.findById(id).isPresent()) {
			AdmissionEntity admissionEntity = iAdmissionRepository.findById(id).get();
			iAdmissionRepository.deleteById(id);
			return new ResponseEntity<>(admissionEntity,HttpStatus.OK);	
		}
		else {
			throw new DoesnotExistsException("Admission doesnt esists: "+id);
		}
	}

	@Override
	public ResponseEntity showAllAdmission() {
		List<AdmissionEntity> admissionEntityList = iAdmissionRepository.findAll();
		if(admissionEntityList.size()>0) {
			return new ResponseEntity<>(admissionEntityList,HttpStatus.OK);	
		}
		else {
			throw new DoesnotExistsException("Admissions doesn't exists");
		}
	}

	@Override
	public ResponseEntity showAdmissionById(int id) {
		Optional<AdmissionEntity> admissionEntityList = iAdmissionRepository.findById(id);
		if(admissionEntityList.isPresent()) {
			return new ResponseEntity<>(admissionEntityList,HttpStatus.OK);	
		}
		else {
			throw new DoesnotExistsException("Admission doesn't exists with the id:"+id);
		}
	}
	
}
