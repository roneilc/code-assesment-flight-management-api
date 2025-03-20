package com.jb.flightmanagement.models;

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
