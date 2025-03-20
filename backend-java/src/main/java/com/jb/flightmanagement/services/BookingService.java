package com.jb.flightmanagement.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jb.flightmanagement.models.flights.Flight;
import com.jb.flightmanagement.repository.FlightRepository;

@Service
public class BookingService {

    private final FlightRepository flightRepository;

    public BookingService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight createBooking(Flight flight) {
        // Check if flight exists in database
        if (flightRepository.findByFlightNumber(flight.getFlightNumber()).isPresent()) {
            throw new IllegalArgumentException("Flight exists");
        }
        else {
            return flightRepository.save(flight);
        }
    }

    public Optional<Flight> cancelBooking(Long id) {

        return flightRepository.findById(id);
    }
}
