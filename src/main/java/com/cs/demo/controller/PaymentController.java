package com.cs.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.Payment;
import com.cs.demo.service.PaymentService;

@RestController
@RequestMapping("/payments")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public Payment save(
            @RequestBody Payment payment) {

        return service.save(payment);
    }

    @GetMapping
    public List<Payment> getAll() {

        return service.getAll();
    }

    @GetMapping("/{id}")
    public Payment getById(
            @PathVariable UUID id) {

        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable UUID id) {

        service.delete(id);
    }
}