package com.university.courseSelection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.courseSelection.entity.CoursesEntity;

@Repository
public interface ICourseRepository extends JpaRepository<CoursesEntity, Integer>{

}
