package com.cognizant.flightManagement.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.flightManagement.exception.RecordAlreadyPresent;
import com.cognizant.flightManagement.model.Booking;
import com.cognizant.flightManagement.repositories.BookingRepository;
@Service
public class BookingServiceImpl implements BookingService{
	@Autowired
	BookingRepository brepo;
	
	//main function of booking class to book ticket(implemented in front-end)
	@Override
	public ResponseEntity<Booking> createBooking(Booking booking) {
		Optional<Booking> findBookingById = brepo.findById(booking.getBookingId());
		try {
			if (!findBookingById.isPresent()) {
				brepo.save(booking);
				return new ResponseEntity<Booking>(booking, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresent(
						"Booking with Booking Id: " + booking.getBookingId() + " already exists!!");
		} catch (RecordAlreadyPresent e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//service to view all the tickets( no front-end)
	@Override
	public List<Booking> viewTicket() {
		return brepo.findAll();
	}

	//not yet implemented in front-end
	@Override
	public Optional<Booking> viewById(String bookingId) {
		// TODO Auto-generated method stub
		return brepo.findById(bookingId);
	}

}
