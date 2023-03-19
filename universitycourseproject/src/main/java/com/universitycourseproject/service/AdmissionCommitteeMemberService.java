package com.universitycourseproject.service;

import java.util.List;

import com.universitycourseproject.entities.AdmissionCommitteeMember;
import com.universitycourseproject.exception.AlreadyExistException;
import com.universitycourseproject.exception.DataNotFoundException;

public interface AdmissionCommitteeMemberService {

	public AdmissionCommitteeMember addAdmissionCommitteeMember(AdmissionCommitteeMember admissionCommitteeMember)throws AlreadyExistException;
	public AdmissionCommitteeMember removeAdmissionCommitteeMember(int adminId) throws DataNotFoundException;
	public AdmissionCommitteeMember updateAdmissionCommitteeMember(AdmissionCommitteeMember admissionCommitteeMember) throws DataNotFoundException;
	public AdmissionCommitteeMember viewAdmissionCommitteeMember(int adminId) throws DataNotFoundException;
	public List<AdmissionCommitteeMember> viewAllAdmissionCommitteeMembers()throws DataNotFoundException;
}