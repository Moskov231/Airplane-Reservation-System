package com.cognizant.flightManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cognizant.flightManagement.model.Booking;

public interface BookingService {
	public ResponseEntity<Booking> createBooking(Booking newBooking); 
	public List<Booking> viewTicket();
	public Optional<Booking> viewById(String bookingId);
}
