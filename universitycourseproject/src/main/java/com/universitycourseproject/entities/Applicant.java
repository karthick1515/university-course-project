package com.universitycourseproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Applicant {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int applicantId;
        private String password;
        private String applicantName;
        private String mobileNumber;
        private String gender;
        private String address;
        
}
