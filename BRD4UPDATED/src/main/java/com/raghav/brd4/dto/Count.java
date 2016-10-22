package com.raghav.brd4.dto;

public class Count {
String dept_id;
Long count;
public String getDept_id() {
	return dept_id;
}
public void setDept_id(String dept_id) {
	this.dept_id = dept_id;
}
public Long getCount() {
	return count;
}
public void setCount(Long count) {
	this.count = count;
}
public Count(String dept_id, Long count) {
	super();
	this.dept_id = dept_id;
	this.count = count;
}
public Count() {
	super();
	
}

}
