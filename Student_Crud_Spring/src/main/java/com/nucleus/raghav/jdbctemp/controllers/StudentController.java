package com.nucleus.raghav.jdbctemp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nucleus.raghav.jdbctemp.dao.StudentDAOImpl;
import com.nucleus.raghav.jdbctemp.dto.Student;
@Controller
public class StudentController {
    @Autowired
	StudentDAOImpl sdi;//will inject sdi from xml file
    
    /*It displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form
     */
	@RequestMapping("/stuform")
	public ModelAndView showform(){
		return new ModelAndView("stuform","command",new Student());
	}
	/*It saves object into database. The @ModelAttribute puts request data
	 *  into model object. You need to mention RequestMethod.POST method 
	 *  because default request is GET*/
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("stu") Student stu){
		sdi.insertStudent(stu);
		return new ModelAndView("redirect:/viewstu");//will redirect to viewemp request mapping
	}
	/* It provides list of employees in model object */
	@RequestMapping("/viewstu")
	public ModelAndView viewemp(){
		List<Student> list=sdi.selectAll();
		return new ModelAndView("viewstu","list",list);
	}
	/* It displays object data into form for the given id. 
	 * The @PathVariable puts URL data into variable.*/
	@RequestMapping(value="/editstu/{studentId}")
	public ModelAndView edit(@PathVariable int studentId){
		Student stu=sdi.selectStudent(studentId);
		return new ModelAndView("stueditform","command",stu);
	}
	/* It updates model object. */
	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("stu") Student stu){
		sdi.updateStudent(stu);
		return new ModelAndView("redirect:/viewstu");
	}
	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value="/deletestu/{studentId}",method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int studentId){
		sdi.deleteStudent(studentId);
		return new ModelAndView("redirect:/viewstu");
	}

}