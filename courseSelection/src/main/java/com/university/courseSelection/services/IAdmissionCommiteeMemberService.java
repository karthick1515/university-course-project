package com.university.courseSelection.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.AdmissionCommiteeMember;
import com.university.courseSelection.entity.AdmissionCommiteeMemberEntity;

@Service
public interface IAdmissionCommiteeMemberService {

	AdmissionCommiteeMemberEntity addCommiteeMemeber(AdmissionCommiteeMember admissionCommiteeMemberDao);

	AdmissionCommiteeMemberEntity updateCommiteeMember(int id, AdmissionCommiteeMember admissionCommiteeMemberDao);

	AdmissionCommiteeMemberEntity viewCommiteeMember(int id);

	AdmissionCommiteeMemberEntity removeCommiteeMember(int id);

	

	List<AdmissionCommiteeMemberEntity> viewAllCommiteeMember();
	
}
