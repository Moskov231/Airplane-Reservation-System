package com.cognizant.flightManagement.model;

public class Passenger {	
	private String passengerName;
	private String passengerGender;
	private int passengerAge;
	private String seatNumber;
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public Passenger(String passengerName, String passengerGender, int passengerAge, String seatNumber) {
		super();
		this.passengerName = passengerName;
		this.passengerGender = passengerGender;
		this.passengerAge = passengerAge;
		this.seatNumber = seatNumber;
	}
	

}
