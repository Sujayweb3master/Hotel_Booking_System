package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> 
{

}
