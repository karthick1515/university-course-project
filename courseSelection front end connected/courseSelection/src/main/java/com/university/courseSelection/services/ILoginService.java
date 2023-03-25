package com.university.courseSelection.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.entiy.AdmissionCommiteeMemberEntiy;
import com.university.courseSelection.entiy.ApplicantEntity;
import com.university.courseSelection.entiy.UniversityStaffMemberEntity;

@Service
public interface ILoginService {

	ApplicantEntity loginAsApplicant(String userName, String password);

	AdmissionCommiteeMemberEntiy loginAsAdmissionCommiteeMember(String userName, String password);

	UniversityStaffMemberEntity loginAsuniversityStaffMember(String userName, String password);

}
