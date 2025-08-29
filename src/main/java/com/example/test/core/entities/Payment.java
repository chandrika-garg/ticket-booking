package com.example.test.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Payment {
    int id;
    int bookingId;
    double amount;
    String mode;   // CASH
    String status; // SUCCESS / FAILED

}