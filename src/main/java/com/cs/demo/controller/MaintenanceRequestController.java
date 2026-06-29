package com.cs.demo.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.MaintenanceRequest;
import com.cs.demo.service.MaintenanceRequestService;

@RestController
@RequestMapping("/maintenance")
@CrossOrigin("*")
public class MaintenanceRequestController {

    private final MaintenanceRequestService service;

    public MaintenanceRequestController(
            MaintenanceRequestService service) {

        this.service = service;
    }

    @PostMapping
    public MaintenanceRequest save(
            @RequestBody MaintenanceRequest request) {

        return service.save(request);
    }

    @GetMapping
    public List<MaintenanceRequest> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public MaintenanceRequest getById(
            @PathVariable("id") UUID id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public MaintenanceRequest update(
            @PathVariable("id") UUID id,
            @RequestBody MaintenanceRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable("id") UUID id) {

        service.delete(id);

        return "Deleted Successfully";
    }
}