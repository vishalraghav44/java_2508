// 2. control
package com.nucleus.mac.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.mac.service.LoginService;

@WebServlet("/LoginServletController")
public class LoginServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServletController() {
		super();

	}

	ServletContext cx = null;
	RequestDispatcher rc = null;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		String login = request.getParameter("login");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		LoginService ls = new LoginService(); // control goes to login service
		if (login != null) {
			String a = ls.service(username, password);
			cx = getServletContext();
			HttpSession session = request.getSession(true);
			if (a.equalsIgnoreCase("maker")) {

				System.out.println(username);
				session.setAttribute("uname", username);
				// session.setAttribute("Role",role);

				rc = cx.getRequestDispatcher("/WEB-INF/Maker.jsp");
				rc.forward(request, response);

			} else if (a.equalsIgnoreCase("checker")) {

				System.out.println(username);
				session.setAttribute("uname", username);
				// session.setAttribute("Role",role);
				rc = cx.getRequestDispatcher("/WEB-INF/Checker.jsp");
				rc.forward(request, response);

			} else {
				out.println("Invalid Input");
				response.sendRedirect("http://localhost:8080/MakerAndCheckerApp/WebContent/login.html");
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
