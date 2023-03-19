package com.universitycourseproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.universitycourseproject.entities.AdmissionCommitteeMember;
import com.universitycourseproject.entities.UniversityStaffMember;
import com.universitycourseproject.exception.AlreadyExistException;
import com.universitycourseproject.exception.DataNotFoundException;
import com.universitycourseproject.repository.AmissionCommitteeMemberRepo;

public class AdmissionCommitteeMemberServiceImpl implements AdmissionCommitteeMemberService {

	@Autowired
	AmissionCommitteeMemberRepo admissionCommitteeMemberRepo ;
	@Override
	public AdmissionCommitteeMember addAdmissionCommitteeMember(AdmissionCommitteeMember admissionCommitteeMember)
			throws AlreadyExistException {
		Optional<AdmissionCommitteeMember> optional1=admissionCommitteeMemberRepo.findByEmailId(admissionCommitteeMember.getEmailId());
		Optional<AdmissionCommitteeMember> optional2=admissionCommitteeMemberRepo.findById(admissionCommitteeMember.getAdminId());
		if(optional1.isPresent() || optional2.isPresent()) {
			throw new AlreadyExistException("AdmissionCommitteeMember Already Exist");
		}else 
		{
			AdmissionCommitteeMember addedAdmissionCommitteeMember=admissionCommitteeMemberRepo.save(admissionCommitteeMember);
			return addedAdmissionCommitteeMember;
		}
		
	}

	@Override
	public AdmissionCommitteeMember removeAdmissionCommitteeMember(int adminId) throws DataNotFoundException {
		Optional<AdmissionCommitteeMember> optional=admissionCommitteeMemberRepo.findById(adminId);
		if(optional.isEmpty() ) {
			throw new DataNotFoundException("There is no AdmissionCommitteeMember with this Id");
		}
		else {
			admissionCommitteeMemberRepo.deleteById(adminId);
			return optional.get();
		}
	}

	@Override
	public AdmissionCommitteeMember updateAdmissionCommitteeMember(AdmissionCommitteeMember admissionCommitteeMember)
			throws DataNotFoundException {
		Optional<AdmissionCommitteeMember> optional=admissionCommitteeMemberRepo.findById(admissionCommitteeMember.getAdminId());
		if(optional.isEmpty()) {
			throw new DataNotFoundException("AdmissionCommitteeMember is not available with the given Id");
		}else 
		{
			AdmissionCommitteeMember updatedadmissionCommitteeMember=admissionCommitteeMemberRepo.save(admissionCommitteeMember);
			return updatedadmissionCommitteeMember;
		}
	}

	@Override
	public AdmissionCommitteeMember viewAdmissionCommitteeMember(int adminId) throws DataNotFoundException {
		Optional<AdmissionCommitteeMember> optional=admissionCommitteeMemberRepo.findById(adminId);
		if(optional.isEmpty()) {
			throw new DataNotFoundException("AdmissionCommitteeMember is not available with the given Id");
		}else 
		{
			
			return optional.get();
		}
	}

	@Override
	public List<AdmissionCommitteeMember> viewAllAdmissionCommitteeMembers() throws DataNotFoundException {
		List<AdmissionCommitteeMember> list=admissionCommitteeMemberRepo.findAll();
		if(list.isEmpty()) {
			throw new DataNotFoundException("No AdmissionCommitteeMember in the database");
		}
		else {
			return list;
		}
	}

}
