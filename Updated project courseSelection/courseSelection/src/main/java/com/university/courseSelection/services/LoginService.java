package com.university.courseSelection.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.entiy.AdmissionCommiteeMemberEntiy;
import com.university.courseSelection.entiy.ApplicantEntity;
import com.university.courseSelection.entiy.UniversityStaffMemberEntity;
import com.university.courseSelection.exception.InvalidCredentialsException;
import com.university.courseSelection.repository.IAdmissionCommiteeMemberRepositoryRepository;
import com.university.courseSelection.repository.IApplicantRepository;
import com.university.courseSelection.repository.IUniversityStaffRepository;

@Service
public class LoginService implements ILoginService {

	@Autowired
	private IApplicantRepository iApplicantRepository;
	
	@Autowired
	private IAdmissionCommiteeMemberRepositoryRepository iAdmissionCommiteeMemberRepositoryRepository;
	
	@Autowired
	private IUniversityStaffRepository iUniversityStaffRepository;
	
	@Override
	public ApplicantEntity loginAsApplicant(String userName, String password) {
		if(iApplicantRepository.findByEmailId(userName).isPresent()) {
			ApplicantEntity applicantEntity = iApplicantRepository.findByEmailId(userName).get();
			if(applicantEntity.getPassword().equals(password)) {
				return applicantEntity;
			}
			else {
				throw new InvalidCredentialsException("Credentails not matched");
			}
		}
		else {
			throw new InvalidCredentialsException("Email Id not found");
		}
	}

	@Override
	public AdmissionCommiteeMemberEntiy loginAsAdmissionCommiteeMember(String userName, String password) {
		if(iAdmissionCommiteeMemberRepositoryRepository.findByEmail(userName).isPresent()) {
			AdmissionCommiteeMemberEntiy admissionCommiteeMemberEntiy = iAdmissionCommiteeMemberRepositoryRepository.findByEmail(userName).get();
			if(admissionCommiteeMemberEntiy.getPassword().equals(password)) {
				return admissionCommiteeMemberEntiy;
			}
			else {
				throw new InvalidCredentialsException("Credentails not matched");
			}
		}
		else {
			throw new InvalidCredentialsException("Email Id not found");
		}
	}

	@Override
	public  UniversityStaffMemberEntity loginAsuniversityStaffMember(String userName, String password) {
		if(iUniversityStaffRepository.findByEmail(userName).isPresent()) {
			UniversityStaffMemberEntity universityStaffMemberEntity = iUniversityStaffRepository.findByEmail(userName).get();
			if(universityStaffMemberEntity.getPassword().equals(password)) {
				return universityStaffMemberEntity;
			}
			else {
				throw new InvalidCredentialsException("Credentails not matched");
			}
		}
		else {
			throw new InvalidCredentialsException("Email Id not found");
		}
	}

}
