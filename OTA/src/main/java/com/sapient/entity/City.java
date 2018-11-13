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
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cityId")
	private Long cityId;

	@Column(name = "cityName")
	private String cityName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cityId")
	private List<Hotel> listOfHotel = new ArrayList<Hotel>();


	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<Hotel> getListOfHotel() {
		return listOfHotel;
	}

	public void setListOfHotel(List<Hotel> listOfHotel) {
		this.listOfHotel = listOfHotel;
	}

}