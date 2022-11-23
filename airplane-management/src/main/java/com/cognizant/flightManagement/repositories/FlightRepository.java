package com.cognizant.flightManagement.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cognizant.flightManagement.model.Flight;

public interface FlightRepository extends MongoRepository<Flight, String> {
	List<Flight> findByFlightSourceAndFlightDestinationAndJourneyDate(String flightSource, String flightDestination,
			String journeyDate);
}
