package com.university.courseSelection.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.courseSelection.entiy.AdmissionEntity;

@Repository
public interface IAdmissionRepository extends JpaRepository<AdmissionEntity, Integer> {
	List<AdmissionEntity> findByAdmissionDate(LocalDate date);
//	List<AdmissionEntity> findByAdmissionCourseId(int id);
	
}
