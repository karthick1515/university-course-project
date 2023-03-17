package com.universitycourseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universitycourseproject.entities.Admission;

@Repository
public interface AdmissionRepo extends JpaRepository<Admission, Integer> {
}
