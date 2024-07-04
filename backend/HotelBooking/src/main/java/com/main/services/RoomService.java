package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.RoomRepository;
import com.main.model.Room;

@Service
public class RoomService 
{
	@Autowired
	private RoomRepository RoomRepo;
	
	public Room insertRoomData(Room room)
	{
		return RoomRepo.save(room);
	}
	
	public Room retrieveRoomData(Long id)
	{
		return RoomRepo.findById(id).get();
	}
	
	public List<Room> retrieveAllData()
	{
		return RoomRepo.findAll();
	}
	
	public Room updateRoomData(Long id, Room room)
	{
		Room oldRoom = RoomRepo.findById(id).get();
		oldRoom.setType(room.getType());
		oldRoom.setAvailability(room.getAvailability());
		oldRoom.setPrice(room.getPrice());
		oldRoom.setImages(room.getImages());
		
		return RoomRepo.save(oldRoom);
	}
	
	public void deleteRoomData(Long id)
	{
		RoomRepo.deleteById(id);
	}
}
