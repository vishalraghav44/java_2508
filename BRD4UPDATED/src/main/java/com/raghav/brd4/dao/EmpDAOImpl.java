package com.raghav.brd4.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raghav.brd4.dto.Count;
import com.raghav.brd4.dto.Department;
import com.raghav.brd4.dto.Employee;

@Repository
@Transactional

public class EmpDAOImpl implements EmpDAO {
	@Autowired
	private SessionFactory sessionFactory;

	
	public List<Count> selectAll() {
		List<Count> list = new ArrayList<Count>();
		String sql = "SELECT d.dept_id,count(e.emp_id)"
				+ " AS Total_Employees FROM Employee e"
				+ " INNER JOIN e.dept d GROUP BY d.dept_id";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		for (Iterator it = query.iterate(); it.hasNext();) {
			Count count = new Count();
			Object[] row = (Object[]) it.next();
			count.setDept_id((String) row[0]);
			count.setCount((Long) row[1]);
			list.add(count);
		}
		return list;
	}

	public List<Employee> deptInfo(String dept_id) {
		String sql = "FROM Employee WHERE dept_id='" + dept_id + "'";
		return this.sessionFactory.getCurrentSession().createQuery(sql).list();
	}
	

	public List<Employee> search(String emp_name, String did) {
		String sql = "FROM Employee WHERE emp_name='" + emp_name + "' AND dept_id='"
				+ did + "'";
		return this.sessionFactory.getCurrentSession().createQuery(sql).list();
	}

	public List<Employee> sort(String name, String type, String did) {
		String sql = "FROM Employee WHERE dept_id='" + did + "' ORDER BY ("
				+ name + ") " + type;
		return this.sessionFactory.getCurrentSession().createQuery(sql).list();
	}

	public List<Department> setData(String id) {
		String sql = "FROM Department WHERE dept_id='" + id + "'";
		return this.sessionFactory.getCurrentSession().createQuery(sql).list();
	}

	public void addEmployee(Employee employee) {
		this.sessionFactory.getCurrentSession().save(employee);
	}

	public void delete(String emp_id) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(
				Employee.class, emp_id);
		this.sessionFactory.getCurrentSession().delete(employee);
	}
	public void  deleteEmployee(String employeeId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(
				Employee.class, employeeId);
         
        this.sessionFactory.getCurrentSession().delete(employee);
        
    /* ***************************    
	public List<Employee>  deleteEmployee(String employeeId,String dept_id) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(
				Employee.class, employeeId);
         
        this.sessionFactory.getCurrentSession().delete(employee);
        String sql = "FROM Employee WHERE dept_id='" + dept_id + "'";
		return this.sessionFactory.getCurrentSession().createQuery(sql).list();
	}*/

	}
}
