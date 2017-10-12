package com.weatherapp.model.entities;

import java.io.Serializable;

public class Report implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id_user;
	private String city;
	private Weather weather;
	private double temperature;
	
	
	public Report(String city, Weather weather) {
		
		this.city = city;
		this.weather = weather;
	}
	
	public Report(String city, double temperature) {
		
		this.city = city;
		this.temperature = temperature;
	}
	
	public Report(int idUser, String city, double temperature) {
		this.id_user = idUser;
		this.city = city;
		this.temperature = temperature;
	}
	
	public Report() {
		
		
	}
	public String getCity() {
		return city;
	}
	public Weather getWeather() {
		return weather;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	/**
	 * @return the id_user
	 */
	public int getId_user() {
		return id_user;
	}

	/**
	 * @param id_user the id_user to set
	 */
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
}
