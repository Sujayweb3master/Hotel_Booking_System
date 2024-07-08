package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.main.dao.HotelRepository;
import com.main.dao.UserRepository;
import com.main.model.Hotel;

@RestController
public class HotelService 
{
	@Autowired
	private HotelRepository hotelRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public Hotel insertHotelData(Hotel hotel)
	{
		return hotelRepo.save(hotel);
	}
	
	public Hotel retrieveHotelData(Long id)
	{
		return hotelRepo.findById(id).get();
	}
	
	public List<Hotel> retrieveAllData()
	{
		return hotelRepo.findAll();
	}
	
	public Hotel updateHotelData(Long id, Hotel hotel)
	{
		Hotel oldObject = hotelRepo.findById(id).get();
		oldObject.setName(hotel.getName());
		oldObject.setAddress(hotel.getAddress());
		oldObject.setAmenities(hotel.getAmenities());
		oldObject.setContactInfo(hotel.getContactInfo());
		oldObject.setDescription(hotel.getDescription());
		
		return hotelRepo.save(oldObject);
	}
	
	public void deleteHotelData(Long id)
	{
		hotelRepo.deleteById(id);
	}
}
