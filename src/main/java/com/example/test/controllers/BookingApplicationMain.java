package com.example.test.controllers;

import com.example.test.core.entities.Booking;
import com.example.test.core.entities.Event;
import com.example.test.core.entities.Seat;
import com.example.test.service.BookingService;
import com.example.test.service.PaymentService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BookingApplicationMain {

    public static void main(String[] args) {
        Event event = new Event(1, "Avengers", "7 PM", "10 PM");

        Map<Integer, Seat> seats = new HashMap<>();
        seats.put(101, new Seat(101, "A1", event.getId()));
        seats.put(102, new Seat(102, "A2", event.getId()));
        seats.put(103, new Seat(103, "A3", event.getId()));
        seats.put(104, new Seat(104, "A4", event.getId()));

        BookingService bookingService = new BookingService(seats);
        PaymentService paymentService = new PaymentService();

        // Step 1: User reserves multiple seats
        Booking booking = bookingService.createBooking(1, 501, Arrays.asList(101, 102, 103));
        if (booking != null) {
            System.out.println("Booking created with ID: " + booking.getId() + " for seats: " + booking.getSeatIds());
        }

        // Step 2: Confirm booking with payment
        boolean confirmed = bookingService.confirmBooking(booking.getId(), 900.0, paymentService);
        System.out.println("Booking confirmation status: " + confirmed);

        // Step 3: Show final seat statuses
        for (Seat seat : seats.values()) {
            System.out.println("Seat " + seat.getSeatNumber() + " -> " + seat.getStatus());
        }
    }

}