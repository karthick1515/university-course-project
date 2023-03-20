package com.university.courseSelection.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dao.AdmissionStatus;
import com.university.courseSelection.dao.ApplicantDao;

@Service
public interface IApplicantService {

	ResponseEntity addApplicant(ApplicantDao applicantDao);

	ResponseEntity updateApplicant(int id, ApplicantDao applicantDao);

	ResponseEntity deleteApplicant(int id);

	ResponseEntity viewApplicant(int id);

	ResponseEntity viewallApplicant() ;

}
