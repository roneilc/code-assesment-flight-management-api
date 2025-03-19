package com.jb.flightmanagement.controllers;

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

import com.jb.flightmanagement.models.BookFlightResponse;
import com.jb.flightmanagement.models.CreateFlightRequest;
import com.jb.flightmanagement.models.CreateFlightResponse;
import com.jb.flightmanagement.models.GetFlightResponse;
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

        // if(Stringrequest)
        // _flightService.createFlight(id);

        CreateFlightResponse response = new CreateFlightResponse(1,"JB-202","Scheduled");
        return ResponseEntity.ok(response);

    }

    /**
     * Method for getting flight details
     * @param id Flight Id
     * @return Flight details
     * @throws Exception
     */
    @GetMapping("/flights/{id}")
    public ResponseEntity<GetFlightResponse> getFlight() {


        GetFlightResponse response = new GetFlightResponse();
        return ResponseEntity.ok(response);
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
    public ResponseEntity<GetFlightResponse> searchFlight(
        @RequestParam(required = true) String origin,
        @RequestParam(required = true) String destination,
        @RequestParam(required = true) String date) {

        
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
