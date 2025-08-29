package com.example.test.service;

import com.example.test.core.repository.BookingDetailsDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookingService {

    @Autowired
    BookingDetailsDao bookingDetailsDao;



}
