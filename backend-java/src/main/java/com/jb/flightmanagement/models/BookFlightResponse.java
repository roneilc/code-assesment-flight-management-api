package com.jb.flightmanagement.models;

import lombok.Data;

// {
//     "bookingId": 101,
//     "status": "Confirmed"
//  }

@Data
public class BookFlightResponse {

    private String passengerName;

    private String seatClass;

}
