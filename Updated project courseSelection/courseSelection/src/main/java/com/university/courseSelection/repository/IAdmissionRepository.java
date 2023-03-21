package com.university.courseSelection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.courseSelection.entiy.AdmissionEntity;

@Repository
public interface IAdmissionRepository extends JpaRepository<AdmissionEntity, Integer> {
	

	
}
