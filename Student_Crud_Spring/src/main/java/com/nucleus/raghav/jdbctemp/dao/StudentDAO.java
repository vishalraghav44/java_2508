package com.nucleus.raghav.jdbctemp.dao;

import java.util.List;

import com.nucleus.raghav.jdbctemp.dto.Student;

public interface StudentDAO {
	Student selectStudent(int studentId);
	int insertStudent(Student s);
	int deleteStudent(int studentId);
	void updateStudent(Student student);
	List<Student> selectAll();
}
