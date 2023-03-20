package com.university.courseSelection.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dao.AdmissionCommiteeMemberDao;

@Service
public interface IAdmissionCommiteeMemberService {

	ResponseEntity addCommiteeMemeber(AdmissionCommiteeMemberDao admissionCommiteeMemberDao);

	ResponseEntity updateCommiteeMember(int id, AdmissionCommiteeMemberDao admissionCommiteeMemberDao);

	ResponseEntity viewCommiteeMember(int id);

	ResponseEntity removeCommiteeMember(int id);
	
	ResponseEntity viewAllCommiteeMember();
  
	
}
