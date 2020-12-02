package com.cg.ams.util;

public class QueryUtil {
	private QueryUtil() {
		
	}
	public static final String VIEW_FACU_BY_ID = "SELECT a FROM AssignFacultyEntity a WHERE a.subjectId like ?1";

	public static final String DEL_FACU_BY_ID = "DELETE from AssignFacultyEntity a where a.facultyId like ?1";
			

}
