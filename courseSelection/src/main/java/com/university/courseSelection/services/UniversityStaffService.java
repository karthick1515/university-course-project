package com.university.courseSelection.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.dto.UniversityStaff;
import com.university.courseSelection.entity.UniversityStaffMemberEntity;
import com.university.courseSelection.exception.AlreadyExistsException;
import com.university.courseSelection.exception.DoesnotExistsException;
import com.university.courseSelection.exception.UnhandledException;
import com.university.courseSelection.repository.IUniversityStaffRepository;

@Service
public class UniversityStaffService implements IUniversityStaffService{
	
	@Autowired
	private IUniversityStaffRepository iUniversityStaffRepository;

	@Override
	public UniversityStaffMemberEntity addStaff(UniversityStaff universityStaff) {
		try {
			if(iUniversityStaffRepository.findByEmail(universityStaff.getEmail()).isEmpty()) {
				UniversityStaffMemberEntity universityStaffMemberEntity = new UniversityStaffMemberEntity();
				universityStaffMemberEntity.setEmail(universityStaff.getEmail());
				universityStaffMemberEntity.setPassword(universityStaff.getPassword());
				universityStaffMemberEntity.setRole(universityStaff.getRole());
				universityStaffMemberEntity = iUniversityStaffRepository.save(universityStaffMemberEntity);
				return  universityStaffMemberEntity;
			}
			else {
				throw new AlreadyExistsException("Staff with this email already exists: "+ universityStaff.getEmail());
			}
		}
		catch(Exception e) {
			throw new UnhandledException("Something went wrong");
		}
	}

	@Override
	public UniversityStaffMemberEntity updateStaff(int id, UniversityStaff universityStaff) {
		if(iUniversityStaffRepository.findById(id).isPresent()) {

			UniversityStaffMemberEntity universityStaffMemberEntity = new UniversityStaffMemberEntity();
			universityStaffMemberEntity.setPassword(universityStaff.getPassword());
			universityStaffMemberEntity.setRole(universityStaff.getRole());
			universityStaffMemberEntity.setStaffId(id);
			universityStaffMemberEntity = iUniversityStaffRepository.save(universityStaffMemberEntity);
			return universityStaffMemberEntity;
		}
		else {
			throw new DoesnotExistsException("Staff doesn't exists with Id: "+id);
		}
	}

	@Override
	public UniversityStaffMemberEntity removeStaff(int id) {
		if(iUniversityStaffRepository.findById(id).isPresent()) {

			UniversityStaffMemberEntity universityStaffMemberEntity = iUniversityStaffRepository.findById(id).get();
			iUniversityStaffRepository.deleteById(id);
			return universityStaffMemberEntity;
		}
		else {
			throw new DoesnotExistsException("Staff doesn't exists with Id: "+id);
		}
	}

	@Override
	public UniversityStaffMemberEntity viewStaff(int id) {
		if(iUniversityStaffRepository.findById(id).isPresent()) {

			UniversityStaffMemberEntity universityStaffMemberEntity = iUniversityStaffRepository.findById(id).get();
			return universityStaffMemberEntity;
		}
		else {
			throw new DoesnotExistsException("Staff doesn't exists with Id: "+id);
		}
	}

	@Override
	public List<UniversityStaffMemberEntity> viewAllStaff() {
		List<UniversityStaffMemberEntity> universityStaffMemberEntityList = iUniversityStaffRepository.findAll();
		return universityStaffMemberEntityList;
	}
	
}
