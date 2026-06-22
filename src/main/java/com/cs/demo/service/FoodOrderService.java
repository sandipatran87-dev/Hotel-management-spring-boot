package com.cs.demo.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.FoodOrder;
import com.cs.demo.repo.FoodOrderRepository;

@Service
public class FoodOrderService {

    private final FoodOrderRepository repo;

    public FoodOrderService(
            FoodOrderRepository repo) {

        this.repo = repo;
    }

    public FoodOrder save(FoodOrder order) {

        order.setOrderStatus("PLACED");
        order.setOrderTime(LocalDateTime.now());

        return repo.save(order);
    }

    public List<FoodOrder> getAll() {
        return repo.findAll();
    }

    public FoodOrder getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}