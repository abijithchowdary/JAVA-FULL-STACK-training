package com.capg.spring;

public interface StudentDao {
	
	public void save(StudentBean bean);
	
	public StudentBean get(int regNO);
	
	public int updateStudentName(int regNo,String newname);
	
	public int removeStudent(int regNo);
}
