package com.sapient.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sapient.entity.Amneti;
import com.sapient.entity.City;
import com.sapient.entity.Contact;
import com.sapient.entity.Country;
import com.sapient.entity.Hotel;
import com.sapient.exception.AmnetiNotFoundException;
import com.sapient.exception.CityNotFoundException;
import com.sapient.exception.DeleteException;
import com.sapient.exception.InsertException;
import com.sapient.exception.UpdateException;
import com.sapient.exception.HotelNotFoundException;
import com.sapient.exception.HotelNotFoundInCityException;
import com.sapient.model.AmnetiVO;
import com.sapient.model.CityVO;
import com.sapient.model.ContactVO;
import com.sapient.model.CountryVO;
import com.sapient.model.HotelVO;

public class OnlineTravelAgentDAOImpl implements OnlineTravelAgentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean createNewCountry(CountryVO countryVO) throws InsertException {
		boolean bool = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Country country = new Country();
		country.setCountryName(countryVO.getCountryName());
		List<City> cityList = new ArrayList<City>();
		List<Hotel> hotelList = new ArrayList<Hotel>();
		List<Amneti> amnetiList = new ArrayList<Amneti>();
		List<Contact> contactList = new ArrayList<Contact>();
		for (CityVO cityVO : countryVO.getListOfCities()) {
			City city = new City();
			city.setCityId(cityVO.getCityId());
			city.setCityName(cityVO.getName());
			for (HotelVO hotelVO : cityVO.getListOfHotel()) {
				Hotel hotel = new Hotel();
				hotel.setHotelId(hotelVO.getHotelId());
				hotel.setAddress(hotelVO.getAddress());
				hotel.setDescription(hotelVO.getDescription());
				hotel.setHotelName(hotelVO.getHotelName());
				hotel.setLattitude(hotelVO.getLattitude());
				hotel.setLongitude(hotelVO.getLongitude());
				hotel.setActive(hotelVO.getActive());

				for (AmnetiVO amnetiVO : hotelVO.getListOfAmneties()) {
					Amneti amneti = new Amneti();
					amneti.setAmnetiId(amnetiVO.getAmnetiId());
					amneti.setAmnetiName(amnetiVO.getAmnetiName());
					amnetiList.add(amneti);
				}
				hotel.setListOfAmneties(amnetiList);

				for (ContactVO contactVO : hotelVO.getListOfContacts()) {
					Contact contact = new Contact();
					contact.setContactId(contactVO.getContactId());
					contact.setContactName(contactVO.getContactName());
					contactList.add(contact);
				}
				hotel.setListOfContacts(contactList);
				hotelList.add(hotel);
			}
			city.setListOfHotel(hotelList);
			cityList.add(city);
		}
		country.setListOfCities(cityList);

		session.save(country);
		bool = true;
		transaction.commit();
		session.close();
		return bool;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CityVO> getAllCitiesOfCountry(String countryName) throws CityNotFoundException {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String sql = "select c.listOfCities from Country c join c.listOfCities d where c.countryName=:countryName";
		Query query = (Query) session.createQuery(sql);
		query.setParameter("countryName", countryName);
		List<City> cityList = query.list();

		if (cityList == null || cityList.size() == 0) {
			throw new CityNotFoundException();
		}

		List<CityVO> cityVOList = new ArrayList<CityVO>();
		List<AmnetiVO> amnetiVOList = new ArrayList<AmnetiVO>();
		List<ContactVO> contactVOList = new ArrayList<ContactVO>();
		List<HotelVO> hotelVOList = new ArrayList<HotelVO>();
		for (City city : cityList) {
			CityVO cityVO = new CityVO();
			cityVO.setName(city.getCityName());

			for (Hotel hotel : city.getListOfHotel()) {
				HotelVO hotelVO = new HotelVO();
				hotelVO.setAddress(hotel.getAddress());
				hotelVO.setDescription(hotel.getDescription());
				hotelVO.setHotelName(hotel.getHotelName());
				hotelVO.setLattitude(hotel.getLattitude());
				hotelVO.setLongitude(hotel.getLongitude());
				hotelVO.setActive(hotel.getActive());

				for (Amneti amneti : hotel.getListOfAmneties()) {
					AmnetiVO amnetiVO = new AmnetiVO();
					amnetiVO.setAmnetiName(amneti.getAmnetiName());
					amnetiVOList.add(amnetiVO);
				}
				hotelVO.setListOfAmneties(amnetiVOList);

				for (Contact contact : hotel.getListOfContacts()) {
					ContactVO contactVO = new ContactVO();
					contactVO.setContactName(contact.getContactName());
					contactVOList.add(contactVO);
				}
				hotelVO.setListOfContacts(contactVOList);
				hotelVOList.add(hotelVO);
			}
			cityVOList.add(cityVO);
		}
		transaction.commit();
		session.close();
		return cityVOList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HotelVO> getAllHotelsOfCity(String cityName, String active) throws HotelNotFoundInCityException {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String sql = "select c.listOfHotel from City c join c.listOfHotel where c.cityName=:cityName and active=:active";
		Query query = (Query) session.createQuery(sql);
		query.setParameter("cityName", cityName);
		query.setParameter("active", active);
		List<Hotel> hotelList = query.list();

		if (hotelList == null || hotelList.size() == 0) {
			throw new HotelNotFoundInCityException();
		}

		List<HotelVO> hotelVOList = new ArrayList<HotelVO>();
		List<AmnetiVO> amnetiVOList = new ArrayList<AmnetiVO>();
		List<ContactVO> contactVOList = new ArrayList<ContactVO>();
		for (Hotel hotel : hotelList) {
			HotelVO hotelVO = new HotelVO();
			hotelVO.setAddress(hotel.getAddress());
			hotelVO.setDescription(hotel.getDescription());
			hotelVO.setHotelName(hotel.getHotelName());
			hotelVO.setLattitude(hotel.getLattitude());
			hotelVO.setLongitude(hotel.getLongitude());
			hotelVO.setActive(hotel.getActive());

			for (Amneti amneti : hotel.getListOfAmneties()) {
				AmnetiVO amnetiVO = new AmnetiVO();
				amnetiVO.setAmnetiName(amneti.getAmnetiName());
				amnetiVOList.add(amnetiVO);
			}
			hotelVO.setListOfAmneties(amnetiVOList);

			for (Contact contact : hotel.getListOfContacts()) {
				ContactVO contactVO = new ContactVO();
				contactVO.setContactName(contact.getContactName());
				contactVOList.add(contactVO);
			}
			hotelVO.setListOfContacts(contactVOList);
			hotelVOList.add(hotelVO);
		}
		transaction.commit();
		session.close();
		return hotelVOList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AmnetiVO> getAllAmnetiesOfHotel(String hotelName) throws AmnetiNotFoundException {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String sql = "select h.listOfAmneties from Hotel h join h.listOfAmneties where h.hotelName=:hotelName";
		Query query = (Query) session.createQuery(sql);
		query.setParameter("hotelName", hotelName);
		List<Amneti> amnetiList = query.list();

		if (amnetiList == null || amnetiList.size() == 0) {
			throw new AmnetiNotFoundException();
		}

		List<AmnetiVO> AmnetiVOList = new ArrayList<AmnetiVO>();
		for (Amneti amneti : amnetiList) {
			AmnetiVO amnetiVO = new AmnetiVO();
			amnetiVO.setAmnetiName(amneti.getAmnetiName());
			AmnetiVOList.add(amnetiVO);
		}
		transaction.commit();
		session.close();
		return AmnetiVOList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HotelVO> searchHotelInCityByHotelName(String hotelName) throws HotelNotFoundException {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String sql = "select c.listOfHotel from City c join c.listOfHotel where hotelName=:hotelName";
		Query query = (Query) session.createQuery(sql);
		query.setParameter("hotelName", hotelName);
		List<Hotel> hotelList = query.list();

		if (hotelList == null || hotelList.size() == 0) {
			throw new HotelNotFoundException();
		}
		List<HotelVO> hotelVOList = new ArrayList<HotelVO>();
		List<AmnetiVO> amnetiVOList = new ArrayList<AmnetiVO>();
		List<ContactVO> contactVOList = new ArrayList<ContactVO>();
		for (Hotel hotel : hotelList) {
			HotelVO hotelVO = new HotelVO();
			hotelVO.setAddress(hotel.getAddress());
			hotelVO.setDescription(hotel.getDescription());
			hotelVO.setHotelName(hotel.getHotelName());
			hotelVO.setLattitude(hotel.getLattitude());
			hotelVO.setActive(hotel.getActive());
			for (Amneti amneti : hotel.getListOfAmneties()) {
				AmnetiVO amnetiVO = new AmnetiVO();
				amnetiVO.setAmnetiName(amneti.getAmnetiName());
				amnetiVOList.add(amnetiVO);
			}
			hotelVO.setListOfAmneties(amnetiVOList);

			for (Contact contact : hotel.getListOfContacts()) {
				ContactVO contactVO = new ContactVO();
				contactVO.setContactName(contact.getContactName());
				contactVOList.add(contactVO);
			}
			hotelVO.setListOfContacts(contactVOList);
			hotelVO.setLongitude(hotel.getLongitude());
			hotelVOList.add(hotelVO);
		}
		transaction.commit();
		session.close();
		return hotelVOList;
	}

	@Override
	public void updateHotelDetails(HotelVO hotelVO) throws UpdateException {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Hotel hotel = new Hotel();
		hotel.setHotelId(hotelVO.getHotelId());
		hotel.setDescription(hotelVO.getDescription());
		hotel.setHotelName(hotelVO.getHotelName());
		session.update(hotel);
		transaction.commit();
		session.close();
	}

	@Override
	public void addRemoveAmnetiesForHotel(AmnetiVO amnetiVO) throws DeleteException {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Amneti amneti = (Amneti) session.get(Amneti.class, amnetiVO.getAmnetiId());
		session.delete(amneti);
		transaction.commit();
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
