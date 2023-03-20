package com.university.courseSelection.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dao.AdmissionDao;

@Service
public interface IAdmissionService {

	ResponseEntity addAdmission(AdmissionDao admissionDao);

	ResponseEntity updateAdmission(int id, AdmissionDao admissionDao);

	ResponseEntity cancelAdmission(int id);

	public ResponseEntity showAllAdmission();

	public ResponseEntity showAdmissionById(int id);

}
