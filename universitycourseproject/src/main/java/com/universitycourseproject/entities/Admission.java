package com.universitycourseproject.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Admission")
public class Admission {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int admissionId;
    
	
	@OneToOne
	@JoinColumn(name="applicantId")
    private Applicant applicant;
    
    @OneToOne
    @JoinColumn(name="courseId")
    private Course course;
    
    private LocalDate applicationDate;
    
    
    private Status status;
    
    private LocalDate addmissionDate;
}
