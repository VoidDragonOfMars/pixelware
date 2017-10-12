package com.weatherapp.model.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Current implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private double temp_c;



	public Current() {
		
	}



	public Current(double temp_c) {
		
		this.temp_c = temp_c;
	}



	public double getTemp_c() {
		return temp_c;
	}



	public void setTemp_c(double temp_c) {
		this.temp_c = temp_c;
	}
	
	

}
