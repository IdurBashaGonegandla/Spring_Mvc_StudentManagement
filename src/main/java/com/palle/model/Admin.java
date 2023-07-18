package com.palle.model;

public class Admin 
{
	private int ano;
	private String userName;
	private String Pass;
	public Admin( String userName, String pass) {
		super();
		
		this.userName = userName;
		Pass = pass;
	}
	
	public Admin() 
	{
		super();
		
	}

	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	
	

}
