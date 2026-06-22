package com.cs.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.PurchaseOrder;
import com.cs.demo.service.PurchaseOrderService;

@RestController
@RequestMapping("/purchase-orders")
@CrossOrigin("*")
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    public PurchaseOrderController(
            PurchaseOrderService service) {

        this.service = service;
    }

    @PostMapping
    public PurchaseOrder save(
            @RequestBody PurchaseOrder order) {

        return service.save(order);
    }

    @GetMapping
    public List<PurchaseOrder> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PurchaseOrder getById(
            @PathVariable("id") UUID id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public PurchaseOrder update(
            @PathVariable("id") UUID id,
            @RequestBody PurchaseOrder order) {

        return service.update(id, order);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable("id") UUID id) {

        service.delete(id);

        return "Deleted Successfully";
    }
}