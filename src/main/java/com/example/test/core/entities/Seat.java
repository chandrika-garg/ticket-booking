package com.example.test.core.entities;

import com.example.test.core.enums.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seat {
    int id;
    String seatNumber;
    SeatStatus status;
    int eventId;

    public Seat(int id, String seatNumber, int eventId) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.status = SeatStatus.AVAILABLE;
        this.eventId = eventId;
    }


}