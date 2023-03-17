package com.universitycourseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityStaffMember extends JpaRepository<UniversityStaffMember, Integer> {
}