package com.university.courseSelection.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.Exception.AlreadyExistsException;
import com.university.courseSelection.Exception.DoesnotExistsException;
import com.university.courseSelection.Exception.UnhandledException;
import com.university.courseSelection.dao.AdmissionCommiteeMemberDao;
import com.university.courseSelection.entiy.AdmissionCommiteeMemberEntiy;
import com.university.courseSelection.repository.IAdmissionCommiteeMemberRepositoryRepository;

@Service
public class AdmissionCommiteeMemberService implements IAdmissionCommiteeMemberService {

	@Autowired
	IAdmissionCommiteeMemberRepositoryRepository iAdmissionCommiteeMemberRepositoryRepository;
	
	@Override
	public ResponseEntity addCommiteeMemeber(AdmissionCommiteeMemberDao admissionCommiteeMemberDao) throws UnhandledException {
		try {
			if(iAdmissionCommiteeMemberRepositoryRepository.findByEmail(admissionCommiteeMemberDao.getEmail()).isEmpty()) {
				AdmissionCommiteeMemberEntiy admissionCommiteeMemberEntiy = new AdmissionCommiteeMemberEntiy();
				admissionCommiteeMemberEntiy.setAdminContact(admissionCommiteeMemberDao.getAdminContact());
				admissionCommiteeMemberEntiy.setEmail(admissionCommiteeMemberDao.getEmail());
				admissionCommiteeMemberEntiy.setName(admissionCommiteeMemberDao.getName());
				admissionCommiteeMemberEntiy.setPassword(admissionCommiteeMemberDao.getPassword());
	
				admissionCommiteeMemberEntiy = iAdmissionCommiteeMemberRepositoryRepository.save(admissionCommiteeMemberEntiy);
				return new ResponseEntity<>(admissionCommiteeMemberEntiy,HttpStatus.OK);
			}
			else {
				throw new AlreadyExistsException("CommiteeMember already exists with the email: "+admissionCommiteeMemberDao.getEmail());
			}
		}
		catch(Exception e) {
			throw new UnhandledException("Something went wrong");
		}
	}

	@Override
	public ResponseEntity updateCommiteeMember(int id, AdmissionCommiteeMemberDao admissionCommiteeMemberDao) {
		
		if(iAdmissionCommiteeMemberRepositoryRepository.findById(id).isPresent()) {
			AdmissionCommiteeMemberEntiy admissionCommiteeMemberEntiy = new AdmissionCommiteeMemberEntiy();
			admissionCommiteeMemberEntiy.setAdminContact(admissionCommiteeMemberDao.getAdminContact());
			admissionCommiteeMemberEntiy.setEmail(admissionCommiteeMemberDao.getEmail());
			admissionCommiteeMemberEntiy.setName(admissionCommiteeMemberDao.getName());
			admissionCommiteeMemberEntiy.setPassword(admissionCommiteeMemberDao.getPassword());

			admissionCommiteeMemberEntiy.setAdminId(id);
			admissionCommiteeMemberEntiy = iAdmissionCommiteeMemberRepositoryRepository.save(admissionCommiteeMemberEntiy);
			return new ResponseEntity<>(admissionCommiteeMemberEntiy,HttpStatus.OK);
		}
		else {
			throw new DoesnotExistsException("Commitee Member doesnot exists with id: "+id);
		}
		
	}

	@Override
	public ResponseEntity viewCommiteeMember(int id) {
		if(iAdmissionCommiteeMemberRepositoryRepository.findById(id).isPresent()) {
			AdmissionCommiteeMemberEntiy admissionCommiteeMemberEntiy = iAdmissionCommiteeMemberRepositoryRepository.findById(id).get();
			return new ResponseEntity<>(admissionCommiteeMemberEntiy,HttpStatus.OK);
		}
		else {
			throw new DoesnotExistsException("Commitee Member doesnot exists with id: "+id);
		}
	}

	@Override
	public ResponseEntity removeCommiteeMember(int id) {
		if(iAdmissionCommiteeMemberRepositoryRepository.findById(id).isPresent()) {
			AdmissionCommiteeMemberEntiy admissionCommiteeMemberEntiy = iAdmissionCommiteeMemberRepositoryRepository.findById(id).get();
			iAdmissionCommiteeMemberRepositoryRepository.deleteById(id);
			return new ResponseEntity<>(admissionCommiteeMemberEntiy,HttpStatus.OK);
		}
		else {
			throw new DoesnotExistsException("Commitee Member doesnot exists with id: "+id);
		}
	}


}
