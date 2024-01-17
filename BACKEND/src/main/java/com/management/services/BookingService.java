package com.management.services;


import com.management.entities.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    List<Booking> getAllBookings();
    Booking createBooking(Booking booking);
    Booking updateBooking(Booking booking);
    void deleteBookingById(Long id);
    Booking getBookingById(Long id);
    Booking updateBookingById(Long id, Booking updatedBooking);
}
