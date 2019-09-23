package com.innovecture.weatherapp.dto;

import java.time.LocalTime;

public class TimeTemp {
	private LocalTime time;
	
	private Integer temperature;
	
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
}
