package com.university.courseSelection.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.Admission;
import com.university.courseSelection.entity.AdmissionEntity;
import com.university.courseSelection.exception.DoesnotExistsException;

@Service
public interface IAdmissionService {

	AdmissionEntity addAdmission(Admission admissionDao);

	AdmissionEntity updateAdmission(int id, Admission admissionDao);

	AdmissionEntity cancelAdmission(int id);

	List<AdmissionEntity> showAllAdmissionByCourseId(int courseId);

	AdmissionEntity showAdmissionByApplicantId(int id) throws DoesnotExistsException;

	List<AdmissionEntity> showAllAdmission();

	AdmissionEntity showAdmissionById(int id);

	AdmissionEntity cancelAdmissionForAppplicant(int id);

}
