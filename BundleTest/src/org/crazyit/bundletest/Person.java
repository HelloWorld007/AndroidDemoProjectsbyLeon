package org.crazyit.bundletest;

import java.io.Serializable;

public class Person implements Serializable{
	
	private String name;
	private String password;
	private String gender;
	
	public Person(String name, String password, String gender)
	{
		this.name = name;
		this.password = password;
		this.gender = gender;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	public String getGender()
	{
		return gender;
	}
}
