package com.revature.service;

import javax.servlet.http.HttpServletRequest;

import com.revature.bean.UserBean;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.InvalidUserException;



public class Service {
	
	UserDao dao = new UserDaoImpl();
	
		
		
    public UserBean authenticateUser(UserBean user){
    	   
    UserBean dbUser = dao.getUserByEmail(user);
 
	if(dbUser != null){
			System.out.println(dbUser);
			System.out.println(user);
			if( dbUser.getEmail().equals(user.getEmail() )  
				&& dbUser.getPassword().equals(user.getPassword())){
			return dbUser;
		}
			
		
	}
	return null;
   }

    public void registerUser(UserBean user){
    	dao.saveUser(user);
    }

    
    
    public boolean registrationValidation(HttpServletRequest req) throws InvalidUserException{
    	
    			if(req.getParameter("email") == null ||
    			   req.getParameter("password") == null ||
    			   req.getParameter("firstName") == null ||
    			   req.getParameter("lastName") == null 	
    			//   req.getParameter("confirmPassword") == null ||
    			  // !req.getParameter("password").equals(req.getParameter("confirmPassword"))
    			   )
    			{
    				return false;
    			}
    			return true;

    }
    
    
    
}