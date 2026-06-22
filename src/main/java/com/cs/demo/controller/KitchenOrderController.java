package com.cs.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.KitchenOrder;
import com.cs.demo.service.KitchenOrderService;

@RestController
@RequestMapping("/kitchen-orders")
@CrossOrigin("*")
public class KitchenOrderController {

    private final KitchenOrderService service;

    public KitchenOrderController(
            KitchenOrderService service) {

        this.service = service;
    }

    @PostMapping
    public KitchenOrder save(
            @RequestBody KitchenOrder order) {

        return service.save(order);
    }

    @GetMapping
    public List<KitchenOrder> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}/{status}")
    public KitchenOrder updateStatus(
            @PathVariable("id") UUID id,
            @PathVariable("status") String status) {

        return service.updateStatus(
                id,
                status);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") UUID id) {

        service.delete(id);
    }
}