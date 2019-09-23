 package com.innovecture.weatherapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovecture.weatherapp.dto.Weather;
import com.innovecture.weatherapp.service.WeatherService;

@RestController
@RequestMapping("/")
public class WeatherAppController {

	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/weather/{zipcode}")
	public Weather getWeather(@PathVariable("zipcode") String zipCode) {
		
		return weatherService.getWeatherDataByZipCode(zipCode);
		
	}
}
