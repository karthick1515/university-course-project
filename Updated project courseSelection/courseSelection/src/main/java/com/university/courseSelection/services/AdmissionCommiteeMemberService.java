package com.university.courseSelection.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.AdmissionCommiteeMember;
import com.university.courseSelection.entiy.AdmissionCommiteeMemberEntiy;
import com.university.courseSelection.exception.AlreadyExistsException;
import com.university.courseSelection.exception.DoesnotExistsException;
import com.university.courseSelection.exception.UnhandledException;
import com.university.courseSelection.repository.IAdmissionCommiteeMemberRepositoryRepository;

@Service
public class AdmissionCommiteeMemberService implements IAdmissionCommiteeMemberService {

	@Autowired
	IAdmissionCommiteeMemberRepositoryRepository iAdmissionCommiteeMemberRepositoryRepository;
	
	@Override
	public AdmissionCommiteeMemberEntiy addCommiteeMemeber(AdmissionCommiteeMember admissionCommiteeMember) throws UnhandledException {
		try {
			if(iAdmissionCommiteeMemberRepositoryRepository.findByEmail(admissionCommiteeMember.getEmail()).isEmpty()) {
				AdmissionCommiteeMemberEntiy admissionCommiteeMemberEntiy = new AdmissionCommiteeMemberEntiy();
				admissionCommiteeMemberEntiy.setAdminContact(admissionCommiteeMember.getAdminContact());
				admissionCommiteeMemberEntiy.setEmail(admissionCommiteeMember.getEmail());
				admissionCommiteeMemberEntiy.setName(admissionCommiteeMember.getName());
				admissionCommiteeMemberEntiy.setPassword(admissionCommiteeMember.getPassword());
	
				admissionCommiteeMemberEntiy = iAdmissionCommiteeMemberRepositoryRepository.save(admissionCommiteeMemberEntiy);
				return admissionCommiteeMemberEntiy;
			}
			else {
				throw new AlreadyExistsException("CommiteeMember already exists with the email: "+admissionCommiteeMember.getEmail());
			}
		}
		catch(Exception e) {
			throw new UnhandledException("Something went wrong");
		}
	}

	@Override
	public AdmissionCommiteeMemberEntiy updateCommiteeMember(int id, AdmissionCommiteeMember admissionCommiteeMember) {
		
		if(iAdmissionCommiteeMemberRepositoryRepository.findById(id).isPresent()) {
			AdmissionCommiteeMemberEntiy admissionCommiteeMemberEntiy = new AdmissionCommiteeMemberEntiy();
			admissionCommiteeMemberEntiy.setAdminContact(admissionCommiteeMember.getAdminContact());
			admissionCommiteeMemberEntiy.setEmail(admissionCommiteeMember.getEmail());
			admissionCommiteeMemberEntiy.setName(admissionCommiteeMember.getName());
			admissionCommiteeMemberEntiy.setPassword(admissionCommiteeMember.getPassword());

			admissionCommiteeMemberEntiy.setAdminId(id);
			admissionCommiteeMemberEntiy = iAdmissionCommiteeMemberRepositoryRepository.save(admissionCommiteeMemberEntiy);
			return admissionCommiteeMemberEntiy;
		}
		else {
			throw new DoesnotExistsException("Commitee Member doesnot exists with id: "+id);
		}
		
	}

	@Override
	public AdmissionCommiteeMemberEntiy viewCommiteeMember(int id) {
		if(iAdmissionCommiteeMemberRepositoryRepository.findById(id).isPresent()) {
			AdmissionCommiteeMemberEntiy admissionCommiteeMemberEntiy = iAdmissionCommiteeMemberRepositoryRepository.findById(id).get();
			return admissionCommiteeMemberEntiy;
		}
		else {
			throw new DoesnotExistsException("Commitee Member doesnot exists with id: "+id);
		}
	}

	@Override
	public AdmissionCommiteeMemberEntiy removeCommiteeMember(int id) {
		if(iAdmissionCommiteeMemberRepositoryRepository.findById(id).isPresent()) {
			AdmissionCommiteeMemberEntiy admissionCommiteeMemberEntiy = iAdmissionCommiteeMemberRepositoryRepository.findById(id).get();
			iAdmissionCommiteeMemberRepositoryRepository.deleteById(id);
			return admissionCommiteeMemberEntiy;
		}
		else {
			throw new DoesnotExistsException("Commitee Member doesnot exists with id: "+id);
		}
	}

	@Override
	public List<AdmissionCommiteeMemberEntiy> viewAllCommiteeMember() {
		
		return  iAdmissionCommiteeMemberRepositoryRepository.findAll();
	}


}
