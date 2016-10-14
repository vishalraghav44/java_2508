package com.komila.hibernate;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class Main {

	public static void main(String[] args) {

		System.out.println("Hibernate One-To-One example (Annotation)");
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		EmployeeDetail employeeDetail = new EmployeeDetail("10th Street", "LA", "San Francisco", "U.S.");
		
		Employee employee = new Employee("Nina", "Mayers", new Date(121212),
				"114-857-965");
		employee.setEmployeeDetail(employeeDetail);
		employeeDetail.setEmployee(employee);
		
		
		session.save(employee);

		session.getTransaction().commit();
		List<Employee> employees = session.createQuery("from Employee").list();
		for (Employee employee1 : employees) {
			System.out.println(employee1.getFirstname() + " , "
					+ employee1.getLastname() + ", "
					+ employee1.getEmployeeDetail().getState());
            EmployeeDetail ed =  employee1.getEmployeeDetail();
            
            Employee x = ed.getEmployee();
		System.out.println("bidirectional" +" "+ x.getFirstname());
		
		}

		
		session.close();

	}
}
