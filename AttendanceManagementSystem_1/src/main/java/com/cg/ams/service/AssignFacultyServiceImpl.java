package com.cg.ams.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ams.entity.AssignFacultyEntity;
import com.cg.ams.exception.RecordNotFoundException;
import com.cg.ams.repository.AssignFacultyDao;
import com.cg.ams.util.ErrorMessageUtil;

/*
 * @author SaiTeja
 */
//defining the business logic
@Service("service")
@Transactional
public class AssignFacultyServiceImpl implements AssignFacultyService {
	
	@Autowired
	AssignFacultyDao facultyDao;

	// saving a specific record by using the method save() of CrudRepository
		@Override
		public Long add(AssignFacultyEntity facultyEntity) {
			facultyDao.save(facultyEntity);
			return facultyEntity.getFacultyId();
		}

		// updating a record
		@Override
		public void update(AssignFacultyEntity facultyEntity) throws RecordNotFoundException {
			if (facultyDao.findById(facultyEntity.getFacultyId()) == null) {
				throw new RecordNotFoundException(ErrorMessageUtil.ENTITY_NOT_FOUND);
			}
			facultyDao.save(facultyEntity);

		}

		// deleting a specific record by using the method deleteById() of CrudRepository
		@Override
		public void deleteByFacultyId(Long facultyId) throws RecordNotFoundException {
			if (facultyDao.findById(facultyId) == null) {
				throw new RecordNotFoundException(ErrorMessageUtil.FACU_RECORD_NOT_FOUND);
			}
			facultyDao.deleteById(facultyId);
		}

		// getting a specific record by using the method findById() of CrudRepository
		@Override
		public List<AssignFacultyEntity> findBySubjectId(Long subjectId) throws RecordNotFoundException {
			if (facultyDao.findBySubjectId(subjectId) == null) {
				throw new RecordNotFoundException(ErrorMessageUtil.FACU_RECORD_NOT_FOUND);
			}
			return facultyDao.findBySubjectId(subjectId);

		}

		// getting a specific record by using the method findById() of CrudRepository
		@Override
		public AssignFacultyEntity getFacultyById(Long facultyId) throws RecordNotFoundException {
			Optional<AssignFacultyEntity> faculty = facultyDao.findById(facultyId);
			if (faculty.isEmpty()) {
				throw new RecordNotFoundException(ErrorMessageUtil.FACU_RECORD_NOT_FOUND);
			}
			return faculty.get();
		}

		// getting all attendance records by using the method findaAll() of CrudRepository
		@Override
		public List<AssignFacultyEntity> findAllFaculty() throws RecordNotFoundException {
			List<AssignFacultyEntity> faculty = new ArrayList<AssignFacultyEntity>();
			facultyDao.findAll().forEach(faculty1 -> faculty.add(faculty1));
			return faculty;
		}

}
