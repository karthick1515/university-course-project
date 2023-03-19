package com.universitycourseproject.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name="Applicant")
public class Applicant {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int applicantId;
        private String emailId;
        private String password;
        private String applicantName;
        private String mobileNumber;
        private String gender;
        private String address;
        
        private String qualification;
        
        private double academicPercentage;
        
        private String school_Collage;
        
        private int passedOutYear;
        
        private LocalDate dateOfBirth;
        
        private int academicgap;
        
}
