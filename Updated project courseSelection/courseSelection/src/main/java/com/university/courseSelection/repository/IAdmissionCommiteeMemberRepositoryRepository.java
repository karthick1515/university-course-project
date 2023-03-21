package com.university.courseSelection.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.courseSelection.entiy.AdmissionCommiteeMemberEntiy;



@Repository
public interface IAdmissionCommiteeMemberRepositoryRepository extends JpaRepository<AdmissionCommiteeMemberEntiy,Integer>  {
	
	Optional<AdmissionCommiteeMemberEntiy> findByEmail(String emailId);
}
