package com.cs.demo.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.InventoryItem;
import com.cs.demo.service.InventoryItemService;

@RestController
@RequestMapping("/inventory-items")
@CrossOrigin("*")
public class InventoryItemController {

    private final InventoryItemService service;

    public InventoryItemController(
            InventoryItemService service) {

        this.service = service;
    }

    @PostMapping
    public InventoryItem save(
            @RequestBody InventoryItem item) {

        return service.save(item);
    }

    @GetMapping
    public List<InventoryItem> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public InventoryItem getById(
            @PathVariable("id") UUID id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public InventoryItem update(
            @PathVariable("id") UUID id,
            @RequestBody InventoryItem item) {

        return service.update(id, item);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable("id") UUID id) {

        service.delete(id);

        return "Deleted Successfully";
    }
}