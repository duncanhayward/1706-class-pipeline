package com.revature.dao;

import com.revature.bean.UserBean;

public interface UserDao {
	
	public UserBean getUserByEmail(UserBean user);
	
	public void saveUser(UserBean user);
}
