package com.management.restcontrollers;

import com.management.entities.Booking;
import com.management.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BookingRestController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/bookings/{id}")
    public Booking getBookingById(@PathVariable("id") Long id) {

            return bookingService.getBookingById(id);
    }

    @PostMapping("/bookings/save")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PutMapping("/bookings/update")
    public Booking updateBooking(@RequestBody Booking booking) {
        return bookingService.updateBooking(booking);
    }

    @PutMapping("/bookings/update/{id}")
    public Booking updateBookingById(@PathVariable Long id, @RequestBody Booking updatedBooking) {
        return bookingService.updateBookingById(id, updateBookingById(id, updatedBooking));
    }

    @DeleteMapping("/bookings/{id}")
    public void deleteBookingById(@PathVariable("id") Long id) {
        bookingService.deleteBookingById(id);
    }
}
