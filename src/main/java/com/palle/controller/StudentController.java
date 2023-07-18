package com.palle.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.palle.dao.AdminDao;
import com.palle.dao.StudentDao;
import com.palle.model.Admin;
import com.palle.model.Student;

@Controller
public class StudentController 
{
	@RequestMapping("list")
	public ModelAndView getIndexPage(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mv = new ModelAndView();
		String u = req.getParameter("tbUser");
		String p = req.getParameter("tbPass");
		
		Admin a = new Admin(u ,p);
		
		
		
	 // call the dao method to validate admin
	   boolean rs = AdminDao.validateAdmin(u , p);
				
			//Condition to redirect admin to list page
				if(rs)
				{
					mv.setViewName("index.jsp");
				}
				else 
				{
					mv.setViewName("admin.jsp");
				}
		
		
		return mv;
		
	}
	@RequestMapping(value="student", params="reg")
	public ModelAndView getRegisterPage()
	{
		ModelAndView mv = new ModelAndView ();
		
		mv.setViewName("register.jsp");
		return mv;
	}
	@RequestMapping(value="student", params="show")
	public ModelAndView displayAllStudents()
	{
		ModelAndView mv = new ModelAndView();
		
		// Call the Dao method
		ArrayList<Student> alstd = StudentDao.getAllStudent();
		
		// We need redirect user to display.jsp with ArrayList Data
		mv.addObject("student",alstd);
		
		mv.setViewName("display.jsp");
		
		return mv;
		
	}
	@RequestMapping(value="student" , params="log")
	public ModelAndView getLogout()
	{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("admin.jsp");
		
		return mv;
		
	}
	
	@RequestMapping("insert")
	public ModelAndView insertStudentServlet(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mv = new ModelAndView();
		String n = req.getParameter("tbName");
		String e = req.getParameter("tbEmail");
		String p = req.getParameter("tbPass");
		long  m =Long.parseLong(req.getParameter("tbMobile"));
		
		Student std = new Student(n, e, p ,m);
		
		StudentDao.insertStudent(std);
		
		mv = displayAllStudents();
		
		
		
		return mv;
		
	}
	
	@RequestMapping("editForm")
	public ModelAndView editPageServlet(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mv = new ModelAndView();
		
		int i = Integer.parseInt(req.getParameter("sno"));
	   
		Student s = StudentDao.getOneStudent(i);
		mv.addObject("student", s);
		
		mv.setViewName("editForm.jsp");
		
		return mv;
		
	}
	@RequestMapping(value="edit")
	public ModelAndView editServlet(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mv = new ModelAndView();
		int i = Integer.parseInt(req.getParameter("tbSno"));
		String n = req.getParameter("tbName");
		String e = req.getParameter("tbEmail");
		String p = req.getParameter("tbPass");
		long  m =Long.parseLong(req.getParameter("tbMobile"));
		
		Student std = new Student(i, n, e, p ,m);
		
		StudentDao.editStudent(std);
		
		
		mv = displayAllStudents();
		
		return mv;
		
	}
	@RequestMapping("delete")
	public ModelAndView delete(HttpServletRequest req,HttpServletResponse res)
	{
		ModelAndView mv=new ModelAndView();
		
		int no=Integer.parseInt(req.getParameter("sno"));
		
		StudentDao.deleteStudent(no);
		
		mv= displayAllStudents();

		return mv;
	}
	@RequestMapping(value="back" , params="btn")
	public ModelAndView getback()
	{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("index.jsp");
		
		return mv;
		
	}
	
	
	

}
