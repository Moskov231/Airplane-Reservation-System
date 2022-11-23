package com.cognizant.flightManagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cognizant.flightManagement.model.Flight;

public interface FlightService {
	public List<Flight> viewFlights();
	public ResponseEntity<?> addFlight(Flight flight);
	public List<Flight> getFlights(String flightSource, String flightDestination, String journeyDate);
	public void deleteFlight(String flightId);
	public ResponseEntity<Object> updateSeats(Flight flight, String flightId, int bookedSeat);
	
	
}
