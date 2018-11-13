package com.sapient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sapient.dao.OnlineTravelAgentDAO;
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

public class OnlineTravleServiceImpl implements OnlineTravelService {

	@Autowired
	OnlineTravelAgentDAO onlineTravelAgentDAO;

	@Override
	public boolean createNewCountry(CountryVO countryVO) throws InsertException {
		return onlineTravelAgentDAO.createNewCountry(countryVO);
	}

	@Override
	public List<CityVO> getAllCitiesOfCountry(String countryName) throws CityNotFoundException {
		return onlineTravelAgentDAO.getAllCitiesOfCountry(countryName);
	}

	@Override
	public List<HotelVO> getAllHotelsOfCity(String city, String active) throws HotelNotFoundInCityException {
		return onlineTravelAgentDAO.getAllHotelsOfCity(city, active);
	}

	@Override
	public List<AmnetiVO> getAllAmnetiesOfHotel(String hotelName) throws AmnetiNotFoundException {
		return onlineTravelAgentDAO.getAllAmnetiesOfHotel(hotelName);
	}

	@Override
	public List<HotelVO> searchHotelInCityByHotelName(String hotelName) throws HotelNotFoundException {
		return onlineTravelAgentDAO.searchHotelInCityByHotelName(hotelName);
	}

	@Override
	public void updateHotelDetails(HotelVO hotelVO) throws UpdateException {
		onlineTravelAgentDAO.updateHotelDetails(hotelVO);
	}

	@Override
	public void addRemoveAmnetiesForHotel(AmnetiVO amnetiVO) throws DeleteException {
		onlineTravelAgentDAO.addRemoveAmnetiesForHotel(amnetiVO);
	}

}
