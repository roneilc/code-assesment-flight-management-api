package com.jb.flightmanagement.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jb.flightmanagement.models.CreateFlightRequest;
import com.jb.flightmanagement.models.CreateFlightResponse;

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

        return new CreateFlightResponse(1,"JB-202","Scheduled");
    }
    
}
