package com.palle.model;

// Bean class / Encapsulated class
public class Student 
{
	private int sno;
	private String sname;
	private String email;
	private String password;
	private long mobile;
	
	public Student(int sno, String sname, String email, String password, long mobile) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
	
	
	public Student(String sname, String email, String password, long mobile) {
		super();
		this.sname = sname;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	} 
	
	

}
