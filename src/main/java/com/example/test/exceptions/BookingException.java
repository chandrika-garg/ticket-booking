package com.example.test.exceptions;

import com.example.test.utils.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookingException extends RuntimeException {

    private String message;

    private ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public BookingException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public BookingException(ErrorCode errorCode) {
        super(errorCode.getInstantDisplayMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getInstantDisplayMessage();
    }
}