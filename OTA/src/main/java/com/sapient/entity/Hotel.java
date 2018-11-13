package com.sapient.entity;

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
@Table(name = "hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hotelId")
	private Long hotelId;

	@Column(name = "HotelName")
	private String hotelName;

	@Column(name = "description")
	private String description;

	@Column(name = "address")
	private String address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotelId")
	private List<Contact> listOfContacts;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotelId")
	private List<Amneti> listOfAmneties;

	@Column(name = "lattitude")
	private String lattitude;

	@Column(name = "longitude")
	private String longitude;

	@Column(name = "active")
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

	public List<Contact> getListOfContacts() {
		return listOfContacts;
	}

	public void setListOfContacts(List<Contact> listOfContacts) {
		this.listOfContacts = listOfContacts;
	}

	public List<Amneti> getListOfAmneties() {
		return listOfAmneties;
	}

	public void setListOfAmneties(List<Amneti> listOfAmneties) {
		this.listOfAmneties = listOfAmneties;
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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	

}