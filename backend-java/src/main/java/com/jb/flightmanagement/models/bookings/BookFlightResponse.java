package com.jb.flightmanagement.models.bookings;

import lombok.AllArgsConstructor;
import lombok.Data;

// {
//     "bookingId": 101,
//     "status": "Confirmed"
//  }

@Data
@AllArgsConstructor
public class BookFlightResponse {

    private Long bookingId;
    private String status;

}
