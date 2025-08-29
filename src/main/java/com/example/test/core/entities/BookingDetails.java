package com.example.test.core.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Table(name = "booking_details")
public class BookingDetails {

    private static final long serialVersionUIZD = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



}
