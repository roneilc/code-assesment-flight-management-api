package com.jb.flightmanagement.models;

import lombok.Data;

// {
//     "passengerName": "John Doe",
//     "seatClass": "Economy"
//  }

@Data
public class BookFlightRequest {

    private int id;

    private String flightNumber;

    private String status;
}
