package com.jb.flightmanagement.models.flights;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFlightResponse {

    private Optional<Flight> flight;

    private String responseMessage;
}
