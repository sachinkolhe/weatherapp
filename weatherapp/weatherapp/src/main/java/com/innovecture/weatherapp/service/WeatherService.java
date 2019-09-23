package com.innovecture.weatherapp.service;

import com.innovecture.weatherapp.dto.Weather;

public interface WeatherService {


	Weather getWeatherDataByZipCode(String zipCode);

}
