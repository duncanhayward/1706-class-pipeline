package com.revature.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bean.UserBean;




/**
 * Servlet implementation class AjaxProcessProfile
 */
@WebServlet("ajaxStudentProfile")
public class AjaxProcessStudentProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		
		if(user != null){
			ObjectMapper mapper = new ObjectMapper();
			String userInfo = mapper.writeValueAsString(user);
			response.setContentType("application/json");
			response.getWriter().write(userInfo);
		}

	}



}
