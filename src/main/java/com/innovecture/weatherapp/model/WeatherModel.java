package com.innovecture.weatherapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "weather")
public class WeatherModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "zipcode", nullable = false)
	private String zipCode;

	@Column(name = "local_date", nullable = false)
	private LocalDate date;

	@OneToMany(mappedBy="weatherModel",cascade=CascadeType.ALL)
	private Collection<TimeTempModel> listTimeTemp = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Collection<TimeTempModel> getListTimeTemp() {
		return listTimeTemp;
	}

	public void setListTimeTemp(Collection<TimeTempModel> listTimeTemp) {
		this.listTimeTemp = listTimeTemp;
	}

	

	
	
	
	
}
