package com.example.test.service.strategy;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(int bookingId, double amount) {
        System.out.println("Cash payment for booking " + bookingId + " amount: " + amount);
        return true;
    }
}