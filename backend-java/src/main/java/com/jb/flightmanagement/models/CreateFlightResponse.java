package com.jb.flightmanagement.models;

import lombok.Data;

// "id": 1,
// "flightNumber": "JB-202",
// "status": "Scheduled"

@Data
public class CreateFlightResponse {

    private int id;

    private String flightNumber;

    private String status;

    public CreateFlightResponse(int id, String flightNumber, String status) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
