package com.weatherapp.services;


import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.weatherapp.exceptions.WeatherServiceErrorException;
import com.weatherapp.model.entities.Weather;

@Service
public class WeatherService {
	
	private static String url = "http://api.apixu.com/v1/current.json?key=6ff51f02033e4288b58103239170610&q= {city}"; 
	
	public Weather getCurrentWeather(String city) {
		Weather weather = null;
		 
		RestTemplate template = new RestTemplate();
		try {
			weather = (Weather) template.getForObject(url, Weather.class, city);
		}catch (HttpClientErrorException httpClientErrorException ) {
			
			throw new WeatherServiceErrorException("La ciudad introducida no existe o no está registrada: " +  httpClientErrorException.getMessage());
		}
		
		
		return weather;
		
	
	}
	
	

}
