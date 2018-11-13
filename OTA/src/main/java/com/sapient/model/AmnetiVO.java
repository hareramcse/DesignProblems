package com.sapient.model;

public class AmnetiVO {
	private Long amnetiId;

	private String amnetiName;

	private HotelVO hotelVO;

	public Long getAmnetiId() {
		return amnetiId;
	}

	public void setAmnetiId(Long amnetiId) {
		this.amnetiId = amnetiId;
	}

	public HotelVO getHotelVO() {
		return hotelVO;
	}

	public void setHotelVO(HotelVO hotelVO) {
		this.hotelVO = hotelVO;
	}

	public String getAmnetiName() {
		return amnetiName;
	}

	public void setAmnetiName(String amnetiName) {
		this.amnetiName = amnetiName;
	}
}
