package com.nucleus.mac.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nucleus.mac.dao.CustInfo;
import com.nucleus.mac.service.LoginService;

@WebServlet("/CrudController")
public class CrudController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrudController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext cx =null;
		RequestDispatcher rc=null;
		PrintWriter out= response.getWriter();
		String customer_code = request.getParameter("customer_code");
		System.out.println(customer_code);
		
		String customer_pincode = request.getParameter("customer_pincode");
		System.out.println(customer_pincode);
		
		String contact_no = request.getParameter("contact_no");
		System.out.println(contact_no);
		
		String customer_name = request.getParameter("customer_name");
		System.out.println(customer_name);
		
		String customer_address1 = request.getParameter("customer_address1");
		System.out.println(customer_address1);
		
		String customer_address2 = request.getParameter("customer_address2");
		System.out.println(customer_address2);
		
		String email_address = request.getParameter("email_address");
		System.out.println(email_address);
		
		String primary_contact_person = request.getParameter("primary_contact_person");
		
		
		String record_status = request.getParameter("record_status");
		
		
		String active_inactive_flag = request.getParameter("active_inactive_flag");
		
		
		String create_date = request.getParameter("create_date");
	
		
		String created_by = request.getParameter("created_by");
		
		
		String modified_date = request.getParameter("modified_date");
		
		String modified_by = request.getParameter("modified_by");
		
		
		String authorized_date = request.getParameter("authorized_date");
	
		String authorized_by = request.getParameter("authorized_by");
		
		
		String makersub = request.getParameter("makerbutton");
		  
		String checkersub=request.getParameter("checkerbutton");	
		  
		String addsub = request.getParameter("addsub");
		
		
		String deletesub = request.getParameter("deletesub");
		
		String searchsub = request.getParameter("searchsub");
		//System.out.println("hello");
		String updatesub = request.getParameter("updatesub");
		
		String searchback=request.getParameter("seachback");
		
		String back=request.getParameter("back");
		
	
		
		String btn = request.getParameter("choice");
		
		String btn1=request.getParameter("choice1");
		
		String authorizesub = request.getParameter("authorize");
		
		String rejectsub= request.getParameter("reject");
		
		String checkerback=request.getParameter("checkerback");
		

		String checkersearchsub=request.getParameter("checkersearchsub");
		// checker options
     	
		
		LoginService loginservice = new LoginService();
		
		System.out.println("helloo before makersub");
		if (makersub != null) {
		
			if (btn.equals("add")) {
				
				 cx = getServletContext();
				 rc = cx
						.getRequestDispatcher("/WEB-INF/Add.jsp");
				rc.forward(request, response);
			}
			else if(btn.equals("delete")){
				System.out.println("delete jsp called");
			 cx = getServletContext();
			 rc = cx.getRequestDispatcher("/WEB-INF/Delete.jsp");
				rc.forward(request, response);
				
			}
			else if(btn.equals("update")){
				cx = getServletContext();
				 rc = cx.getRequestDispatcher("/WEB-INF/Update.jsp");
				rc.forward(request, response);
				
			}
			else if(btn.equals("search")){
				cx = getServletContext();
				rc = cx	.getRequestDispatcher("/WEB-INF/MakerSearch.jsp");
				rc.forward(request, response);
			}
			else if(btn.equalsIgnoreCase("searchall")){
				List<CustInfo> arrlist = loginservice.searchall(customer_code, customer_pincode, contact_no,
						customer_name, customer_address1, customer_address2,
						email_address, primary_contact_person, record_status,
						active_inactive_flag, create_date, created_by,
						modified_date, modified_by, authorized_date, authorized_by);
				
				if(arrlist!=null){
				 cx = getServletContext();
				request.setAttribute("arrlist", arrlist);
				 rc = cx.getRequestDispatcher("/WEB-INF/MakerAllRecord.jsp");
				rc.forward(request, response);
				}
				
			}
			
		}
		
		if(checkersub!=null){
	
			
			if(btn1.equalsIgnoreCase("searchallchecker")){
             
			
				
				List<CustInfo> arrlist = loginservice.searchall(customer_code, customer_pincode, contact_no,
						customer_name, customer_address1, customer_address2,
						email_address, primary_contact_person, record_status,
						active_inactive_flag, create_date, created_by,
						modified_date, modified_by, authorized_date, authorized_by);
				
				if(arrlist!=null){
				 cx = getServletContext();
				request.setAttribute("arrlist", arrlist);
				 rc = cx.getRequestDispatcher("/WEB-INF/CheckerAllRecord.jsp");
				rc.forward(request, response);
				
			
				}
				
			}
			else if(btn1.equalsIgnoreCase("viewchecker")){
				cx = getServletContext();
				rc = cx	.getRequestDispatcher("/WEB-INF/checkersearch.jsp");
				rc.forward(request, response);
				
			}
	    }
		//Maker button options completed here
		if (addsub != null) {
		
		loginservice.add(customer_code, customer_pincode, contact_no,
					customer_name, customer_address1, customer_address2,
					email_address, primary_contact_person, record_status,
					active_inactive_flag, create_date, created_by,
					modified_date, modified_by, authorized_date, authorized_by);
			out.println("<b>"+" New Record  added...... ");
		}
		else if(deletesub!=null){
			loginservice.delete(customer_code, customer_pincode, contact_no,
					customer_name, customer_address1, customer_address2,
					email_address, primary_contact_person, record_status,
					active_inactive_flag, create_date, created_by,
					modified_date, modified_by, authorized_date, authorized_by);
			out.println("<b>"+" Record  Deleted...... ");
		}
		else if(searchsub!=null){
			List<CustInfo> list = loginservice.search(customer_code, customer_pincode, contact_no,
					customer_name, customer_address1, customer_address2,
					email_address, primary_contact_person, record_status,
					active_inactive_flag, create_date, created_by,
					modified_date, modified_by, authorized_date, authorized_by);
			
			if(list!=null){
			 cx = getServletContext();
			request.setAttribute("list", list);
			 rc = cx.getRequestDispatcher("/WEB-INF/MakerViewRecord.jsp");
			rc.forward(request, response);
			}
		
		}
		
		else if(updatesub!=null){
		
		String flag = loginservice.update(customer_code, customer_pincode, contact_no,
				customer_name, customer_address1, customer_address2,
				email_address, primary_contact_person, record_status,
				active_inactive_flag, create_date, created_by,
				modified_date, modified_by, authorized_date, authorized_by);
		if (flag.equalsIgnoreCase("Row Updated")){
			cx = getServletContext();
			rc = cx.getRequestDispatcher("/WEB-INF/Maker.jsp");
		}else{
			 cx = getServletContext();
			 rc = cx.getRequestDispatcher("/WEB-INF/Maker.jsp");
		}
		
		}
		if(searchback!=null){
			 cx = getServletContext();
			 rc = cx.getRequestDispatcher("/WEB-INF/MakerSearch.jsp");
			rc.forward(request, response);
		}
		else if(checkerback!=null){
				 cx = getServletContext();
				 rc = cx.getRequestDispatcher("/WEB-INF/Checker.jsp");
				rc.forward(request, response);
			
		}
		else if(back!=null){
			 cx = getServletContext();
			 rc = cx.getRequestDispatcher("/WEB-INF/Maker.jsp");
			rc.forward(request, response);
			
		}
		
		if(authorizesub!=null){
			
			loginservice.authorize(customer_code, customer_pincode, contact_no,
					customer_name, customer_address1, customer_address2,
					email_address, primary_contact_person, record_status,
					active_inactive_flag, create_date, created_by,
					modified_date, modified_by, authorized_date, authorized_by);
			out.println("<b>"+" New Record  added......to permanent db ");
			
		}
		
		if(checkersearchsub!=null){
			List<CustInfo> list = loginservice.search(customer_code, customer_pincode, contact_no,
					customer_name, customer_address1, customer_address2,
					email_address, primary_contact_person, record_status,
					active_inactive_flag, create_date, created_by,
					modified_date, modified_by, authorized_date, authorized_by);
			
			if(list!=null){
			 cx = getServletContext();
			request.setAttribute("list", list);
			 rc = cx.getRequestDispatcher("/WEB-INF/CheckerViewRecord.jsp");
			rc.forward(request, response);
			}
		}
	}
	
		
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
