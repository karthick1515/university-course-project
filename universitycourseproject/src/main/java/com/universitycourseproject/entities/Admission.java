package com.universitycourseproject.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Admission {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int admissionId;
    
	@OneToOne
    private Applicant applicant;
    
    @OneToOne
    private Course course;
    
    private Date applicationDate;
    
    private String Qualification;
    
    private double academicPercentage;
    
    private String school_Collage;
    
    private int passedOutYear;
    
    private Date dateOfBirth;
    
    private int academicgap;
    
    private Status status;
    
    private Date addmissionDate;
}
