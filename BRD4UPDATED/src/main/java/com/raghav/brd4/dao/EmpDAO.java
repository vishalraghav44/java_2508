package com.raghav.brd4.dao;

import java.util.List;

import com.raghav.brd4.dto.Count;
import com.raghav.brd4.dto.Employee;

public interface EmpDAO {
	public List<Count> selectAll();

	public List<Employee> deptInfo(String dept_id);

	public List<Employee> search(String emp_name, String did);

	public List<Employee> sort(String name, String type, String did);

	public void deleteEmployee(String employeeId);
	/*public List<Employee> deleteEmployee(String employeeId,String dept_id);*/
}
