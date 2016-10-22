package com.raghav.brd4.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rv_Employee")
public class Employee {
	@Id
    @Column(name="emp_id")
	private String emp_id;
	
	@Column(name="emp_name")
	private String emp_name;
	
	@Column(name="designation")
	private String designation;
	
	
	@ManyToOne
    @JoinColumn(name ="dept_id")
	Department dept;
	
	
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	public Employee(String emp_id, String emp_name, String designation,
			Department dept) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.designation = designation;
		this.dept = dept;
	}

	public Employee() {
		super();
		
	}
}
