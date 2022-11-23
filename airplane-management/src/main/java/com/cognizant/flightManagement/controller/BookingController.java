package com.cognizant.flightManagement.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.flightManagement.model.Booking;
import com.cognizant.flightManagement.service.BookingService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class BookingController {
	Logger logger=org.slf4j.LoggerFactory.getLogger(BookingController.class);
	@Autowired
	BookingService bservice;
	
	//bookTicket API for booking ticket
	@PostMapping("/bookTicket")
	public void bookTicket(@RequestBody Booking booking) {
		bservice.createBooking(booking);
		logger.info("Ticket added to the database");
	}
	
	//viewTicket API to fetch all the tickets
	@GetMapping("/viewTicket")
	public List<Booking> viewTicket() {
		logger.info("All tickets fetched");
		return bservice.viewTicket();
	}
	
	//To search a ticket using bookingId
	@GetMapping("/viewById")
	public Optional<Booking> viewById(@RequestParam String bookingId) {
		logger.info("Ticket Using ID is fetched");
		return bservice.viewById(bookingId);
	}
	
	
	
}
