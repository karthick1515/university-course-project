package com.university.courseSelection.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.AdmissionStatus;
import com.university.courseSelection.dto.Applicant;
import com.university.courseSelection.entity.ApplicantEntity;

@Service
public interface IApplicantService {

	ApplicantEntity addApplicant(Applicant applicantDao);

	ApplicantEntity updateApplicant(int id, Applicant applicantDao);

	ApplicantEntity deleteApplicant(int id);

	ApplicantEntity viewApplicant(int id);

	

	List<ApplicantEntity> viewAllApplicant();

	List<Integer> getApplicantCourse(int id);

}
