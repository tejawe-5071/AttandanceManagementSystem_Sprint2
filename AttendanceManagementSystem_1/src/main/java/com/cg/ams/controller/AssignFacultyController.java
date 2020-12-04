package com.cg.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ams.entity.AssignFacultyEntity;
import com.cg.ams.exception.RecordNotFoundException;
import com.cg.ams.service.AssignFacultyService;
import org.apache.log4j.Logger;




@RestController
public class AssignFacultyController {
	@Autowired
	private AssignFacultyService facultyService;
	
	public static final Logger log = Logger.getLogger(AssignFacultyController.class.getName());

	@GetMapping("/hello-world")
	public String sayHello() {
		return "HelloWorld";
	}
	

	// creating a get mapping that retrieves all the books detail from the database
	@GetMapping("/list")
	public List<AssignFacultyEntity> getAllFaculty() throws RecordNotFoundException {
		log.info("Strated Viewing all faculty details");
		return facultyService.findAllFaculty();// response entity
	}

	// creating post mapping that post the faculty detail in the database
	@PostMapping("/insert")
	public Long create(@RequestBody AssignFacultyEntity faculty) {
		log.info("Strated Adding faculty details");
		facultyService.add(faculty);
		@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		log.info("completed Adding faculty details");
		return faculty.getFacultyId();
	}

	// creating put mapping that updates the faculty detail
	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody AssignFacultyEntity faculty) throws RecordNotFoundException {
		log.info("Strated updateing faculty details");
		facultyService.update(faculty);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		log.info("Completed updating faculty details");
		return responseEntity;
	}

	// creating a delete mapping that deletes a specified faculty
	@RequestMapping(value = "/delete/{facultyId}", method = RequestMethod.DELETE)
	public String deleteFaculty(@PathVariable("facultyId") Long facultyId) throws RecordNotFoundException {
		log.info("Strated Deleting faculty details");
		facultyService.deleteByFacultyId(facultyId);
		log.info("Completed deleting faculty details");
		return "faculty has been deleted successfully";
	}

	// creating a get mapping that retrieves the detail of a specific faculty
	@GetMapping("/findFaculty/{subjectId}")
	public ResponseEntity<List<AssignFacultyEntity>> getFacultyBySubjectId(@PathVariable("subjectId") Long subjectId)
			throws RecordNotFoundException {
		log.info("Strated Viewing all faculty details using subject id");
		List<AssignFacultyEntity> faculty = facultyService.findBySubjectId(subjectId);
		log.info("Completed Viewing all faculty details using subject id");
		return new ResponseEntity<List<AssignFacultyEntity>>(faculty, HttpStatus.OK);
	}

	// creating a get mapping that retrieves the detail of a specific faculty
	@GetMapping("/find/{facultyId}")
	public ResponseEntity<AssignFacultyEntity> getFacultyById(@PathVariable("facultyId") Long facultyId)
			throws RecordNotFoundException {
		log.info("Strated finding faculty details by id");
		AssignFacultyEntity faculty = facultyService.getFacultyById(facultyId);
		log.info("Strated finding faculty details by id");
		return new ResponseEntity<AssignFacultyEntity>(faculty, new HttpHeaders(), HttpStatus.OK);
	}
}
