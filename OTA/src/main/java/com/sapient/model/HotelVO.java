package com.sapient.model;

import java.util.List;

public class HotelVO {
	private Long hotelId;

	private String hotelName;

	private String description;

	private String address;

	private List<ContactVO> listOfContacts;

	private CityVO cityVO;

	private CountryVO countryVO;

	private List<AmnetiVO> listOfAmneties;

	private String lattitude;

	private String longitude;

	private String active;

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public List<ContactVO> getListOfContacts() {
		return listOfContacts;
	}

	public void setListOfContacts(List<ContactVO> listOfContacts) {
		this.listOfContacts = listOfContacts;
	}

	public List<AmnetiVO> getListOfAmneties() {
		return listOfAmneties;
	}

	public void setListOfAmneties(List<AmnetiVO> listOfAmneties) {
		this.listOfAmneties = listOfAmneties;
	}

	public CityVO getCityVO() {
		return cityVO;
	}

	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}

	public CountryVO getCountryVO() {
		return countryVO;
	}

	public void setCountryVO(CountryVO countryVO) {
		this.countryVO = countryVO;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getActive() {
		return active;
	}

}
