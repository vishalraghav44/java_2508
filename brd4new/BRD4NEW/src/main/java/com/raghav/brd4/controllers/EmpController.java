package com.raghav.brd4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.raghav.brd4.dao.EmpDAOImpl;
import com.raghav.brd4.dto.Count;

@Controller
public class EmpController {
	 @Autowired
		EmpDAOImpl edi;
	 
	 @RequestMapping("/viewemp")
		public ModelAndView viewemp(){
			List<Count> list=edi.selectAll();
			return new ModelAndView("viewemp","list",list);
}
}