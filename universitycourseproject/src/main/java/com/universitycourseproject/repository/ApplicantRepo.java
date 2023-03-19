package com.universitycourseproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universitycourseproject.entities.Applicant;

@Repository
public interface ApplicantRepo extends JpaRepository<Applicant, Integer> {

	public Optional<Applicant> findEmailId(String emailId);
}

