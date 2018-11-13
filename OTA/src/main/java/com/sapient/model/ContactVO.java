package com.sapient.model;

public class ContactVO {

	private Long contactId;

	private String contactName;
	
	private HotelVO hotelVO;

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public HotelVO getHotelVO() {
		return hotelVO;
	}

	public void setHotelVO(HotelVO hotelVO) {
		this.hotelVO = hotelVO;
	}

}
