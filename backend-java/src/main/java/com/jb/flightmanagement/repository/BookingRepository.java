package com.jb.flightmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jb.flightmanagement.models.bookings.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Optional<Booking> findByBookingNumber(String flightNumber);
}
