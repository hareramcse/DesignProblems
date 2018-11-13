package com.sapient.model;

import java.util.List;

public class CityVO {
	private Long cityId;

	private String name;

	private List<HotelVO> listOfHotel;
	
	private CountryVO countryVO;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<HotelVO> getListOfHotel() {
		return listOfHotel;
	}

	public void setListOfHotel(List<HotelVO> listOfHotel) {
		this.listOfHotel = listOfHotel;
	}

	public CountryVO getCountryVO() {
		return countryVO;
	}

	public void setCountryVO(CountryVO countryVO) {
		this.countryVO = countryVO;
	}

}
