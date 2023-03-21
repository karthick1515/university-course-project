package com.university.courseSelection.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.courseSelection.entiy.UniversityStaffMemberEntity;

@Repository
public interface IUniversityStaffRepository extends JpaRepository<UniversityStaffMemberEntity, Integer>{
	
	Optional<UniversityStaffMemberEntity> findByEmail(String emailId);

}
