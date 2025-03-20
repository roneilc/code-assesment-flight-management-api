package com.jb.flightmanagement.models;

import java.util.Optional;

import lombok.Data;

@Data
public class GetFlightResponse {

    private Optional<Flight> flight;

    private String responseMessage;
}
