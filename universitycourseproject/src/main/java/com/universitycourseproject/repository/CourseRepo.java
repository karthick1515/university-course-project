package com.universitycourseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universitycourseproject.entities.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
}