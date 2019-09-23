package com.innovecture.weatherapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.innovecture.weatherapp.dao.WeatherDao;
import com.innovecture.weatherapp.service.WeatherService;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherAppController.class)
public class WeatherAppControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private WeatherService weatherService;
	@MockBean
	private WeatherDao weather;
	
	private static final String GET_END_POINT = "/weather";

	@Test
	public void test() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get(GET_END_POINT+"/12345").accept("application/json");
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
