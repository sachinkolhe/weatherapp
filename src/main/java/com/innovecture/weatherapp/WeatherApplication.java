package com.innovecture.weatherapp;

import java.time.LocalDate;
import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.innovecture.weatherapp.dao.WeatherDao;
import com.innovecture.weatherapp.model.TimeTempModel;
import com.innovecture.weatherapp.model.WeatherModel;

@SpringBootApplication
public class WeatherApplication implements CommandLineRunner{

	@Autowired
	private WeatherDao weatherDao;
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	@Override
	public void run(String... args) throws Exception {

		WeatherModel weather = new WeatherModel();
		weather.setZipCode("12345");
		weather.setDate(LocalDate.now().plusDays(1));
		
		TimeTempModel timeTemp = new TimeTempModel();
		timeTemp.setTemparature(25);
		timeTemp.setTime(LocalTime.of(9, 0));
		timeTemp.setWeatherModel(weather);
		weather.getListTimeTemp().add(timeTemp);
		
		
		timeTemp = new TimeTempModel();
		timeTemp.setTemparature(25);
		timeTemp.setTime(LocalTime.of(12, 0));
		timeTemp.setWeatherModel(weather);
		weather.getListTimeTemp().add(timeTemp);
		
		timeTemp = new TimeTempModel();
		timeTemp.setTemparature(28);
		timeTemp.setTime(LocalTime.of(15, 0));
		timeTemp.setWeatherModel(weather);
		weather.getListTimeTemp().add(timeTemp);
		
		timeTemp = new TimeTempModel();
		timeTemp.setTemparature(22);
		timeTemp.setTime(LocalTime.of(18, 0));
		timeTemp.setWeatherModel(weather);
		weather.getListTimeTemp().add(timeTemp);
		
		timeTemp = new TimeTempModel();
		timeTemp.setTemparature(20);
		timeTemp.setTime(LocalTime.of(21, 0));
		timeTemp.setWeatherModel(weather);
		weather.getListTimeTemp().add(timeTemp);
		
		weatherDao.save(weather);
		
	}
	
	

}
