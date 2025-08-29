package com.example.test.core.repository;

import com.example.test.core.entities.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingDetailsDao extends JpaRepository<BookingDetails, Long> {

}

