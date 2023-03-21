package com.university.courseSelection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.Admission;
import com.university.courseSelection.entiy.AdmissionEntity;
import com.university.courseSelection.exception.DoesnotExistsException;
import com.university.courseSelection.exception.UnhandledException;
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
	public AdmissionEntity addAdmission(Admission admission) {
		try {
			if(iCourseRepository.findById(admission.getCourseId()).isPresent()){
				if(iApplicantRepository.findById(admission.getApplicationId()).isPresent()) {
					AdmissionEntity admissionEntity = new AdmissionEntity();
					admissionEntity.setAdmissionDate(admission.getAdmissionDate());
					admissionEntity.setAdmissionStatus(admission.getAdmissionStatus());
					admissionEntity.setApplicantId(iApplicantRepository.findById(admission.getApplicationId()).get());
					admissionEntity.setCourseId(iCourseRepository.findById(admission.getCourseId()).get());
					admissionEntity.setAppliedDate(admission.getAppliedDate());
					iAdmissionRepository.save(admissionEntity);
					return admissionEntity;
				}
				else {
					throw new DoesnotExistsException("Applicant doesn't esists with id: "+admission.getApplicationId());
				}
			}
			else {
				throw new DoesnotExistsException("Couse Id Doesn't exist with id: "+admission.getCourseId());
			}
		}
		catch(Exception e) {
			throw new UnhandledException("Something went wrong");
		}
	}

	@Override
	public AdmissionEntity updateAdmission(int id, Admission admission) {
		if(iAdmissionRepository.findById(id).isPresent()) {
			if(iCourseRepository.findById(admission.getCourseId()).isPresent()){
				if(iApplicantRepository.findById(admission.getApplicationId()).isPresent()) {
					AdmissionEntity admissionEntity = new AdmissionEntity();
					admissionEntity.setAdmissionDate(admission.getAdmissionDate());
					admissionEntity.setAdmissionStatus(admission.getAdmissionStatus());
					admissionEntity.setApplicantId(iApplicantRepository.findById(admission.getApplicationId()).get());
					admissionEntity.setCourseId(iCourseRepository.findById(admission.getCourseId()).get());
					admissionEntity.setAdmissionId(id);
					admissionEntity.setAppliedDate(admission.getAdmissionDate());
					admissionEntity = iAdmissionRepository.save(admissionEntity);
					return admissionEntity;
				}
				else {
					throw new DoesnotExistsException("Applicant doesn't exists with id: "+admission.getApplicationId());
				}
			}
			else {
				throw new DoesnotExistsException("Couse Id Doesn't exist with id: "+admission.getCourseId());
			}
		
		}
		else {
			throw new DoesnotExistsException("Admission doesnt esists: "+id);
		}
	}

	@Override
	public AdmissionEntity cancelAdmission(int id) {

		if(iAdmissionRepository.findById(id).isPresent()) {
			AdmissionEntity admissionEntity = iAdmissionRepository.findById(id).get();
			iAdmissionRepository.deleteById(id);
			return admissionEntity;	
		}
		else {
			throw new DoesnotExistsException("Admission doesnt esists: "+id);
		}
	}

	@Override
	public List<AdmissionEntity> showAllAdmission() {
		List<AdmissionEntity> admissionEntityList = iAdmissionRepository.findAll();
		if(admissionEntityList.size()>0) {
			return admissionEntityList;	
		}
		else {
			throw new DoesnotExistsException("Admissions doesn't exists");
		}
	}

	@Override
	public AdmissionEntity showAdmissionById(int id) {
		Optional<AdmissionEntity> admissionEntityList = iAdmissionRepository.findById(id);
		if(admissionEntityList.isPresent()) {
			return admissionEntityList.get();	
		}
		else {
			throw new DoesnotExistsException("Admission doesn't exists with the id:"+id);
		}
	}
	
}
