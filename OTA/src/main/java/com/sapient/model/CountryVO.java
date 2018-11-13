package com.sapient.model;

import java.util.List;

public class CountryVO {
	private Long countryId;

	private String countryName;

	private List<CityVO> listOfCities;

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

	public List<CityVO> getListOfCities() {
		return listOfCities;
	}

	public void setListOfCities(List<CityVO> listOfCities) {
		this.listOfCities = listOfCities;
	}

}
