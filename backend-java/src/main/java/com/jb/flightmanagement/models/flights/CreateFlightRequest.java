package com.jb.flightmanagement.models.flights;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateFlightRequest {

    public CreateFlightRequest(Flight flight) {
        this.flight = flight;
    }

    private Flight flight;

}
