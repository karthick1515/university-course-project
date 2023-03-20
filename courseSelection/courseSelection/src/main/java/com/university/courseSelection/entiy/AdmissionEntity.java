package com.university.courseSelection.entiy;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.university.courseSelection.dao.AdmissionStatus;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="admission")
@Data
@ToString
public class AdmissionEntity {
	@Id
	@SequenceGenerator(name="ADMISSION_SEQ_GEN", sequenceName="ADMISSION_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADMISSION_SEQ_GEN")
	private int admissionId;
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
	private CoursesEntity courseId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicantId", referencedColumnName = "applicantId")
	private ApplicantEntity applicantId;
	private LocalDate admissionDate;
	private AdmissionStatus admissionStatus;
	private LocalDate appliedDate;	
}
