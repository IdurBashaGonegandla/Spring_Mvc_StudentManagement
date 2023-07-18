package com.palle.dao;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.palle.model.Student;

//Below class is used to write Jdbc code
public class StudentDao 
{
	private static final String url= "jdbc:mysql://localhost:3306/spring";
	private static final  String userName="root";
	private static final String password="admin";
	
	private static Connection con = null;
	private static Statement st = null;
	private static PreparedStatement ps =null;
	private static ResultSet rs = null;
	
	
	private static final String insertQuery = " insert into student(name, email, pw, mobile) values(?,?,?,?) ";
	private static final String displayAllStudentQry ="select *from student ";
	private static final String getOneStudentQry = "select * from student where sno = ?";
	private static final String updateQry = "update student set  name=?, email=?, pw=?, mobile=? where sno=?";
	private static final String deleteQry = "delete from student where sno = ?";
	
	public static void insertStudent(Student s)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		    con = DriverManager.getConnection(url, userName, password);
			
		    ps = con.prepareStatement(insertQuery);
		    ps.setString(1, s.getSname());
		    ps.setString(2, s.getEmail());
		    ps.setString(3, s.getPassword());
		    ps.setLong(4, s.getMobile());
		    
		    ps.executeUpdate();
		    
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
				
			}
			if(con!=null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
	public static ArrayList<Student> getAllStudent()
	{
		ArrayList<Student> al = new ArrayList<Student>();
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, userName, password);
			
			st = con.createStatement();
			
			rs = st.executeQuery(displayAllStudentQry);
			
			while (rs.next())
			{
				int i = rs.getInt("sno");
				String n = rs.getString("name");
				String e = rs.getString("email");
				String p = rs.getString("pw");
				long m = rs.getLong("mobile");
				
				Student s = new Student(i, n, e, p, m);
				
				al.add(s);
				
			}
			
		}
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} catch (SQLException e) 
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

			if(st!=null)
			{
				try{
					st.close();
				} catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
				
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
			}
			
		}
		return al;
		
	}
	public static void editStudent(Student s)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, userName, password);
			
			ps = con.prepareStatement(updateQry);
			
			
			ps.setString(1, s.getSname());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setLong(4, s.getMobile());
			ps.setInt(5, s.getSno());
			
			ps.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
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
	}
	public static Student getOneStudent(int sno)
	{
		Student s = null;
		try
		{
            Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, userName, password);
			
			
			
		    ps = con.prepareStatement(getOneStudentQry);
			ps.setInt(1, sno);
			
			rs = ps.executeQuery();	
			
			rs.next();
			
			int i= rs.getInt("sno");
			String n = rs.getString("name");
			String e = rs.getString("email");
			String p = rs.getString("pw");
			long m = rs.getLong("mobile");
			
			s = new Student(i, n, e, p, m);
			
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
		finally
		{
		  if(rs!=null)
			  {
				try 
				{
					rs.close();
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
			  }
			
		 if(ps!=null)
		  {
			try 
			{
				ps.close();
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		  }
		 if(con!=null)
		  {
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
			
				e.printStackTrace();
			}
		   }
		}
		return s;
		
		
	}
	public static void deleteStudent(int sno) 
	{
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			
			ps = con.prepareStatement(deleteQry);
			
			ps.setInt(1, sno);
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
						e.printStackTrace();
		}
			
			
			
		
		
	}

}
