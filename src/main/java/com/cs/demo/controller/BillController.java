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

import com.cs.demo.entity.Bill;
import com.cs.demo.service.BillService;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/bills")
@CrossOrigin("*")
public class BillController {

    @Autowired
    private BillService service;

    // Save Bill
    @PostMapping
    public Bill saveBill(@RequestBody Bill bill) {
        return service.saveBill(bill);
    }

    // Get All Bills
    @GetMapping
    public List<Bill> getAllBills() {
        return service.getAllBills();
    }

    // Get Bill By Id
    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable("id") UUID id) {
        return service.getBillById(id);
    }

    // Delete Bill
    @DeleteMapping("/{id}")
    public String deleteBill(@PathVariable("id") UUID id) {
        return service.deleteBill(id);
    }
}