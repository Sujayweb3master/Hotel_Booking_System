package com.main.controlllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Booking;
import com.main.services.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController 
{
	@Autowired
	private BookingService bookingService;
	

	@PostMapping("/room/input")
	public ResponseEntity<Booking> insertData(@RequestBody Booking room)
	{
		Booking BookingObject = bookingService.insertBookingData(room);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(room);
	}
	
	@GetMapping("/Booking/{id}")
	public ResponseEntity<Booking> getData(@PathVariable Long id)
	{
		return ResponseEntity.ok(bookingService.retrieveBookingData(id));
	}
	
	@GetMapping("/Booking/all")
	public ResponseEntity<List<Booking>> getAllData(@PathVariable Long id)
	{
		return ResponseEntity.ok(bookingService.retrieveAllData());
	}
	
	@PutMapping("/Booking/{id}")
	public ResponseEntity<Booking> updateData(@PathVariable Long id, @RequestBody Booking Booking)
	{
		return ResponseEntity.ok(bookingService.updateBookingData(id, Booking));
	}
	
	@DeleteMapping("/Booking/{id}")
	public ResponseEntity<Void> deleteData(@PathVariable Long id)
	{
		bookingService.deleteBookingData(id);
		return ResponseEntity.noContent().build();
	}
}
