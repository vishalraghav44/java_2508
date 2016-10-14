package com.nucleus.raghav.jdbctemp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nucleus.raghav.jdbctemp.dao.StudentDAO;
import com.nucleus.raghav.jdbctemp.dto.Student;

public class StudentBean {

	private StudentDAO studentDAO;

	/*public StudentDAO getStudentDAO() {
		return studentDAO;
	}*/
	/*@Autowired*/
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	public void insertStudent(int sid,String stuname,int marks){
		
		Student student=new Student();
		student.setStudentId(sid);
		student.setStudentName(stuname);
		student.setStudentMarks(marks);
		
		int result1=studentDAO.insertStudent(student);
		System.out.println(result1+": Record Inserted...");
		
	}
	
	public int deleteStudent(int studentId){
		return studentDAO.deleteStudent(studentId);
	}
	
	public Student selectStudent(int studentId){
		
		return studentDAO.selectStudent(studentId);
	}
	public void updateStudent(Student student){
		studentDAO.updateStudent(student);
		
	}
	public void check(){
		List<Student> stud=studentDAO.selectAll();
		for(Student record:stud){
			System.out.println("ID"+record.getStudentId());
			System.out.println(", Name :"+record.getStudentName());
		}
		
	}
	
}
