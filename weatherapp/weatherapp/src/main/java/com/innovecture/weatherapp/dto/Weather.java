package com.innovecture.weatherapp.dto;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {
	
	private String zipCode;
	private LocalDate date;
	@JsonProperty("hourlyTemp")
	private Collection<TimeTemp> listTimeTemp;
	
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<TimeTemp> getListTimeTemp() {
		return (List<TimeTemp>) listTimeTemp;
	}
	public void setListTimeTemp(List<TimeTemp> listTimeTemp) {
		this.listTimeTemp = listTimeTemp;
	}
	
	
}
