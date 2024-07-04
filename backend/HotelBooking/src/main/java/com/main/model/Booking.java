package com.main.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Booking 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private LocalDate bookingDate;
	private double totalCost;
	
	@Enumerated(EnumType.STRING)
	private BookingStatus status;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private User customer;

	 @ManyToOne
	 @JoinColumn(name = "room_id")
	 private Room room; 
}

enum BookingStatus 
{
	    CONFIRMED, CANCELLED, COMPLETED
	
}