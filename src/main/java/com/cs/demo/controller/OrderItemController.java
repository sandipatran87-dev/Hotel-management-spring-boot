package com.cs.demo.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.OrderItem;
import com.cs.demo.service.OrderItemService;

@RestController
@CrossOrigin("*")
@RequestMapping("/order-items")
public class OrderItemController {

    private final OrderItemService service;

    public OrderItemController(
            OrderItemService service) {

        this.service = service;
    }

    @PostMapping
    public OrderItem save(
            @RequestBody OrderItem item) {

        return service.save(item);
    }

    @GetMapping
    public List<OrderItem> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public OrderItem getById(
            @PathVariable("id") UUID id) {

        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") UUID id) {

        service.delete(id);
    }
}