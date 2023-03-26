package com.university.courseSelection.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.university.courseSelection.dto.AdmissionCommiteeMember;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "courses")
@Data
@ToString
public class CoursesEntity {
	@Id
	@SequenceGenerator(name="COURSE_SEQ_GEN", sequenceName="COURSE_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COURSE_SEQ_GEN")
	private int courseId;
	private String courseName;
	private String courseDuration;
	private LocalDate courseStartDate;
	private LocalDate courseEndDate;
	private double courseFee;
}
