package com.cs.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.Booking;
import com.cs.demo.repo.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking save(Booking booking) {
        return repository.save(booking);
    }

    public List<Booking> getAll() {
        return repository.findAll();
    }

    public Booking getById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
    
    public Booking update(UUID id, Booking booking) {

        Booking existing = getById(id);

        existing.setCustomer(booking.getCustomer());
        existing.setRoom(booking.getRoom());
        existing.setCheckInDate(booking.getCheckInDate());
        existing.setCheckOutDate(booking.getCheckOutDate());
        existing.setTotalDays(booking.getTotalDays());
        existing.setBookingStatus(booking.getBookingStatus());

        return repository.save(existing);
    }
    
}