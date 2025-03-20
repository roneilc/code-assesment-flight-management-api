package com.jb.flightmanagement.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jb.flightmanagement.models.Flight;
import com.jb.flightmanagement.repository.FlightRepository;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void createFlight(Flight flight) {

        flightRepository.save(flight);
    }

    public Optional<Flight> getFlight(Long id) {

        return flightRepository.findById(id);
    }

    public void cancelFlight(Long id) {

        flightRepository.deleteById(id);
    }
}
