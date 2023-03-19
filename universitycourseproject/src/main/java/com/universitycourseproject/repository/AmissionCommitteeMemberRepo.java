package com.universitycourseproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universitycourseproject.entities.AdmissionCommitteeMember;
import com.universitycourseproject.entities.UniversityStaffMember;
@Repository
public interface AmissionCommitteeMemberRepo extends JpaRepository<AdmissionCommitteeMember, Integer> {

	Optional<AdmissionCommitteeMember> findByEmailId(String emailId);

	
	
}