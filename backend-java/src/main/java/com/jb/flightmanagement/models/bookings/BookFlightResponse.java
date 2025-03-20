package com.jb.flightmanagement.models.bookings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// {
//     "bookingId": 101,
//     "status": "Confirmed"
//  }

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookFlightResponse {

    private Long bookingId;
    private String status;

}
