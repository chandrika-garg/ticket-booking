package com.example.test.service.strategy;

public class UpiPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(int bookingId, double amount) {
        System.out.println("UPI payment for booking " + bookingId + " amount: " + amount);
        return true;
    }
}