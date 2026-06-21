package com.cs.demo.controller;



import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.Booking;
import com.cs.demo.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking save(@RequestBody Booking booking) {
        return service.save(booking);
    }

    @GetMapping
    public List<Booking> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Booking getById(@PathVariable("id") UUID id) {
        return service.getById(id);
    }
    
    @PutMapping("/{id}")
    public Booking update(@PathVariable("id") UUID id,
                          @RequestBody Booking booking) {
        return service.update(id, booking);
    }
    
    
    

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") UUID id) {

        service.delete(id);

        return "Booking Deleted";
    }
    
    @PutMapping("/checkout/{id}")
    public Booking checkout(
            @PathVariable("id") UUID id) {

        return service.checkout(id);
    }
}