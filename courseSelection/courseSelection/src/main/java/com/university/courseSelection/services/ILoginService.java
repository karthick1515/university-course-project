package com.university.courseSelection.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ILoginService {

	ResponseEntity loginAsApplicant(String userName, String password);

	ResponseEntity loginAsAdmissionCommiteeMember(String userName, String password);

	ResponseEntity loginAsuniversityStaffMember(String userName, String password);

}
