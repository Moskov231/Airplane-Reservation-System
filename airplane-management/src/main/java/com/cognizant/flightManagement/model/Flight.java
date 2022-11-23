package com.cognizant.flightManagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "Flight")
public class Flight {
	@MongoId
	@Id private String flightId;
	private String flightCarrier;
	private String flightSource;
	private String flightDestination;
	private int seatCapacity;
	private String duration;
	private String journeyDate;
	private String departure;
	private String reach;
	private float fare;

	
	
	public float getFare() {
		return fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getFlightCarrier() {
		return flightCarrier;
	}
	public void setFlightCarrier(String flightCarrier) {
		this.flightCarrier = flightCarrier;
	}
	public String getFlightSource() {
		return flightSource;
	}
	public void setFlightSource(String flightSource) {
		this.flightSource = flightSource;
	}
	public String getFlightDestination() {
		return flightDestination;
	}
	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getReach() {
		return reach;
	}
	public void setReach(String reach) {
		this.reach = reach;
	}
	public Flight(String flightId, String flightCarrier, String flightSource, String flightDestination,
			int seatCapacity, String duration, String journeyDate, String departure, String reach, float fare) {
		super();
		this.flightId = flightId;
		this.flightCarrier = flightCarrier;
		this.flightSource = flightSource;
		this.flightDestination = flightDestination;
		this.seatCapacity = seatCapacity;
		this.duration = duration;
		this.journeyDate = journeyDate;
		this.departure = departure;
		this.reach = reach;
		this.fare = fare;
		
	}
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightCarrier=" + flightCarrier + ", flightSource=" + flightSource
				+ ", flightDestination=" + flightDestination + ", seatCapacity=" + seatCapacity + ", duration="
				+ duration + ", journeyDate=" + journeyDate + ", departure=" + departure + ", reach=" + reach
				+ ", fare=" + fare + "]";
	}
		
}
