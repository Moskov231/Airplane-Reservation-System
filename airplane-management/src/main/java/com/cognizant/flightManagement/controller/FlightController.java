package com.cognizant.flightManagement.controller;


import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.flightManagement.model.Flight;
import com.cognizant.flightManagement.service.FlightService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class FlightController {
	Logger logger=org.slf4j.LoggerFactory.getLogger(FlightController.class);
	@Autowired
	FlightService fservice;
	//API for Searching all Flights
	@GetMapping("/allFlight")
	public List<Flight> viewFlight(){
		logger.info("Flights are displayed");
		return fservice.viewFlights();
	}
	//API for Adding New Flight to database
	@PostMapping("addFlight")
	public String addFlight(@RequestBody Flight flight) {
		fservice.addFlight(flight);
		logger.info("Flights are added to the database");
		return "Flight Added";
	}
	//API for deleting Flight from database
	@DeleteMapping("/deleteFlight/{flightId}")
	public String deleteFlight(@PathVariable String flightId) {
		logger.info("Flight has been deleted from database");
		fservice.deleteFlight(flightId);
		return "Flight has been deleted "+flightId;
	}
	//API to get flight for journey (Main API to be called from front-end)
	@GetMapping("/journey")
	public List<Flight> getFlights(@RequestParam String flightSource,@RequestParam String flightDestination,@RequestParam String journeyDate){
		return fservice.getFlights(flightSource,flightDestination,journeyDate);
	}
	@PutMapping("/updateSeats/{flightId}")
	public ResponseEntity<Object> updateSeat(@RequestBody Flight flight, @PathVariable String flightId, @RequestParam int bookedSeat){
		logger.info("Seats updated");
		return fservice.updateSeats(flight,flightId,bookedSeat);
	}
}
