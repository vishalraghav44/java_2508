package com.raghav.brd4.business;

import java.util.List;

import com.raghav.brd4.dao.EmpDAO;
import com.raghav.brd4.dto.Count;

public class EmpService {

	private EmpDAO empDAO;

	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}
	
	
public List<Count> check() {
		
		List<Count> list = empDAO.selectAll();
		for (Count record : list) {
			System.out.println("Department ID" + record.getDept_id());
			System.out.println(", Number Of Employees :" + record.getCount());
		}
		return list;
	}
}
