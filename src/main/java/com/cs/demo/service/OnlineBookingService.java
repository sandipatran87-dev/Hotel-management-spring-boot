package com.cs.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.OnlineBooking;
import com.cs.demo.repo.OnlineBookingRepository;

@Service
public class OnlineBookingService {

    private final OnlineBookingRepository repo;

    public OnlineBookingService(
            OnlineBookingRepository repo) {

        this.repo = repo;
    }

    public OnlineBooking save(
            OnlineBooking booking) {

        if (booking.getBookingStatus() == null) {
            booking.setBookingStatus("PENDING");
        }

        return repo.save(booking);
    }

    public List<OnlineBooking> getAll() {
        return repo.findAll();
    }

    public OnlineBooking getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public OnlineBooking update(
            UUID id,
            OnlineBooking booking) {

        OnlineBooking b =
                repo.findById(id).orElseThrow();

        b.setCustomer(booking.getCustomer());
        b.setBookingSource(booking.getBookingSource());
        b.setBookingStatus(booking.getBookingStatus());

        return repo.save(b);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

}