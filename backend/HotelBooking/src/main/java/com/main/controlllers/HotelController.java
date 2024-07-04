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

import com.main.model.Hotel;
import com.main.services.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController
{
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/hotel/input")
	public ResponseEntity<Hotel> insertData(@RequestBody Hotel hotel)
	{
		Hotel hotelObject = hotelService.insertHotelData(hotel);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(hotel);
	}
	
	@GetMapping("/hotel/{id}")
	public ResponseEntity<Hotel> getData(@PathVariable Long id)
	{
		return ResponseEntity.ok(hotelService.retrieveHotelData(id));
	}
	
	@GetMapping("/hotel/all")
	public ResponseEntity<List<Hotel>> getAllData(@PathVariable Long id)
	{
		return ResponseEntity.ok(hotelService.retrieveAllData());
	}
	
	@PutMapping("/hotel/{id}")
	public ResponseEntity<Hotel> updateData(@PathVariable Long id, @RequestBody Hotel hotel)
	{
		return ResponseEntity.ok(hotelService.updateHotelData(id, hotel));
	}
	
	@DeleteMapping("/hotel/{id}")
	public ResponseEntity<Void> deleteData(@PathVariable Long id)
	{
		hotelService.deleteHotelData(id);
		return ResponseEntity.noContent().build();
	}
}
