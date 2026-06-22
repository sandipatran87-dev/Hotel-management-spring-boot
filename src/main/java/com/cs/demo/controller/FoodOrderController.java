package com.cs.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.FoodOrder;
import com.cs.demo.service.FoodOrderService;

@RestController
@CrossOrigin("*")
@RequestMapping("/orders")
public class FoodOrderController {

    private final FoodOrderService service;

    public FoodOrderController(
            FoodOrderService service) {

        this.service = service;
    }

    @PostMapping
    public FoodOrder save(
            @RequestBody FoodOrder order) {

        return service.save(order);
    }

    @GetMapping
    public List<FoodOrder> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public FoodOrder getById(
            @PathVariable("id") UUID id) {

        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") UUID id) {

        service.delete(id);
    }
}