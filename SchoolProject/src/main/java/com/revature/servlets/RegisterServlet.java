package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.bean.UserBean;
import com.revature.exceptions.InvalidUserException;
import com.revature.service.Service;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Service serv = new Service();
		try {
			if(!serv.registrationValidation(request)){
				response.sendRedirect("register.html");
			}else{
				UserBean user = new UserBean(
									   request.getParameter("email"),
									   request.getParameter("password"),
									   request.getParameter("firstName"),
									   request.getParameter("lastName"),
									   1
									   );
				
				serv.registerUser(user);
				response.sendRedirect("login.html");
			}
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}

		
	
	}

}
