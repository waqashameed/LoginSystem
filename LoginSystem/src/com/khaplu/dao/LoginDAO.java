package com.khaplu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO
{
	String sql = "select * from user where uname=? and password=?";
	String url = "jdbc:mysql://localhost/loginsystem";
	String username = "root";
	String pass = "";
	public boolean check(String uname, String password)
	{	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null; 
			conn = DriverManager.getConnection(url, username, pass);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return false;
	}
}
