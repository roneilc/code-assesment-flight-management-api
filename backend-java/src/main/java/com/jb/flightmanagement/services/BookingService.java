package com.jb.flightmanagement.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jb.flightmanagement.models.bookings.BookFlightRequest;
import com.jb.flightmanagement.models.bookings.Booking;
import com.jb.flightmanagement.models.flights.Flight;
import com.jb.flightmanagement.repository.BookingRepository;
import com.jb.flightmanagement.repository.FlightRepository;

@Service
public class BookingService {

    private final FlightRepository flightRepository;
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository, FlightRepository flightRepository) {
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
    }

    public Flight createBooking(Flight flight) {
        // Check if flight exists in database
        if (flightRepository.findByFlightNumber(flight.getFlightNumber()).isPresent()) {
            throw new IllegalArgumentException("Flight exists");
        }
        else {
            return flightRepository.save(flight);
        }
    }

    public Booking createBooking(Long flightId, BookFlightRequest request) {
        // Find flight
        Optional<Flight> flightOptional = flightRepository.findById(flightId);

        Flight flight = flightOptional.get();

        // Create booking
        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.setPassengerName(request.getPassengerName());
        booking.setSeatClass(request.getSeatClass());
        booking.setStatus("Confirmed");

        return bookingRepository.save(booking);
    }

    public Optional<Flight> cancelBooking(Long id) {

        return flightRepository.findById(id);
    }
}
