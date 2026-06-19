package com.cs.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.demo.entity.Payment;
import com.cs.demo.repo.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repo;

    public Payment savePayment(Payment payment) {
        return repo.save(payment);
    }

    public List<Payment> getAllPayments() {
        return repo.findAll();
    }

    public Payment getPaymentById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public String deletePayment(UUID id) {
        repo.deleteById(id);
        return "Payment Deleted";
    }
}