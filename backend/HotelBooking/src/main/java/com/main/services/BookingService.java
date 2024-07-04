package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.BookingRepository;
import com.main.model.Booking;

@Service
public class BookingService 
{
	@Autowired
	private BookingRepository bookRepo;
	
	public Booking insertBookingData(Booking booking)
	{
		return bookRepo.save(booking);
	}
	
	public Booking retrieveBookingData(Long id)
	{
		return bookRepo.findById(id).get();
	}
	
	public List<Booking> retrieveAllData()
	{
		return bookRepo.findAll();
	}
	
	public Booking updateBookingData(Long id, Booking booking)
	{
		Booking oldBooking = bookRepo.findById(id).get();
		
		oldBooking.setCheckInDate(booking.getCheckInDate());
		oldBooking.setCheckOutDate(booking.getCheckOutDate());
		oldBooking.setBookingDate(booking.getBookingDate());
		oldBooking.setTotalCost(booking.getTotalCost());
		oldBooking.setStatus(booking.getStatus());
		
		return bookRepo.save(oldBooking); 
	}
	
	public void deleteBookingData(Long id)
	{
		bookRepo.deleteById(id);
	}
}
