package com.cs.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.PurchaseOrder;
import com.cs.demo.repo.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository repo;

    public PurchaseOrderService(
            PurchaseOrderRepository repo) {

        this.repo = repo;
    }

    public PurchaseOrder save(
            PurchaseOrder order) {

        order.setOrderDate(
                LocalDateTime.now());

        if(order.getStatus() == null) {
            order.setStatus("PENDING");
        }

        return repo.save(order);
    }

    public List<PurchaseOrder> getAll() {
        return repo.findAll();
    }

    public PurchaseOrder getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public PurchaseOrder update(
            UUID id,
            PurchaseOrder order) {

        PurchaseOrder p =
                repo.findById(id)
                .orElseThrow();

        p.setSupplier(order.getSupplier());
        p.setTotalAmount(order.getTotalAmount());
        p.setStatus(order.getStatus());

        return repo.save(p);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}