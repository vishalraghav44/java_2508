package com.raghav.brd4.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="rv_Department")
public class Department {
	
	@Id
    @Column(name="dept_id")
	private String dept_id;

	@OneToMany(mappedBy = "dept")
	Set<Employee> emp;
	
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	public Department() {
		super();
		
	}

	public Department(String dept_id, Set<Employee> emp) {
		super();
		this.dept_id = dept_id;
		this.emp = emp;
	}

	
}
