package com.example.test.service;

import com.example.test.core.entities.Booking;
import com.example.test.core.entities.Seat;
import com.example.test.core.enums.BookingStatusEnum;
import com.example.test.core.enums.SeatStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class BookingService {
    private Map<Integer, Seat> seats;
    private Map<Integer, Booking> bookings = new HashMap<>();
    private int bookingCounter = 1;


    public BookingService(Map<Integer, Seat> seats) {
        this.seats = seats;
    }

    public boolean reserveSeats(int eventId, List<Integer> seatIds) {
        // Check availability
        for (int seatId : seatIds) {
            Seat seat = seats.get(seatId);
            if (seat == null || seat.getStatus() != SeatStatus.AVAILABLE || seat.getEventId() != eventId) {
                return false;
            }
        }
        // Mark as RESERVED
        for (int seatId : seatIds) {
            seats.get(seatId).setStatus(SeatStatus.RESERVED);
        }
        return true;
    }

    public void confirmSeats(List<Integer> seatIds) {
        for (int seatId : seatIds) {
            seats.get(seatId).setStatus(SeatStatus.BOOKED);
        }
    }

    public Booking createBooking(int eventId, int userId, List<Integer> seatIds) {
        boolean reserved = reserveSeats(eventId, seatIds);
        if (!reserved) {
            System.out.println("Booking failed. Some seats are unavailable.");
            return null;
        }
        Booking booking = new Booking(bookingCounter++, eventId, userId, seatIds);
        bookings.put(booking.getId(), booking);
        return booking;
    }

    public boolean confirmBooking(int bookingId, double amount, PaymentService paymentService) {
        Booking booking = bookings.get(bookingId);
        if (booking == null || !BookingStatusEnum.IN_PROGRESS.equals(booking.getStatus())) {
            return false;
        }
        boolean paid = paymentService.makePayment(bookingId, amount);
        if (paid) {
            booking.setStatus(BookingStatusEnum.SUCCESS);
            confirmSeats(booking.getSeatIds());
            return true;
        }
        return false;
    }

    public Booking getBooking(int bookingId) {
        return bookings.get(bookingId);
    }


}
