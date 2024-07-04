package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> 
{

}
