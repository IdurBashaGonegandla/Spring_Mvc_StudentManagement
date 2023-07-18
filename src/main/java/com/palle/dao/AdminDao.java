package com.palle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao 
{
	private static final String dbUrl ="jdbc:mysql://localhost:3306/spring";
	
	private static final String dbUsername="root";
	private static final String dbPassword="admin";
	
	private static Connection con= null;
	private static PreparedStatement ps= null;
	private static ResultSet rs= null;
	
	private static final String ValidateQuery= "select *from admin where username=? and password=? ;";

	public static boolean validateAdmin(String username, String pass)
	{
		boolean b = false;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			
			ps = con.prepareStatement(ValidateQuery);
			ps.setString(1,username);
			ps.setString(2, pass);
			
			rs = ps.executeQuery();
			
			b = rs.next();
			
		} 
		catch (ClassNotFoundException e)
		{
			
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					
		           e.printStackTrace();
				}
			}
		}
		return b;
		

		
	}
}
