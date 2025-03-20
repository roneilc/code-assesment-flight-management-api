package com.jb.flightmanagement.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "flights")
public class Flight {

    public Flight(Long id, String flightNumber, String origin, String destination, int capacity, String status) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
        this.status = status;
    }
    public Flight() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String flightNumber;

    @Column
    private String origin;

    @Column
    private String destination;

    @Column
    private String departureTime;

    @Column
    private String arrivalTime;

    @Column
    private int capacity;

    @Column
    private String status = "Scheduled";
}
