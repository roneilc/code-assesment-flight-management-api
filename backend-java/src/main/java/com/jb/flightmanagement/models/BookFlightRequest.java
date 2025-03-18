package com.jb.flightmanagement.models;

import lombok.Data;

// {
//     "passengerName": "John Doe",
//     "seatClass": "Economy"
//  }

@Data
public class CreateFlightResponse {

    private int id;

    private String flightNumber;

    private String status;
}
