package com.jb.flightmanagement.models.bookings;

import lombok.AllArgsConstructor;
import lombok.Data;

// {
//     "message": "Booking canceled successfully."
// }

@Data
@AllArgsConstructor
public class CancelBookingResponse {

    private String message;

}
