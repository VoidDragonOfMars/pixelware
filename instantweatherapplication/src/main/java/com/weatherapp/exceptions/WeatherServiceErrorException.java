package com.weatherapp.exceptions;

public class WeatherServiceErrorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public WeatherServiceErrorException(String message) {
		super(message);
	}
}
