package com.jb.flightmanagement.models.bookings;

import lombok.Data;

@Data
public class BookFlightRequest {

    private String passengerName;
    private String seatClass;
}
