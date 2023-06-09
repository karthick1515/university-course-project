package com.university.courseSelection.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.Admission;
import com.university.courseSelection.entity.AdmissionEntity;
import com.university.courseSelection.entity.CoursesEntity;
import com.university.courseSelection.exception.AlreadyExistsException;
import com.university.courseSelection.exception.DoesnotExistsException;
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
			if(iCourseRepository.findById(admission.getCourseId()).isPresent()){
				if(iApplicantRepository.findById(admission.getApplicantId()).isPresent()) {
					AdmissionEntity admissionEntity = new AdmissionEntity();
					admissionEntity.setAdmissionDate(admission.getAdmissionDate());
					admissionEntity.setAdmissionStatus(admission.getAdmissionStatus());
					admissionEntity.setApplicantId(iApplicantRepository.findById(admission.getApplicantId()).get());
					admissionEntity.setCourseId(iCourseRepository.findById(admission.getCourseId()).get());
					admissionEntity.setAppliedDate(admission.getAppliedDate());
					admissionEntity = iAdmissionRepository.save(admissionEntity);
					return admissionEntity;
				}
				else {
					throw new DoesnotExistsException("Applicant doesn't esists with id: "+admission.getApplicantId());
				}
			}
			else {
				throw new DoesnotExistsException("Couse Id Doesn't exist with id: "+admission.getCourseId());
			}
	}

	@Override
	public AdmissionEntity updateAdmission(int id, Admission admission) {
		if(iAdmissionRepository.findById(id).isPresent()) {
			if(iCourseRepository.findById(admission.getCourseId()).isPresent()){
				if(iApplicantRepository.findById(admission.getApplicantId()).isPresent()) {
					AdmissionEntity admissionEntity = new AdmissionEntity();
					admissionEntity.setAdmissionDate(admission.getAdmissionDate());
					admissionEntity.setAdmissionStatus(admission.getAdmissionStatus());
					admissionEntity.setApplicantId(iApplicantRepository.findById(admission.getApplicantId()).get());
					admissionEntity.setCourseId(iCourseRepository.findById(admission.getCourseId()).get());
					admissionEntity.setAdmissionId(id);
					admissionEntity.setAppliedDate(admission.getAppliedDate());
					admissionEntity = iAdmissionRepository.save(admissionEntity);
					return admissionEntity;
				}
				else {
					throw new DoesnotExistsException("Applicant doesn't esists with id: "+admission.getApplicantId());
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
	public List<AdmissionEntity> showAllAdmissionByCourseId(int courseId) {
		List<AdmissionEntity> admissionEntityList = iAdmissionRepository.findAll();
		if(admissionEntityList.size()>0) {
			return admissionEntityList;	
		}
		else {
			throw new DoesnotExistsException("Admission doesn't exists with the data: "+courseId);
		}
	}
	@Override
	public AdmissionEntity showAdmissionByApplicantId(int id) throws DoesnotExistsException {
		List<AdmissionEntity> admissionEntityList = iAdmissionRepository.findAll();
		AdmissionEntity admissionentity=new AdmissionEntity();
		if(admissionEntityList.size()>0) {
		for(int i=0;i<admissionEntityList.size();i++) {
		if(admissionEntityList.get(i).getApplicantId().getApplicantId()==id) {
			admissionentity=admissionEntityList.get(i);
		
		}
		
		}
		return admissionentity;
	     }
	else {
		return admissionentity;
	}
	
	}
	
	
	

	@Override
	public List<AdmissionEntity> showAllAdmission() {

		List<AdmissionEntity> admissionEntityList = iAdmissionRepository.findAll();
		return admissionEntityList;	
	}

	@Override
	public AdmissionEntity showAdmissionById(int id) {

		if(iAdmissionRepository.findById(id).isPresent()) {
			AdmissionEntity admissionEntity = iAdmissionRepository.findById(id).get();
			return admissionEntity;	
		}
		else {
			throw new DoesnotExistsException("Admission doesnt esists: "+id);
		}
	}

	@Override
	public AdmissionEntity cancelAdmissionForAppplicant(int id) {

		List<AdmissionEntity> admissionEntityList = iAdmissionRepository.findAll();
		for(AdmissionEntity admissionEntity: admissionEntityList) {
			if(admissionEntity.getApplicantId().getApplicantId()==id)
				cancelAdmission(admissionEntity.getAdmissionId());
		}
		return admissionEntityList.get(0);	
	}
	
}
