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

    public Booking createBooking(Long flightId, BookFlightRequest request) {
        // Find flight
        Optional<Flight> flight = flightRepository.findById(flightId);

        Flight bookedFlight = flight.get();

        // Create booking
        Booking booking = new Booking();
        booking.setFlight(bookedFlight);
        booking.setPassengerName(request.getPassengerName());
        booking.setSeatClass(request.getSeatClass());
        booking.setStatus("Confirmed");

        return bookingRepository.save(booking);
    }

    public void cancelBooking(Long flightId, Long bookingId) {

        // Validate flight id
        Optional<Flight> flightOpt = flightRepository.findById(flightId);
        if (flightOpt.isEmpty()) {
            throw new IllegalArgumentException("Flight not found");
        }

        Optional<Booking> booking = bookingRepository.findById(bookingId);

        if (booking.isEmpty()) {
            throw new IllegalArgumentException("Booking not found");
        }
        else {
            
            bookingRepository.deleteById(bookingId);
        }

    }
}
