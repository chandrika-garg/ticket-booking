package com.example.test.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
public class BookingException extends RuntimeException {
    public BookingException(String message) {
        super(message);
    }
}