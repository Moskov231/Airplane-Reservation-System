package com.cognizant.flightManagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Booking")
public class Booking {

	@Id private String bookingId;
	private String bookingDate;
	Flight flight;
	Iterable<Passenger> passengers ;
	private float price;
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Iterable<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(Iterable<Passenger> passengers) {
		this.passengers = passengers;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Booking(String bookingId, String bookingDate, Flight flight, Iterable<Passenger> passengers, float price) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.flight = flight;
		this.passengers = passengers;
		this.price = price;
	}
	
	
	
}
