package com.raghav.brd4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.raghav.brd4.dao.EmpDAO;
import com.raghav.brd4.dto.Count;
import com.raghav.brd4.dto.Department;
import com.raghav.brd4.dto.Employee;

@Controller
public class EmpController {

	@Autowired
	EmpDAO edi;
	Department department = new Department();
	Employee empl = new Employee();
	String dept_id=null;
	String id = null;
	
// function for view
	@RequestMapping("/viewemp/{id}")
	public ModelAndView viewemp(@PathVariable("id") String id) {
		List<Count> list = edi.selectAll();
		this.id = id;
		if (id.equals("ab"))
		return new ModelAndView("viewemp", "list", list);
		else if (id.equals("cd"))
			return new ModelAndView("viewadmin", "list", list);
		return null;
	}
//function on click
	@RequestMapping("/empdept/{dept_id}")
	public String empByDept(@PathVariable("dept_id") String emp, ModelMap map) {
		map.addAttribute("list", edi.selectAll());
		department.setDept_id(emp);
		map.addAttribute("employee", edi.deptInfo(emp));
		if (id.equals("ab"))
		   return "viewemp";
		else if (id.equals("cd"))
			return "viewadmin";
		return null;
	}
	// Function for search
	@RequestMapping("/search")
	public String search(@RequestParam(value = "emp") String emp, ModelMap map) {
		map.addAttribute("list", edi.selectAll());
	String did = department.getDept_id();
		map.addAttribute("employee", edi.search(emp, did));
		if (id.equals("ab"))
		return "viewemp";
		else if (id.equals("cd"))
			return "viewadmin";
		return null;
	}
	// function for sorting
	@RequestMapping("/sort")
	public String sort(@RequestParam(value = "name") String name,
			@RequestParam(value = "type") String type, ModelMap map) {
		map.addAttribute("list", edi.selectAll());
		String did = department.getDept_id();
		map.addAttribute("employee", edi.sort(name, type, did));
		if (id.equals("ab"))
		return "viewemp";
		else if (id.equals("cd"))
			return "viewadmin";
		return null;
	}
	
/*	// add
		@RequestMapping("/addemp")
		public ModelAndView controltransfer(ModelMap map) {
			dId = department.getDId();
			List<Department> list = service.setData(dId);
			return new ModelAndView("add", "list", list);
		}

		@RequestMapping(value = "/add", method = RequestMethod.POST)
		public String addEmployee(
				@ModelAttribute(value = "employee") Employee employee,
				BindingResult result) {
			service.addEmployee(employee);
			return "redirect:/";
		}*/
	
	/*@RequestMapping("/delete/{emp_id}/{dept_id}")
	public String deleteEmployee(@PathVariable("emp_id") String emp,@PathVariable(value = "dept_id") String dept_id , ModelMap map)
	{
		map.addAttribute("list",edi.deleteEmployee(emp,dept_id));
		department.setDept_id(dept_id);
		map.addAttribute("employee", edi.deptInfo(dept_id));
		return "viewemp";
		
	}*/
	
	@RequestMapping("/delete/{emp_id}")
	public ModelAndView deleteEmployee(@PathVariable("emp_id") String employeeId)
	{
				
		
		edi.deleteEmployee(employeeId);
		List<Count> list = edi.selectAll();
		return new ModelAndView("viewemp", "list", list);
		
	}
	
	
	
	// spring security
		@RequestMapping(value = { "/", "/index", "/hello", "/back"  }, method = RequestMethod.GET)
		public ModelAndView defaultPage() {

			ModelAndView model = new ModelAndView();
			model.addObject("title",
					"Spring Security Login Form - Database Authentication");
			model.addObject("message", "This is default page!");
			model.setViewName("hello");
			return model;

		}

		@RequestMapping(value = "/viewadmin", method = RequestMethod.GET)
		public ModelAndView adminPage() {

			ModelAndView model = new ModelAndView();
			model.addObject("title",
					"Spring Security Login Form - Database Authentication");
			model.addObject("message", "This page is for ROLE_ADMIN only!");
			model.setViewName("admin");
			return model;
		}

		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView login(
				@RequestParam(value = "error", required = false) String error,
				@RequestParam(value = "logout", required = false) String logout) {

			ModelAndView model = new ModelAndView();
			if (error != null) {
				model.addObject("error", "Invalid username and password!");
			}

			if (logout != null) {
				model.addObject("msg", "You've been logged out successfully.");
			}
			model.setViewName("login");

			return model;

		}

		// for 403 access denied page
		@RequestMapping(value = "/403", method = RequestMethod.GET)
		public ModelAndView accesssDenied() {

			ModelAndView model = new ModelAndView();

			// check if user is login
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken)) {
				UserDetails userDetail = (UserDetails) auth.getPrincipal();
				System.out.println(userDetail);

				model.addObject("username", userDetail.getUsername());

			}

			model.setViewName("403");
			return model;
		}
//--------------------------------------------------//
	

	

	/*@RequestMapping("/edit/{employeeId}")
	public ModelAndView edit(@PathVariable("employeeId") Integer employeeId) {
		EmployeeEntity employee = employeeManager.getEmployeeById(employeeId);
		return new ModelAndView("editemployee", "command", employee);
	}*/
		
	
}