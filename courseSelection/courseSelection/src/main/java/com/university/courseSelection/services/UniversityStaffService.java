package com.university.courseSelection.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.courseSelection.Exception.AlreadyExistsException;
import com.university.courseSelection.Exception.DoesnotExistsException;
import com.university.courseSelection.Exception.UnhandledException;
import com.university.courseSelection.dao.UniversityStaffDao;
import com.university.courseSelection.entiy.UniversityStaffMemberEntity;
import com.university.courseSelection.repository.IUniversityStaffRepository;

@Service
public class UniversityStaffService implements IUniversityStaffService{
	
	@Autowired
	private IUniversityStaffRepository iUniversityStaffRepository;

	@Override
	public ResponseEntity addStaff(UniversityStaffDao universityStaffDao) {
		try {
			if(iUniversityStaffRepository.findByEmail(universityStaffDao.getEmail()).isEmpty()) {
				UniversityStaffMemberEntity universityStaffMemberEntity = new UniversityStaffMemberEntity();
				universityStaffMemberEntity.setPassword(universityStaffDao.getPassword());
				universityStaffMemberEntity.setEmail(universityStaffDao.getEmail());
				universityStaffMemberEntity.setRole(universityStaffDao.getRole());
				universityStaffMemberEntity = iUniversityStaffRepository.save(universityStaffMemberEntity);
				return new ResponseEntity<>(universityStaffMemberEntity,HttpStatus.OK);
			}
			else {
				throw new AlreadyExistsException("Staff with this email already exists: "+ universityStaffDao.getEmail());
			}
		}
		catch(Exception e) {
			throw new UnhandledException("Something went wrong");
		}
	}

	@Override
	public ResponseEntity updateStaff(int id, UniversityStaffDao universityStaffDao) {
		if(iUniversityStaffRepository.findById(id).isPresent()) {

			UniversityStaffMemberEntity universityStaffMemberEntity = new UniversityStaffMemberEntity();
			universityStaffMemberEntity.setPassword(universityStaffDao.getPassword());
			universityStaffMemberEntity.setEmail(universityStaffDao.getEmail());
			universityStaffMemberEntity.setRole(universityStaffDao.getRole());
			universityStaffMemberEntity.setStaffId(id);
			universityStaffMemberEntity = iUniversityStaffRepository.save(universityStaffMemberEntity);
			return new ResponseEntity<>(universityStaffMemberEntity,HttpStatus.OK);
		}
		else {
			throw new DoesnotExistsException("Staff doesn't exists with Id: "+id);
		}
	}

	@Override
	public ResponseEntity removeStaff(int id) {
		if(iUniversityStaffRepository.findById(id).isPresent()) {

			UniversityStaffMemberEntity universityStaffMemberEntity = iUniversityStaffRepository.findById(id).get();
			iUniversityStaffRepository.deleteById(id);
			return new ResponseEntity<>(universityStaffMemberEntity,HttpStatus.OK);
		}
		else {
			throw new DoesnotExistsException("Staff doesn't exists with Id: "+id);
		}
	}

	@Override
	public ResponseEntity viewStaff(int id) {
		if(iUniversityStaffRepository.findById(id).isPresent()) {

			UniversityStaffMemberEntity universityStaffMemberEntity = iUniversityStaffRepository.findById(id).get();
			return new ResponseEntity<>(universityStaffMemberEntity,HttpStatus.OK);
		}
		else {
			throw new DoesnotExistsException("Staff doesn't exists with Id: "+id);
		}
	}

	@Override
	public ResponseEntity viewAllStaff() {
		List<UniversityStaffMemberEntity> universityStaffMemberEntityList = iUniversityStaffRepository.findAll();
		return new ResponseEntity<>(universityStaffMemberEntityList,HttpStatus.OK);
	}
	
}
