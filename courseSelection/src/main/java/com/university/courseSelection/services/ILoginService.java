package com.university.courseSelection.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.entity.AdmissionCommiteeMemberEntity;
import com.university.courseSelection.entity.ApplicantEntity;
import com.university.courseSelection.entity.UniversityStaffMemberEntity;

@Service
public interface ILoginService {

	ApplicantEntity loginAsApplicant(String userName, String password);

	AdmissionCommiteeMemberEntity loginAsAdmissionCommiteeMember(String userName, String password);

	UniversityStaffMemberEntity loginAsuniversityStaffMember(String userName, String password);

}
