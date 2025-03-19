package com.jb.flightmanagement.controllers;

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

import com.jb.flightmanagement.models.CreateFlightRequest;
import com.jb.flightmanagement.models.CreateFlightResponse;
import com.jb.flightmanagement.models.GetFlightResponse;

@RestController
@RequestMapping("/api")
public class FlightController {

    /**
     * Method for creating flights
     * @param flightNumber Unique identifier for the flight
     * @param origin flight airport code origin
     * @param destination flight airport code destination
     * @param departureTime flight departure time in format YYY-MM-DDTHH:MM:SSZ
     * @param arrivalTime flight arrival time in format YYY-MM-DDTHH:MM:SSZ
     * @param capacity number of passengers
     * @return
     * @throws Exception
     */
    @PostMapping("/flights")
    public CreateFlightResponse createFlight(@Validated @RequestBody CreateFlightRequest request) {

        // return new CreateFlightResponse(1,"JB-202","Scheduled");
        return new ResponseEntity<T>(new CreateFlightResponse(1,"JB-202","Scheduled"), HttpStatus.Ok);

    }

    /**
     * Method for getting flight details
     * @param id Flight Id
     * @return Flight details
     * @throws Exception
     */
    @GetMapping("/flights/{id}")
    public GetFlightResponse getFlight() {

        return new GetFlightResponse();
    }

    /**
     * Method for searching flight given origin, dest, and date
     * @param origin origin airport code
     * @param destination destination airport code
     * @param date Date YYY-MM-DD
     * @return Flight details
     * @throws Exception
     */
    @GetMapping
    public GetFlightResponse searchFlight(
        @RequestParam(required = true) String origin,
        @RequestParam(required = true) String destination,
        @RequestParam(required = true) String date) {

        return new GetFlightResponse();
    }

    /**
     * Method for booking flight
     * @param id Flight Id
     * @return Flight details
     * @throws Exception
     */
    @PostMapping("/flights/{id}")
    public GetFlightResponse bookFlight() {

        return new GetFlightResponse();
    }

    /**
     * Method for cancelling flight
     * @param id Flight Id
     * @return Flight details
     * @throws Exception
     */
    @DeleteMapping("/{id}/bookings/{bookingId}")
    public ResponseEntity<String> deleteBooking(
            @PathVariable Long id,
            @PathVariable Long bookingId) {

        return ResponseEntity.ok("Booking " + bookingId + " deleted from flight " + id);
    }
    
}
