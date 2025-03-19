package com.jb.flightmanagement.models;

import lombok.Data;

@Data
public class GetFlightResponse {

    private Flight flight;

    private String status;
}
