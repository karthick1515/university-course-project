package com.university.courseSelection.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.courseSelection.entity.AdmissionCommiteeMemberEntity;

@Repository
public interface IAdmissionCommiteeMemberRepositoryRepository extends JpaRepository<AdmissionCommiteeMemberEntity,Integer>  {
	
	Optional<AdmissionCommiteeMemberEntity> findByEmail(String emailId);
}
