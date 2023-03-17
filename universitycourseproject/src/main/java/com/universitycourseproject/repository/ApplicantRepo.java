package com.universitycourseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universitycourseproject.entities.Applicant;

@Repository
public interface ApplicantRepo extends JpaRepository<Applicant, Integer> {
}

