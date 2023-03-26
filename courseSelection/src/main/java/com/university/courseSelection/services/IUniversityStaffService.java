package com.university.courseSelection.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.UniversityStaff;
import com.university.courseSelection.entity.UniversityStaffMemberEntity;

@Service
public interface IUniversityStaffService {

	UniversityStaffMemberEntity addStaff(UniversityStaff universityStaffDao);

	UniversityStaffMemberEntity updateStaff(int id, UniversityStaff universityStaffDao);

	UniversityStaffMemberEntity removeStaff(int id);

	UniversityStaffMemberEntity viewStaff(int id);

	List<UniversityStaffMemberEntity> viewAllStaff();

}
