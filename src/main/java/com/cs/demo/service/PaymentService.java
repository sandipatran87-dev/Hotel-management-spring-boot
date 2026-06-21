package com.cs.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.demo.entity.Bill;
import com.cs.demo.entity.Payment;
import com.cs.demo.repo.BillRepository;
import com.cs.demo.repo.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repo;

    @Autowired
    private BillRepository billRepo;

    public Payment save(Payment payment) {

        UUID billId =
                payment.getBill().getBillId();

        Bill bill =
                billRepo.findById(billId)
                .orElseThrow(() ->
                new RuntimeException("Bill Not Found"));

        if (repo.existsByBill_BillId(billId)) {

            throw new RuntimeException(
                    "Payment Already Exists");
        }

        bill.setBillStatus("PAID");

        billRepo.save(bill);

        payment.setTransactionReference(
                "TXN" + System.currentTimeMillis()
        );

        return repo.save(payment);
    }

    public List<Payment> getAll() {
        return repo.findAll();
    }

    public Payment getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}