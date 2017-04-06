package com.motorbikesite;

public class DatabaseData {
	private String first;
	private String last;
	private int age;
	private String email;
	private String passWord;
	
	public DatabaseData(String first, String last, int age, String email, String passWord){
		this.first = first;
		this.last = last;
		this.age = age;
		this.email = email;
		this.passWord = passWord;
	}
	public DatabaseData(String email, String passWord){
		this.email = email;
		this.passWord = passWord;
	}
	public String getFirst(){
		return first;
	}
	public String getLast(){
		return last;
	}
	public int getAge(){
		return age;
	}
	public String getEmail(){
		return email;
	}
	public String getPassword(){
		return passWord;
	}
}
