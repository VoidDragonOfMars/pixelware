package com.weatherapp.model.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Location location;
	private Current current;
	

	
	public Weather(Location location, Current current) {
		
		this.location = location;
		this.current = current;
	}



	public Weather() {}



	public Location getLocation() {
		return location;
	}



	public void setLocation(Location location) {
		this.location = location;
	}



	public Current getCurrent() {
		return current;
	}



	public void setCurrent(Current current) {
		this.current = current;
	}

	
	
	
	
	

}
