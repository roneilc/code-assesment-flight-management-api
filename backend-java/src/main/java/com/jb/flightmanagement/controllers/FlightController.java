package com.jb.flightmanagement.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FlightController {

    /**
     * Method for creating flights
     * @param flightNumber Unique identifier for the flight
     * @param origin flight airport code origin
     * @param destination flight airport code destination
     * @param departureTime flight departure in format YYY-MM-DDTHH:MM:SSZ
     * @param arrivalTime flight departure in format YYY-MM-DDTHH:MM:SSZ
     * @param capacity number of passengers
     * @return
     * @throws Exception
     */
    @PostMapping("/flights")
    public String flight() {
        return "";
    }
    
}
