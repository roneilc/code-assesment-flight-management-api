package com.jb.flightmanagement.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jb.flightmanagement.models.bookings.BookFlightRequest;
import com.jb.flightmanagement.models.bookings.BookFlightResponse;
import com.jb.flightmanagement.models.bookings.Booking;
import com.jb.flightmanagement.models.bookings.CancelBookingResponse;
import com.jb.flightmanagement.models.flights.CreateFlightRequest;
import com.jb.flightmanagement.models.flights.CreateFlightResponse;
import com.jb.flightmanagement.models.flights.Flight;
import com.jb.flightmanagement.models.flights.GetFlightResponse;
import com.jb.flightmanagement.services.BookingService;
import com.jb.flightmanagement.services.FlightService;

@RestController
@RequestMapping("/api")
public class FlightController {

    private final FlightService _flightService;
    private final BookingService _bookingService;

    public FlightController(FlightService flightService, BookingService bookingService) {
        this._flightService = flightService;
        this._bookingService = bookingService;
    }

    /**
     * Method for creating flights
     * @param flightNumber Unique identifier for the flight
     * @param origin flight airport code origin
     * @param destination flight airport code destination
     * @param departureTime flight departure time in format YYY-MM-DDTHH:MM:SSZ
     * @param arrivalTime flight arrival time in format YYY-MM-DDTHH:MM:SSZ
     * @param capacity max number of passengers
     * @return status
     * @throws Exception
     */
    @PostMapping("/flights")
    public ResponseEntity<CreateFlightResponse> createFlight(@Validated @RequestBody CreateFlightRequest request) {

        try {
            // Attempt to save flight
            Flight savedFlight = _flightService.createFlight(request.getFlight());

            // Create response if successful
            CreateFlightResponse response = new CreateFlightResponse(
                    savedFlight.getId(),
                    savedFlight.getFlightNumber(),
                    savedFlight.getStatus()
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new CreateFlightResponse((long) 0, "", "Flight cannot be created"));
        }
    }

    /**
     * Method for getting flight details
     * @param id Flight Id
     * @return Flight details
     * @throws Exception
     */
    @GetMapping("/flights/{id}")
    public ResponseEntity<GetFlightResponse> getFlights(@Validated @PathVariable("id") Long id) {

        try{
            Optional<Flight> flight = _flightService.getFlight(id);

            GetFlightResponse response = new GetFlightResponse();
    
            response.setFlight(flight);
    
            if (flight.isPresent()) {
                response.setFlight(flight);
                response.setResponseMessage("Flight Found");
                return ResponseEntity.ok(response);
            } else {
                response.setResponseMessage("Not found");
                return ResponseEntity.ok(response);
            }

        }
        catch (Exception ex) {
            // Exception Handling
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new GetFlightResponse(null, "Flight cannot be created"));
        }
    }


    //TODO
    /**
     * Method for searching flight given origin, dest, and date
     * @param origin origin airport code
     * @param destination destination airport code
     * @param date Date YYY-MM-DD
     * @return Flight details
     * @throws Exception
     */
    @GetMapping("/flights")
    public ResponseEntity<GetFlightResponse> searchFlights(
        @RequestParam(name = "origin", required = false) String origin,
        @RequestParam(name = "destination", required = false) String destination,
        @RequestParam(name = "date", required = false) String date) {

        GetFlightResponse response = new GetFlightResponse();
        return ResponseEntity.ok(response);
    }

    /**
     * Method for booking flights
     * @param id Flight Id
     * @param passengerName passenger name
     * @param seatClass seat category (economy, business, firstclass)
     * @return status
     * @throws Exception
     */
    @PostMapping("/flights/{id}/bookings")
    public ResponseEntity<BookFlightResponse> bookFlight(
            @PathVariable("id") Long flightId,
            @RequestBody BookFlightRequest request) {


        try {
            // Attempt to book flight
            Booking booking = _bookingService.createBooking(flightId, request);

            // Create response if successful
            BookFlightResponse response = new BookFlightResponse(
                booking.getId(),
                booking.getStatus()
            );
            
        return ResponseEntity.ok(response);
            
        } catch (Exception ex) {
            // Exception Handling
            BookFlightResponse response = new BookFlightResponse();
            return ResponseEntity.ok(response);
        }
    }

    /**
     * Method for cancelling booking
     *
     * @param flightId   The ID of the flight.
     * @param bookingId  The ID of the booking to be cancelled.
     * @return ResponseEntity containing a message indicating success or failure.
     */
    @DeleteMapping("flights/{id}/bookings/{bookingId}")
    public ResponseEntity<CancelBookingResponse> deleteBooking(
            @PathVariable("id") Long flightId,
            @PathVariable("bookingId") Long bookingId) {
        
        try {
            
            _bookingService.cancelBooking(flightId, bookingId);

            CancelBookingResponse response = new CancelBookingResponse("Booking cancelled successfully.");

            return ResponseEntity.ok(response);

        } catch (Exception ex) {
            // Exception Handling
            CancelBookingResponse response = new CancelBookingResponse("Booking cancellation unsuccessful. Booking not found");
            return ResponseEntity.ok(response);
        }
    }
    
    
}
