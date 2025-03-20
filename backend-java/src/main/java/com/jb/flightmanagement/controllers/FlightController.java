package com.jb.flightmanagement.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jb.flightmanagement.models.bookings.BookFlightResponse;
import com.jb.flightmanagement.models.flights.CreateFlightRequest;
import com.jb.flightmanagement.models.flights.CreateFlightResponse;
import com.jb.flightmanagement.models.flights.Flight;
import com.jb.flightmanagement.models.flights.GetFlightResponse;
import com.jb.flightmanagement.services.FlightService;

@RestController
@RequestMapping("/api")
public class FlightController {

    private final FlightService _flightService;

    public FlightController(FlightService flightService) {
        this._flightService = flightService;
    }

    /**
     * Method for creating flights
     * @param flightNumber Unique identifier for the flight
     * @param origin flight airport code origin
     * @param destination flight airport code destination
     * @param departureTime flight departure time in format YYY-MM-DDTHH:MM:SSZ
     * @param arrivalTime flight arrival time in format YYY-MM-DDTHH:MM:SSZ
     * @param capacity max number of passengers
     * @return
     * @throws Exception
     */
    @PostMapping("/flights")
    public ResponseEntity<CreateFlightResponse> createFlight(@Validated @RequestBody CreateFlightRequest request) {

        try {
            // Attempt to save flight
            Flight savedFlight = _flightService.createFlight(request.getFlight());

            // Create response if successful
            CreateFlightResponse response = new CreateFlightResponse(
                    savedFlight.getId(),
                    savedFlight.getFlightNumber(),
                    savedFlight.getStatus()
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new CreateFlightResponse((long) 0, "", "Flight cannot be created"));
        }
    }

    /**
     * Method for getting flight details
     * @param id Flight Id
     * @return Flight details
     * @throws Exception
     */
    @GetMapping("/flights/{id}")
    public ResponseEntity<GetFlightResponse> getFlights(@PathVariable("id") Long id) {

        Optional<Flight> flight = _flightService.getFlight(id);

        GetFlightResponse response = new GetFlightResponse();

        response.setFlight(flight);

        if (flight.isPresent()) {
            response.setFlight(flight);
            response.setResponseMessage("Flight Found");
            return ResponseEntity.ok(response);
        } else {
            response.setResponseMessage("Not found");
            return ResponseEntity.ok(response);
        }
    }

    /**
     * Method for searching flight given origin, dest, and date
     * @param origin origin airport code
     * @param destination destination airport code
     * @param date Date YYY-MM-DD
     * @return Flight details
     * @throws Exception
     */
    @GetMapping("/flights")
    public ResponseEntity<GetFlightResponse> searchFlights(
        @RequestParam(name = "origin", required = false) String origin,
        @RequestParam(name = "destination", required = false) String destination,
        @RequestParam(name = "date", required = false) String date) {

        
        GetFlightResponse response = new GetFlightResponse();
        return ResponseEntity.ok(response);
    }

    /**
     * Method for booking flights
     * @param id Flight Id
     * @return Flight details
     * @throws Exception
     */
    @PostMapping("/flights/{id}")
    public ResponseEntity<GetFlightResponse> bookFlight() {

        GetFlightResponse response = new GetFlightResponse();
        return ResponseEntity.ok(response);
    }

    /**
     * Method for cancelling flight
     * @param id Flight Id
     * @return Flight details
     * @throws Exception
     */
    @DeleteMapping("/{id}/bookings/{bookingId}")
    public ResponseEntity<BookFlightResponse> deleteBooking(
            @PathVariable Long id,
            @PathVariable Long bookingId) {

        BookFlightResponse response = new BookFlightResponse();
        return ResponseEntity.ok(response);

    }
    
}
