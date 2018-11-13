package com.sapeint.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sapient.controller.OnlineTravelAgentController;
import com.sapient.exception.AmnetiNotFoundException;
import com.sapient.exception.CityNotFoundException;
import com.sapient.exception.HotelNotFoundException;
import com.sapient.exception.HotelNotFoundInCityException;
import com.sapient.service.OnlineTravelService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class OnlineTravelAgentControllerTest {

	private MockMvc mockMvc;

	@Mock
	OnlineTravelService onlineTravelServiceMock;
	
	
	@InjectMocks
	private OnlineTravelAgentController onlineTravelAgentController=new OnlineTravelAgentController();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(onlineTravelAgentController).build();
	}

	/*@Test
	@ExceptionHandler(value = CityNotFoundException.class)
	public void testGetAllCitiesOfCountry() {
		try {
			this.mockMvc.perform(get("/getAllCitiesOfCountry/India")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@ExceptionHandler(value = HotelNotFoundInCityException.class)
	public void testGetAllHotelsOfCity() {
		try {
			this.mockMvc.perform(get("/getAllHotelsOfCity/Bangalore/Y")).andExpect(status().isOk());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@ExceptionHandler(value = HotelNotFoundException.class)
	public void testSearchHotelInCityByHotelName() {
		try {
			this.mockMvc.perform(get("/searchHotelInCityByHotelName/Taj")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@ExceptionHandler(value = AmnetiNotFoundException.class)
	public void testGetAllAmnetiesOfHotel() {
		try {
			this.mockMvc.perform(get("/getAllAmnetiesOfHotel/Taj")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	@Ignore
	@Test
	public void createNewCountry_test() throws Exception {
		this.mockMvc.perform(post("/createNewCountry").contentType(MediaType.APPLICATION_JSON)
				.content("{\"countryName\" : \"India\"}")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].countryId").exists())
		.andExpect(jsonPath("$[0].countryName").exists())
		.andExpect(jsonPath("$[0].countryName").value("India"))
		.andDo(print());
	}
}
