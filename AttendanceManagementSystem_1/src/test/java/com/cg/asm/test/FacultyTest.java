package com.cg.asm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.ams.entity.AssignFacultyEntity;
import com.cg.ams.exception.RecordNotFoundException;
import com.cg.ams.repository.AssignFacultyDao;
import com.cg.ams.service.AssignFacultyService;
import com.cg.ams.service.AssignFacultyServiceImpl;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FacultyTest {
	@InjectMocks
	private AssignFacultyServiceImpl facultyService;
	
	@Mock
	private AssignFacultyDao facultyDao;
	
	@BeforeAll
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	
	public void addAttendanceTest() {
		AssignFacultyEntity faculty = new AssignFacultyEntity();
		faculty.setUserId((long) 161100);
		faculty.setUserName("ravi");
		faculty.setCourseId((long) 150);
		faculty.setCourseName("CSE");
		faculty.setSubjectId((long) 765);
		faculty.setSubjectName("java");
		faculty.setTotalClass("70");
		
		when(facultyDao.save(faculty)).thenReturn(faculty);
		Long facultyId = facultyService.add(faculty);
		
		assertEquals("CSE", faculty.getCourseName());
		verify(facultyDao,times(1)).save(faculty);
	}
	@Test
	public void updateFacultyTest() throws RecordNotFoundException {
		AssignFacultyEntity faculty = new AssignFacultyEntity();
		faculty.setUserId((long) 161102);
		faculty.setUserName("kiran");
		faculty.setCourseId((long) 160);
		faculty.setCourseName("ECE");
		faculty.setSubjectId((long) 755);
		faculty.setSubjectName("electronics");
		faculty.setTotalClass("60");
		Long facultyId = faculty.getFacultyId();
		Optional<AssignFacultyEntity> facultyEntity1 = facultyDao.findById(facultyId);
		
		when(facultyDao.findById(facultyId)).thenReturn(facultyEntity1);
		when(facultyDao.save(faculty)).thenReturn(faculty);
		
		faculty.setCourseId((long) 112);;
		
		facultyService.update(faculty);;
		
		assertEquals(112, faculty.getCourseId());
		verify(facultyDao, times(1)).save(faculty);
	}
	
	@Test
	public void viewFacultyTest() throws RecordNotFoundException {
		AssignFacultyEntity facultyEntity = new AssignFacultyEntity();
		facultyEntity.setUserId((long) 161342);
		facultyEntity.setUserName("praveen");
		facultyEntity.setCourseId((long) 170);
		facultyEntity.setCourseName("CSE");
		facultyEntity.setSubjectId((long) 775);
		facultyEntity.setSubjectName("java");
		facultyEntity.setTotalClass("68");
		Long facultyId = facultyEntity.getFacultyId();
		Optional<AssignFacultyEntity> faculty = Optional.of(facultyEntity);
		when(facultyDao.findById(facultyId)).thenReturn(faculty);
		
		AssignFacultyEntity viewAttendance = facultyService.getFacultyById(facultyId);
		
		assertEquals("CSE", viewAttendance.getCourseName());;
		verify(facultyDao, times(1)).findById(facultyId);
	}
	
	@Test
	public void viewFacultyListTest() throws RecordNotFoundException {
		List<AssignFacultyEntity> facultyList = new ArrayList<AssignFacultyEntity>();
		AssignFacultyEntity facultyEntity = new AssignFacultyEntity();
		facultyEntity.setUserId((long) 161112);
		facultyEntity.setUserName("pranay");
		facultyEntity.setCourseId((long) 180);
		facultyEntity.setCourseName("EEE");
		facultyEntity.setSubjectId((long) 785);
		facultyEntity.setSubjectName("electronics");
		facultyEntity.setTotalClass("66");
		
		AssignFacultyEntity facultyEntity1 = new AssignFacultyEntity();
		facultyEntity1.setUserId((long) 161902);
		facultyEntity1.setUserName("jittu");
		facultyEntity1.setCourseId((long) 181);
		facultyEntity1.setCourseName("ECE");
		facultyEntity1.setSubjectId((long) 785);
		facultyEntity1.setSubjectName("electronics");
		facultyEntity1.setTotalClass("67");
		
		facultyList.add(facultyEntity);
		facultyList.add(facultyEntity1);
	
		when(facultyDao.findAll()).thenReturn(facultyList);
		
		List<AssignFacultyEntity> facultyList2 = facultyService.findAllFaculty();
		
		assertEquals(2, facultyList2.size());
		verify(facultyDao, times(1)).findAll();
	}
}

	
