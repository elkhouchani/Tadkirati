package com.management.services;

import com.management.entities.Booking;
import com.management.enums.BookingStatus;
import com.management.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking createBooking(Booking booking) {
        booking.setBookedAt(new Date()); // Set the booking timestamp
        booking.setStatus(BookingStatus.PENDING); // Set initial status
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBookingById(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Booking not found with ID: " + id));
    }

    @Override
    public Booking updateBookingById(Long id, Booking updatedBooking) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Booking not found with ID: " + id));

        // Update the properties with data from the updated booking
        existingBooking.setClient(updatedBooking.getClient());
        existingBooking.setShow(updatedBooking.getShow());
        existingBooking.setSeats(updatedBooking.getSeats());
        existingBooking.setAmount(updatedBooking.getAmount());
        existingBooking.setBookedAt(updatedBooking.getBookedAt());
        existingBooking.setStatus(updatedBooking.getStatus());
        existingBooking.setPayments(updatedBooking.getPayments());

        // Save the updated booking
        return bookingRepository.save(existingBooking);
    }
}