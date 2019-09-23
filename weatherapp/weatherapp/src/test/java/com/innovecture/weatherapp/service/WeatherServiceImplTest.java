package com.innovecture.weatherapp.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.innovecture.weatherapp.dao.WeatherDao;
import com.innovecture.weatherapp.dto.Weather;
import com.innovecture.weatherapp.exception.ValidationException;
import com.innovecture.weatherapp.exception.ZipcodeNotFoundException;
import com.innovecture.weatherapp.model.WeatherModel;

public class WeatherServiceImplTest {

	@InjectMocks
	private WeatherServiceImpl weatherService;
	
	@Mock
	private WeatherDao weatherDao;
	
	@Mock
	private ModelMapper modelMapper;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	
	}

	@Test(expected=ValidationException.class)
	public void testGetWeatherDataByZipCodeValidationException() {
		String zipCode = "123456";
		weatherService.getWeatherDataByZipCode(zipCode);
	}
	
	@Test(expected=ZipcodeNotFoundException.class)
	public void testGetWeatherDataByZipCodeNotFoundException() {
		String zipCode = "12345";
		Optional<WeatherModel> weatherModel = Optional.empty();
		Mockito.when(weatherDao.findByZipCode(zipCode)).thenReturn(weatherModel);
		weatherService.getWeatherDataByZipCode(zipCode);
	}
	
	@Test
	public void testGetWeatherDataByZipCode() {
		String zipCode = "12345";
		
		WeatherModel weatherModel2 = new WeatherModel();
		Optional<WeatherModel> weatherModel = Optional.of(weatherModel2 );
		Mockito.when(weatherDao.findByZipCode(zipCode)).thenReturn(weatherModel);
		Weather expected = new Weather();
		Mockito.when(modelMapper.map(weatherModel.get(), Weather.class)).thenReturn(expected);
		Weather actual = weatherService.getWeatherDataByZipCode(zipCode);
		assertEquals(expected, actual);
	}

}
