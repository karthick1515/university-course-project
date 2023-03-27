package com.university.courseSelection.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.AdmissionCommiteeMember;
import com.university.courseSelection.entity.AdmissionCommiteeMemberEntity;
import com.university.courseSelection.exception.AlreadyExistsException;
import com.university.courseSelection.exception.DoesnotExistsException;
import com.university.courseSelection.exception.UnhandledException;
import com.university.courseSelection.repository.IAdmissionCommiteeMemberRepositoryRepository;

@Service
public class AdmissionCommiteeMemberService implements IAdmissionCommiteeMemberService {

	@Autowired
	IAdmissionCommiteeMemberRepositoryRepository iAdmissionCommiteeMemberRepositoryRepository;
	
	@Override
	public AdmissionCommiteeMemberEntity addCommiteeMemeber(AdmissionCommiteeMember admissionCommiteeMember) throws UnhandledException {
		
			if(iAdmissionCommiteeMemberRepositoryRepository.findByEmail(admissionCommiteeMember.getEmail()).isEmpty()) {
				AdmissionCommiteeMemberEntity admissionCommiteeMemberEntity = new AdmissionCommiteeMemberEntity();
				admissionCommiteeMemberEntity.setAdminContact(admissionCommiteeMember.getAdminContact());
				admissionCommiteeMemberEntity.setEmail(admissionCommiteeMember.getEmail());
				admissionCommiteeMemberEntity.setName(admissionCommiteeMember.getName());
				admissionCommiteeMemberEntity.setPassword(admissionCommiteeMember.getPassword());
	
				admissionCommiteeMemberEntity = iAdmissionCommiteeMemberRepositoryRepository.save(admissionCommiteeMemberEntity);
				return admissionCommiteeMemberEntity;
			}
			else {
				throw new AlreadyExistsException("CommiteeMember already exists with the email: "+admissionCommiteeMember.getEmail());
			}
	}

	@Override
	public AdmissionCommiteeMemberEntity updateCommiteeMember(int id, AdmissionCommiteeMember admissionCommiteeMember) {
		
		if(iAdmissionCommiteeMemberRepositoryRepository.findById(id).isPresent()) {
			AdmissionCommiteeMemberEntity admissionCommiteeMemberEntity = new AdmissionCommiteeMemberEntity();
			admissionCommiteeMemberEntity.setAdminContact(admissionCommiteeMember.getAdminContact());
			admissionCommiteeMemberEntity.setEmail(admissionCommiteeMember.getEmail());
			admissionCommiteeMemberEntity.setName(admissionCommiteeMember.getName());
			admissionCommiteeMemberEntity.setPassword(admissionCommiteeMember.getPassword());

			admissionCommiteeMemberEntity.setAdminId(id);
			admissionCommiteeMemberEntity = iAdmissionCommiteeMemberRepositoryRepository.save(admissionCommiteeMemberEntity);
			return admissionCommiteeMemberEntity;
		}
		else {
			throw new DoesnotExistsException("Commitee Member doesnot exists with id: "+id);
		}
		
	}

	@Override
	public AdmissionCommiteeMemberEntity viewCommiteeMember(int id) {
		if(iAdmissionCommiteeMemberRepositoryRepository.findById(id).isPresent()) {
			AdmissionCommiteeMemberEntity admissionCommiteeMemberEntity = iAdmissionCommiteeMemberRepositoryRepository.findById(id).get();
			return admissionCommiteeMemberEntity;
		}
		else {
			throw new DoesnotExistsException("Commitee Member doesnot exists with id: "+id);
		}
	}

	@Override
	public AdmissionCommiteeMemberEntity removeCommiteeMember(int id) {
		if(iAdmissionCommiteeMemberRepositoryRepository.findById(id).isPresent()) {
			AdmissionCommiteeMemberEntity admissionCommiteeMemberEntity = iAdmissionCommiteeMemberRepositoryRepository.findById(id).get();
			iAdmissionCommiteeMemberRepositoryRepository.deleteById(id);
			return admissionCommiteeMemberEntity;
		}
		else {
			throw new DoesnotExistsException("Commitee Member doesnot exists with id: "+id);
		}
	}

	

	@Override
	public List<AdmissionCommiteeMemberEntity> viewAllCommiteeMember() {
		List<AdmissionCommiteeMemberEntity> admissionCommiteeMemberEntiyList = iAdmissionCommiteeMemberRepositoryRepository.findAll();
		return admissionCommiteeMemberEntiyList;
	}

}
