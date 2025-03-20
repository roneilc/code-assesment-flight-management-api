package com.jb.flightmanagement.models.bookings;

import lombok.Data;

// {
//     "bookingId": 101,
//     "status": "Confirmed"
//  }

@Data
public class BookFlightResponse {

    private Long id;
    private String status;

}
