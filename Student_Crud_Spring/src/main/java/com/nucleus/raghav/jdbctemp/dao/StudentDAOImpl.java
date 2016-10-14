package com.nucleus.raghav.jdbctemp.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.nucleus.raghav.jdbctemp.dto.Student;

public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbctemplate;
	
		public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override //save
	public int insertStudent(Student s) {
		int studentId=s.getStudentId();
		String name=s.getStudentName();
		int marks=s.getStudentMarks();
		
		int rows=jdbctemplate.update("insert into rv_student values(?,?,?)",studentId,name,marks);
		return rows;
	}


	@Override
	public void updateStudent(Student student) {
		String query="update rv_student set studentName=?,studentMarks=? where studentId=?";
		System.out.println(" Updation called....");
		jdbctemplate.update(query,new Object[]{student.getStudentName(),Integer.valueOf(student.getStudentMarks()),Integer.valueOf(student.getStudentId())
				});
	  
	}
	
	@Override
	public int deleteStudent(int studentId) {
		String query="delete from rv_student where studentId=?";
		return jdbctemplate.update(query,new Object[]{Integer.valueOf(studentId)});
		
	}

	//getempbyid
	@Override
	public Student selectStudent(int studentId) {
		final Student student = new Student();
		String query="select * from rv_student where studentId='"+studentId+"'";
		return (Student)jdbctemplate.query(query,new ResultSetExtractor<Student>(){
			public Student extractData(ResultSet rs) throws SQLException,DataAccessException{
				
				if(rs.next()){
					student.setStudentId(rs.getInt(1));
					student.setStudentName(rs.getString(2));
					student.setStudentMarks(rs.getInt(3));
				}return student;
			} 
			
		});
	}
  
	class MyMapper implements RowMapper<Student>{

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student st=new Student();
			st.setStudentId(rs.getInt(1));
			st.setStudentName(rs.getString(2));
			st.setStudentMarks(rs.getInt(3));
			return st;
		}
	}
//getemployees
	@Override
	public List<Student> selectAll() {
		String query="select * from rv_student";
		List<Student> stud=jdbctemplate.query(query,new MyMapper());
		return stud;
	}

	}

	
	
	
