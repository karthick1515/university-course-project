package com.university.courseSelection.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.UniversityStaff;
import com.university.courseSelection.entiy.UniversityStaffMemberEntity;

@Service
public interface IUniversityStaffService {

	UniversityStaffMemberEntity addStaff(UniversityStaff universityStaff);

	UniversityStaffMemberEntity updateStaff(int id, UniversityStaff universityStaff);

	UniversityStaffMemberEntity removeStaff(int id);

	UniversityStaffMemberEntity viewStaff(int id);

	List<UniversityStaffMemberEntity> viewAllStaff();

}
