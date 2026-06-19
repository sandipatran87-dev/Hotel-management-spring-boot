package com.cs.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.demo.entity.Payment;
import com.cs.demo.service.PaymentService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/payments")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public Payment savePayment(@RequestBody Payment payment) {
        return service.savePayment(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return service.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable("id") UUID id) {
        return service.getPaymentById(id);
    }
    
    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable("id") UUID id) {
        service.deletePayment(id);
        return "Payment Deleted Successfully";
    }
    
}