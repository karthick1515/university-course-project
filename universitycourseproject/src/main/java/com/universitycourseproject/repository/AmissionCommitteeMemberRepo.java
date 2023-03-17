package com.universitycourseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universitycourseproject.entities.AdmissionCommitteeMember;
@Repository
public interface AmissionCommitteeMemberRepo extends JpaRepository<AdmissionCommitteeMember, Integer> {
	
}

