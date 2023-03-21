package com.university.courseSelection.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.Admission;
import com.university.courseSelection.entiy.AdmissionEntity;

@Service
public interface IAdmissionService {

	AdmissionEntity addAdmission(Admission admission);

	AdmissionEntity updateAdmission(int id, Admission admission);

	AdmissionEntity cancelAdmission(int id);

	public List<AdmissionEntity> showAllAdmission();

	public AdmissionEntity showAdmissionById(int id);

}
