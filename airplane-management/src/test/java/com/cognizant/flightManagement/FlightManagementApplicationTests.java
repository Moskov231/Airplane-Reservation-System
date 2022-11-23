package com.cognizant.flightManagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.cognizant.flightManagement.model.Flight;
import com.cognizant.flightManagement.model.Booking;
import com.cognizant.flightManagement.model.Passenger;
import com.cognizant.flightManagement.repositories.BookingRepository;
import com.cognizant.flightManagement.repositories.FlightRepository;
import com.cognizant.flightManagement.service.FlightService;

@SpringBootTest
class FlightManagementApplicationTests {
	@Autowired
	BookingRepository brepo;
	@Autowired
	FlightRepository repo;
	
	//TestCases for addFlight Method
	@Test
	public void testAddFlight() {
		 Flight flight = new Flight("F12345","Air-INDIA 453","Gwalior","Banglore",231,"4:30","13-10-2022", "13:00","17:30",4400);
		 repo.save(flight);
		 Optional<Flight> flight2 = repo.findById(flight.getFlightId());
		 String id = flight2.get().getFlightId();
		 String source = flight2.get().getFlightSource();
		 int seat = flight2.get().getSeatCapacity();
		 assertEquals(id,"F12345");
		 assertEquals(source,"Gwalior");
		 assertEquals(seat,231);
		 deleteFlight(flight2, id);
		 }

	private void deleteFlight(Optional<Flight> flight2, String id) {
		repo.deleteById(id);
		 Optional<Flight> flight3 = repo.findById(flight2.get().getFlightId());
		 Boolean flag = flight3.isPresent();
		 assertFalse(flag);
	}
	
	//Test Cases for searching Functionality
	@Test
	public void testSearchMethod() {
		Flight flight = new Flight("F12345","Air-INDIA 453","Gwalior","Banglore",231,"4:30","13-10-2022", "13:00","17:30",4400);
		 repo.save(flight);
		 List<Flight> flight2 = repo.findByFlightSourceAndFlightDestinationAndJourneyDate("Gwalior", "Banglore", "13-10-2022");
		 assertThat(flight2).isNotEmpty();
		 Optional<Flight> flight3 = repo.findById(flight.getFlightId());
		 String id = flight3.get().getFlightId();
		 deleteFlight(flight3, id);
	}
	
	//Test case for single user booking
	@Test
	public void testSingleBooking() {
		 Flight flight = new Flight("F12345","Air-INDIA 453","Gwalior","Banglore",231,"4:30","13-10-2022","13:00","17:30",4400); 
		Passenger pass = new Passenger("Prateek","Male",23,"S2"); 
		List<Passenger> list = new ArrayList<Passenger>(); 
		list.add(pass); 
		Booking booking = new Booking("T23134","23-10-2022",flight,list,(float) 4300.00);
		brepo.save(booking);
		Optional<Booking> booking1 = brepo.findById(booking.getBookingId());
		String id = booking1.get().getBookingId();
		Iterable<Passenger> pass2 = booking1.get().getPassengers();
		Iterator<Passenger> iterator = pass2.iterator();
		if(iterator.hasNext()) {
			Passenger passenger = iterator.next();
			String name = passenger.getPassengerName();
			assertEquals(name,"Prateek");
		}
		assertEquals(id,"T23134");
		brepo.deleteById(id);
	}
	
	//Test case for multiple users
	@Test
	public void testMultipleBooking() {
		Flight flight = new Flight("F12345","Air-INDIA 453","Gwalior","Banglore",231,"4:30","13-10-2022","13:00","17:30",4400); 
		Passenger pass = new Passenger("Prateek","Male",23,"S2");
		Passenger pass2 = new Passenger("Ashish","Male",22,"S1");
		List<Passenger> list = new ArrayList<Passenger>(); 
		list.add(pass);
		list.add(pass2);
		Booking booking = new Booking("T23134","23-10-2022",flight,list,(float) 4300.00);
		brepo.save(booking);
		Optional<Booking> booking1 = brepo.findById(booking.getBookingId());
		boolean Flag = booking1.isPresent();
		assertTrue(Flag);
		brepo.deleteById("T23134");
	}
	
	/*
	 * @Test public void testFlightMethod() { Flight flight = new
	 * Flight("F12345","Air-INDIA 453","Gwalior","Banglore",231,"4:30","13-10-2022",
	 * "13:00","17:30",4400); assertEquals("F12345",flight.getFlightId());
	 * assertEquals("Air-INDIA 453",flight.getFlightCarrier());
	 * assertEquals("Gwalior",flight.getFlightSource());
	 * 
	 * }
	 */
	
	/*
	 * @Test public void testTicketMethod() { Flight flight = new
	 * Flight("F12345","Air-INDIA 453","Gwalior","Banglore",231,"4:30","13-10-2022",
	 * "13:00","17:30",4400); Passenger pass = new
	 * Passenger("Prateek","Male",23,"S2"); List<Passenger> list = new
	 * ArrayList<Passenger>(); list.add(pass); Booking booking = new
	 * Booking("T23134","23-10-2022",flight,list,(float) 4300.00); Booking booking2
	 * = new Booking("T12314","23-10-2022",flight,list,(float)4300.00);
	 * assertNotNull(booking); assertFalse(booking.equals(booking2)); }
	 */
	 
}
