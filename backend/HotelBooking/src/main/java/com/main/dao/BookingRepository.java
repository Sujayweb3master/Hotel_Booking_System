package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>
{

}
