package com.university.courseSelection.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.Applicant;
import com.university.courseSelection.entiy.ApplicantEntity;

@Service
public interface IApplicantService {

	ApplicantEntity addApplicant(Applicant applicant);

	ApplicantEntity updateApplicant(int id, Applicant applicant);

	ApplicantEntity deleteApplicant(int id);

	ApplicantEntity viewApplicant(int id);

	List<ApplicantEntity> viewallApplicant() ;

}
