package com.university.courseSelection.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dao.UniversityStaffDao;

@Service
public interface IUniversityStaffService {

	ResponseEntity addStaff(UniversityStaffDao universityStaffDao);

	ResponseEntity updateStaff(int id, UniversityStaffDao universityStaffDao);

	ResponseEntity removeStaff(int id);

	ResponseEntity viewStaff(int id);

	ResponseEntity viewAllStaff();

}
