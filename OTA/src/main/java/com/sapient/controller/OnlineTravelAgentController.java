package com.sapient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.exception.AmnetiNotFoundException;
import com.sapient.exception.CityNotFoundException;
import com.sapient.exception.DeleteException;
import com.sapient.exception.HotelNotFoundException;
import com.sapient.exception.HotelNotFoundInCityException;
import com.sapient.exception.InsertException;
import com.sapient.exception.UpdateException;
import com.sapient.model.AmnetiVO;
import com.sapient.model.CityVO;
import com.sapient.model.CountryVO;
import com.sapient.model.HotelVO;
import com.sapient.service.OnlineTravelService;

@RestController
public class OnlineTravelAgentController {

	@Autowired
	OnlineTravelService onlineTravelService;

	@RequestMapping(value = "/createNewCountry")
	public boolean createNewCountry(@RequestBody CountryVO countryVO) throws InsertException{
		return onlineTravelService.createNewCountry(countryVO);
	}

	@RequestMapping(value = "/getAllCitiesOfCountry/{countryName}")
	public List<CityVO> getAllCitiesOfCountry(@PathVariable String countryName) throws CityNotFoundException {
		return onlineTravelService.getAllCitiesOfCountry(countryName);
	}

	@RequestMapping(value = "/getAllHotelsOfCity/{cityName}/{active}")
	public List<HotelVO> getAllHotelsOfCity(@PathVariable String cityName, @PathVariable String active)
			throws HotelNotFoundInCityException {
		return onlineTravelService.getAllHotelsOfCity(cityName, active);
	}

	@RequestMapping(value = "/getAllAmnetiesOfHotel/{hotelName}")
	public List<AmnetiVO> getAllAmnetiesOfHotel(@PathVariable String hotelName) throws AmnetiNotFoundException {
		return onlineTravelService.getAllAmnetiesOfHotel(hotelName);
	}

	@RequestMapping(value = "/searchHotelInCityByHotelName/{hotelName}")
	public List<HotelVO> searchHotelInCityByHotelName(@PathVariable String hotelName) throws HotelNotFoundException {
		return onlineTravelService.searchHotelInCityByHotelName(hotelName);
	}

	@RequestMapping(value = "/updateHotelDetails", method = RequestMethod.PUT)
	public void updateHotelDetails(@RequestBody HotelVO hotelVO) throws UpdateException {
		onlineTravelService.updateHotelDetails(hotelVO);
	}

	@RequestMapping(value = "/addRemoveAmnetiesForHotel", method = RequestMethod.DELETE)
	public void addRemoveAmnetiesForHotel(@RequestBody AmnetiVO amnetiVO) throws DeleteException {
		onlineTravelService.addRemoveAmnetiesForHotel(amnetiVO);
	}
	
	@ExceptionHandler(value=Exception.class)
	public void handleException() {
		System.out.println("exception occured");
	}
}
