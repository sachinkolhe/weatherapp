package com.innovecture.weatherapp.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovecture.weatherapp.dao.WeatherDao;
import com.innovecture.weatherapp.dto.Weather;
import com.innovecture.weatherapp.exception.ZipcodeNotFoundException;
import com.innovecture.weatherapp.helper.ValidationHelper;
import com.innovecture.weatherapp.model.WeatherModel;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherDao weatherDao;

	@Autowired
	private ModelMapper modelMapper;

	
	@Override
	public Weather getWeatherDataByZipCode(String zipCode) {

		ValidationHelper.validateZipCode(zipCode);
		Optional<WeatherModel> weatherModel = weatherDao.findByZipCode(zipCode);
		if (!weatherModel.isPresent()) {
			throw new ZipcodeNotFoundException(String.format("Zipcode %s Not Found.", zipCode));
		}
		return modelMapper.map(weatherModel.get(), Weather.class);

	}

}
