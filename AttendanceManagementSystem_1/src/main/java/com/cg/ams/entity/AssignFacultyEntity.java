package com.cg.ams.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author SaiTeja
 *
 */

@Entity
@Table(name = "ASSIGN_FACULTY5")
public class AssignFacultyEntity {
	

	@Id
	@Column(name = "FACULTY_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private Long facultyId;
	@Column(name = "USER_ID")
	private Long userId;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "COURSE_ID")
	private Long courseId;
	@Column(name = "COURSE_NAME")
	private String courseName;
	@Column(name = "SUBJECT_ID")
	private Long subjectId;
	@Column(name = "SUBJECT_NAME")
	private String subjectName;
	@Column(name = "SEMESTER")
	private String semester;
	@Column(name = "TOTAL_CLASS")
	private String totalClass;

	/*
	 * Creating one to many relation with students
	 */
	
	


	/*
	 * Getters and Setters for the above variables
	 */
	
	
	public AssignFacultyEntity() {
		
	}

	public AssignFacultyEntity(Long userId, String userName, Long courseId, String courseName, Long subjectId,
			String subjectName, String semester, String totalClass) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.courseId = courseId;
		this.courseName = courseName;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.semester = semester;
		this.totalClass = totalClass;
	}

	public Long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Long id) {
		this.facultyId = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getTotalClass() {
		return totalClass;
	}

	public void setTotalClass(String totalClass) {
		this.totalClass = totalClass;
	}

	@Override
	public String toString() {
		return "AssignFacultyEntity [facultyId=" + facultyId + ", userId=" + userId + ", userName=" + userName
				+ ", courseId=" + courseId + ", courseName=" + courseName + ", subjectId=" + subjectId
				+ ", subjectName=" + subjectName + ", semester=" + semester + ", totalClass=" + totalClass + "]";
	}
	

}
