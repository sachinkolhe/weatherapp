package com.innovecture.weatherapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innovecture.weatherapp.model.WeatherModel;

@Repository
public interface WeatherDao extends JpaRepository<WeatherModel, Integer> {

	public Optional<WeatherModel> findByZipCode(String zipCode);
}
