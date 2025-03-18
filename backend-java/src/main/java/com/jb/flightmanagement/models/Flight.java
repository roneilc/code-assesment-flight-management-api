package com.jb.flightmanagement.models;

import lombok.Data;

@Data
public class Flight {

    private String flightNumber;

    private String origin;

    private String destination;

    private String departureTime;

    private String arrivalTime;

    private int capacity;
}
