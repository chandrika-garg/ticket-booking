package com.example.test.core.entities;

import com.example.test.core.enums.BookingStatusEnum;
import com.example.test.core.enums.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Booking {
    int id;
    int eventId;
    int userId;
    BookingStatusEnum status;
    List<Integer> seatIds;

    public Booking(int id, int eventId, int userId, List<Integer> seatIds) {
        this.id = id;
        this.eventId = eventId;
        this.userId = userId;
        this.seatIds = new ArrayList<>(seatIds);
        this.status = BookingStatusEnum.IN_PROGRESS;
    }

}