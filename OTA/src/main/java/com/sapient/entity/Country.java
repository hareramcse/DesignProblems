package com.sapient.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "countryId")
	private Long countryId;

	@Column(name = "countryName")
	private String countryName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="countryId")
	private List<City> listOfCities = new ArrayList<City>();

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<City> getListOfCities() {
		return listOfCities;
	}

	public void setListOfCities(List<City> listOfCities) {
		this.listOfCities = listOfCities;
	}

}