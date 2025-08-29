package com.example.test.service;

import com.example.test.core.entities.Payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    private Map<Integer, Payment> payments = new HashMap<>();
    private int paymentCounter = 1;

    public boolean makePayment(int bookingId, double amount) {
        // Cash payment always succeeds
        Payment payment = new Payment(paymentCounter++, bookingId, amount, "CASH", "SUCCESS");
        payments.put(payment.getId(), payment);
        return true;
    }
}