package com.cognizant.flightManagement.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cognizant.flightManagement.model.Booking;

public interface BookingRepository extends MongoRepository<Booking, String> {

}
