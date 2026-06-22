package com.cs.demo.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.KitchenOrder;
import com.cs.demo.repo.KitchenOrderRepository;

@Service
public class KitchenOrderService {

    private final KitchenOrderRepository repo;

    public KitchenOrderService(
            KitchenOrderRepository repo) {

        this.repo = repo;
    }

    // Save Kitchen Order
    public KitchenOrder save(KitchenOrder order) {

        order.setKitchenStatus("PENDING");

        order.setAssignedAt(
                LocalDateTime.now());

        return repo.save(order);
    }

    // Get All
    public List<KitchenOrder> getAll() {
        return repo.findAll();
    }

    // Update Status
    public KitchenOrder updateStatus(
            UUID id,
            String status) {

        KitchenOrder k =
                repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Kitchen Order Not Found"));

        k.setKitchenStatus(status);

        if ("DELIVERED".equals(status)) {

            k.setCompletedAt(
                    LocalDateTime.now());
        }

        return repo.save(k);
    }

    // Delete
    public void delete(UUID id) {
        repo.deleteById(id);
    }
}