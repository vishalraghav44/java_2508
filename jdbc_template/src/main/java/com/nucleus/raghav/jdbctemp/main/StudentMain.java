package com.nucleus.raghav.jdbctemp.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nucleus.raghav.jdbctemp.business.StudentBean;

public class StudentMain {

	
	public static void main(String[] args) {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/java/studentcrud.xml");
	StudentBean bean=(StudentBean)ctx.getBean("sb");	
	/*bean.insertStudent(1,"Raghav",95);
	bean.insertStudent(2,"Mike",98);*/
	bean.insertStudent(23,"Mark",90);
	bean.insertStudent(24,"Zuckerberg",95);
	bean.insertStudent(25,"Tom",91);
	bean.insertStudent(26,"Bill",99);
	/*Student student2= bean.selectStudent(2);
	student2.setStudentMarks(80);
	student2.setStudentName("Mark");*/
	bean.check();
	}

}
