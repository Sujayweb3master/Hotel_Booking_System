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

import com.main.model.Room;
import com.main.model.Room;
import com.main.services.RoomService;

@RestController
@RequestMapping("/api/room")
public class RoomController 
{
	@Autowired
	private RoomService roomService;
	
	@PostMapping("/room/input")
	public ResponseEntity<Room> insertData(@RequestBody Room room)
	{
		Room RoomObject = roomService.insertRoomData(room);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(room);
	}
	
	@GetMapping("/Room/{id}")
	public ResponseEntity<Room> getData(@PathVariable Long id)
	{
		return ResponseEntity.ok(roomService.retrieveRoomData(id));
	}
	
	@GetMapping("/Room/all")
	public ResponseEntity<List<Room>> getAllData(@PathVariable Long id)
	{
		return ResponseEntity.ok(roomService.retrieveAllData());
	}
	
	@PutMapping("/Room/{id}")
	public ResponseEntity<Room> updateData(@PathVariable Long id, @RequestBody Room Room)
	{
		return ResponseEntity.ok(roomService.updateRoomData(id, Room));
	}
	
	@DeleteMapping("/Room/{id}")
	public ResponseEntity<Void> deleteData(@PathVariable Long id)
	{
		roomService.deleteRoomData(id);
		return ResponseEntity.noContent().build();
	}
}
