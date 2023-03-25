package com.university.courseSelection.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.AdmissionCommiteeMember;
import com.university.courseSelection.entiy.AdmissionCommiteeMemberEntiy;

@Service
public interface IAdmissionCommiteeMemberService {

	AdmissionCommiteeMemberEntiy addCommiteeMemeber(AdmissionCommiteeMember admissionCommiteeMemberDao);

	AdmissionCommiteeMemberEntiy updateCommiteeMember(int id, AdmissionCommiteeMember admissionCommiteeMemberDao);

	AdmissionCommiteeMemberEntiy viewCommiteeMember(int id);

	AdmissionCommiteeMemberEntiy removeCommiteeMember(int id);

	

	List<AdmissionCommiteeMemberEntiy> viewAllCommiteeMember();
	
}