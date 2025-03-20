package com.jb.flightmanagement.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jb.flightmanagement.models.flights.Flight;
import com.jb.flightmanagement.repository.FlightRepository;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight createFlight(Flight flight) {
        // Check if flight exists in database
        if (flightRepository.findByFlightNumber(flight.getFlightNumber()).isPresent()) {
            throw new IllegalArgumentException("Flight exists");
        }
        else {
            return flightRepository.save(flight);
        }
    }

    public Optional<Flight> getFlight(Long id) {

        return flightRepository.findById(id);
    }
}
