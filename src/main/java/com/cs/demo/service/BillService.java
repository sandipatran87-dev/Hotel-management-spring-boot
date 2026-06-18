package com.cs.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.demo.entity.Bill;
import com.cs.demo.repo.BillRepository;

@Service
public class BillService {

    @Autowired
    private BillRepository repo;

    // Save Bill
    public Bill saveBill(Bill bill) {
        return repo.save(bill);
    }

    // Get All Bills
    public List<Bill> getAllBills() {
        return repo.findAll();
    }

    // Get Bill By Id
    public Bill getBillById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    // Delete Bill
    public String deleteBill(UUID id) {
        repo.deleteById(id);
        return "Bill Deleted Successfully";
    }
}