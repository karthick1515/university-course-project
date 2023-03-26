package com.university.courseSelection.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.courseSelection.entity.AdmissionEntity;
import com.university.courseSelection.entity.CoursesEntity;

@Repository
public interface IAdmissionRepository extends JpaRepository<AdmissionEntity, Integer> {
	List<AdmissionEntity> findByAdmissionDate(LocalDate date);

	 Optional<AdmissionEntity> findByApplicantId(int id);

	
}
