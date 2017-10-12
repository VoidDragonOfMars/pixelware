package com.weatherapp.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String email;
	private String pass;
	private Date date;
	private String name;
	private String country;
	private List<Report> reports;
	
	
	
	public User() {
		
	}
	
	
	
	
	public User(String pass, String name) {
		
		this.pass = pass;
		this.name = name;
	}




	public User(String email, String pass, Date date, String name, String country) {
		
		this.email = email;
		this.pass = pass;
		this.date = date;
		this.name = name;
		this.country = country;
	}
	
	
	public User(int id, String name, String email, Date date, String country, String pass) {
		
		this.id = id;
		this.email = email;
		this.pass = pass;
		this.date = date;
		this.name = name;
		this.country = country;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}




	/**
	 * @return the reports
	 */
	public List<Report> getReports() {
		return reports;
	}




	/**
	 * @param reports the reports to set
	 */
	public void setReports(List<Report> reports) {
		this.reports = reports;
	}
	
	
	

}
