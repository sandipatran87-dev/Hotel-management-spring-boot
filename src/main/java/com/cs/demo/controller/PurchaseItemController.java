package com.cs.demo.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.PurchaseItem;
import com.cs.demo.service.PurchaseItemService;

@RestController
@RequestMapping("/purchase-items")
@CrossOrigin("*")
public class PurchaseItemController {

    private final PurchaseItemService service;

    public PurchaseItemController(
            PurchaseItemService service) {

        this.service = service;
    }

    @PostMapping
    public PurchaseItem save(
            @RequestBody PurchaseItem item) {

        return service.save(item);
    }

    @GetMapping
    public List<PurchaseItem> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PurchaseItem getById(
            @PathVariable UUID id) {

        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}