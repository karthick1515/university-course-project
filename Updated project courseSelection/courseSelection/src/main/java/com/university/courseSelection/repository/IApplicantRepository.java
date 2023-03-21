package com.university.courseSelection.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.courseSelection.entiy.ApplicantEntity;

@Repository
public interface IApplicantRepository extends JpaRepository<ApplicantEntity, Integer> {
	Optional<ApplicantEntity> findByEmailId(String emailId);
}
