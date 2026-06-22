package com.cs.demo.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.Supplier;
import com.cs.demo.service.SupplierService;

@RestController
@RequestMapping("/suppliers")
@CrossOrigin("*")
public class SupplierController {

    private final SupplierService service;

    public SupplierController(
            SupplierService service) {

        this.service = service;
    }

    @PostMapping
    public Supplier save(
            @RequestBody Supplier supplier) {

        return service.save(supplier);
    }

    @GetMapping
    public List<Supplier> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Supplier getById(
            @PathVariable("id") UUID id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Supplier update(
            @PathVariable("id") UUID id,
            @RequestBody Supplier supplier) {

        return service.update(id, supplier);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable("id") UUID id) {

        service.delete(id);

        return "Deleted Successfully";
    }
}