package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bean.UserBean;
import com.revature.service.Service;


@WebServlet("login")
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = -2133730339858743837L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		UserBean user = new UserBean();

		
		String email= req.getParameter("email");
		String password = req.getParameter("password");
		
		user.setEmail(email);
		user.setPassword(password);
		user = new Service().authenticateUser(user);
		System.out.println(user);
		System.out.println("The user enter: " + email + " & " + password);
		if(user!=null && user.getRole() == 1){
			HttpSession session = req.getSession(); 
			
			session.setAttribute("user", user);
			
			req.getRequestDispatcher("student.html").forward(req, resp);
		}else if(user!=null){
			HttpSession session = req.getSession(); 
			
			session.setAttribute("user", user);
			req.getRequestDispatcher("teacher.html").forward(req, resp);
			
		}else{
			req.getRequestDispatcher("login.html").forward(req, resp);
		}
	}
}