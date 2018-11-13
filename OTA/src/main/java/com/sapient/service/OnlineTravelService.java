package com.sapient.service;

import java.util.List;

import com.sapient.exception.AmnetiNotFoundException;
import com.sapient.exception.CityNotFoundException;
import com.sapient.exception.DeleteException;
import com.sapient.exception.InsertException;
import com.sapient.exception.UpdateException;
import com.sapient.exception.HotelNotFoundException;
import com.sapient.exception.HotelNotFoundInCityException;
import com.sapient.model.AmnetiVO;
import com.sapient.model.CityVO;
import com.sapient.model.CountryVO;
import com.sapient.model.HotelVO;

public interface OnlineTravelService {

	public boolean createNewCountry(CountryVO countryVO) throws InsertException;

	public List<CityVO> getAllCitiesOfCountry(String countryName) throws CityNotFoundException;

	public List<HotelVO> getAllHotelsOfCity(String city, String active) throws HotelNotFoundInCityException;

	public List<AmnetiVO> getAllAmnetiesOfHotel(String hotelName) throws AmnetiNotFoundException;

	public List<HotelVO> searchHotelInCityByHotelName(String hotelName) throws HotelNotFoundException;

	public void updateHotelDetails(HotelVO hotelVO) throws UpdateException;

	public void addRemoveAmnetiesForHotel(AmnetiVO amnetiVO) throws DeleteException;
}
