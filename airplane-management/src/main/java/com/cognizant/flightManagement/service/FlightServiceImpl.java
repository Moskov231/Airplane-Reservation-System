package com.cognizant.flightManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.flightManagement.exception.RecordAlreadyPresent;
import com.cognizant.flightManagement.exception.RecordNotFoundException;
import com.cognizant.flightManagement.model.Flight;
import com.cognizant.flightManagement.repositories.FlightRepository;
@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	FlightRepository repo;
	@Autowired
	Optional<Flight> flight;
	@Override
	public List<Flight> viewFlights() {
		return repo.findAll();
	}
	public Optional<Flight> flightById(String flightId) {
		return repo.findById(flightId);
	}
	@Override
	public ResponseEntity<?> addFlight(Flight flight) {
		Optional<Flight> findById = repo.findById(flight.getFlightId());
		try {
		if (!findById.isPresent()) {
			repo.save(flight);
			return new ResponseEntity<Flight>(flight,HttpStatus.OK);
		} else
			throw new RecordAlreadyPresent("Flight with number: " + flight.getFlightId() + " already present");
	}
		catch(RecordAlreadyPresent e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	/*
	 * public Flight addFlight(Flight flight) { return repo.save(flight); }
	 */
	@Override
	public List<Flight> getFlights(String flightSource, String flightDestination, String journeyDate) {
		List<Flight> flights = repo.findByFlightSourceAndFlightDestinationAndJourneyDate(flightSource, flightDestination, journeyDate);
		if(flights!=null) {
			return flights;
		}else {
			throw new RecordNotFoundException("No flights Available");
		}
		
	}
	@Override
	public void deleteFlight(String flightId) {
		repo.deleteById(flightId);
		
	}
	@Override
	public ResponseEntity<Object> updateSeats(Flight flight,String flightId, int bookedSeat) {
		Optional<Flight> flightrepo = repo.findById(flightId);
		if(!flightrepo.isPresent())
			return ResponseEntity.notFound().build();
		int oldSeats= flight.getSeatCapacity();
		System.out.println(oldSeats);
		int newSeats= oldSeats-bookedSeat;
		flight.setSeatCapacity(newSeats);
		repo.save(flight);
		return ResponseEntity.noContent().build();
	}
	
	
	

}
