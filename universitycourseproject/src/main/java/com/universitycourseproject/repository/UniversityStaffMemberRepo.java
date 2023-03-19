package com.universitycourseproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universitycourseproject.entities.Applicant;
import com.universitycourseproject.entities.UniversityStaffMember;

@Repository
public interface UniversityStaffMemberRepo extends JpaRepository<UniversityStaffMember,Integer> {


	Optional<UniversityStaffMember> findByEmail(String email);
}