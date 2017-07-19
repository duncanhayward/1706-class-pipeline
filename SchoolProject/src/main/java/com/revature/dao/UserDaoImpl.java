package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bean.UserBean;

public class UserDaoImpl implements UserDao{

	private static final String USERNAME = "school_db";
	private static final String PASSWORD = "p4ssw0rd";
	private static final String URL= "jdbc:oracle:thin:@localhost:1521:xe";
	
	@Override
	public UserBean getUserByEmail(UserBean user){
		UserBean returnedUser = null;
		String sql = "SELECT * FROM Users WHERE u_email = ?";
		try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				returnedUser =  new UserBean(rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getInt(6));
			};
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnedUser;
	}

	@Override
	public void saveUser(UserBean user) {
		String sql = "INSERT INTO Users(u_email, u_password, f_name, l_name, u_role_id) VALUES(?,?,?,?,?)";
		try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getFirstName());
		ps.setString(4, user.getLastName());
		ps.setInt(5, user.getRole());
		ps.executeUpdate();
		connect.commit();
	}catch(SQLException e){
		e.printStackTrace();
	}

	}

}
