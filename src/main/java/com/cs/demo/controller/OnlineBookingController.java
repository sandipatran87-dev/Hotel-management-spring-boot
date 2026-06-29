package com.cs.demo.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.OnlineBooking;
import com.cs.demo.service.OnlineBookingService;

@RestController
@RequestMapping("/online-bookings")
@CrossOrigin("*")
public class OnlineBookingController {

    private final OnlineBookingService service;

    public OnlineBookingController(
            OnlineBookingService service) {

        this.service = service;
    }

    @PostMapping
    public OnlineBooking save(
            @RequestBody OnlineBooking booking) {

        return service.save(booking);
    }

    @GetMapping
    public List<OnlineBooking> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public OnlineBooking getById(
            @PathVariable("id") UUID id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public OnlineBooking update(
            @PathVariable("id") UUID id,
            @RequestBody OnlineBooking booking) {

        return service.update(id, booking);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable("id") UUID id) {

        service.delete(id);
        return "Deleted Successfully";
    }

}
