package com.jb.flightmanagement.models;

import lombok.Data;

// "id": 1,
// "flightNumber": "JB-202",
// "status": "Scheduled"

@Data
public class CreateFlightResponse {

    private int id;

    private String flightNumber;

    private String status;
}
