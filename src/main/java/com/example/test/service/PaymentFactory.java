package com.example.test.service;

import com.example.test.service.strategy.CashPaymentStrategy;
import com.example.test.service.strategy.PaymentStrategy;
import com.example.test.service.strategy.UpiPaymentStrategy;

public class PaymentFactory {
    public static PaymentStrategy getPaymentStrategy(String mode) {
        switch (mode.toUpperCase()) {
            case "CASH": return new CashPaymentStrategy();
            case "UPI": return new UpiPaymentStrategy();
            default: throw new IllegalArgumentException("Unsupported payment mode: " + mode);
        }
    }
}
