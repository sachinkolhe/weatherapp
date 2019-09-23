package com.innovecture.weatherapp.model;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="time_temp")
public class TimeTempModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "local_time", nullable = false)
	private LocalTime time;

	@Column
	private Integer temperature;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="weather_model_id")
	private WeatherModel weatherModel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Integer getTemparature() {
		return temperature;
	}

	public void setTemparature(Integer temparature) {
		this.temperature = temparature;
	}

	public WeatherModel getWeatherModel() {
		return weatherModel;
	}

	public void setWeatherModel(WeatherModel weatherModel) {
		this.weatherModel = weatherModel;
	}
	
	
}
