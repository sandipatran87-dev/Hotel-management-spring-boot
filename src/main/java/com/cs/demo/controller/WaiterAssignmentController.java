package com.cs.demo.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.WaiterAssignment;
import com.cs.demo.service.WaiterAssignmentService;

@RestController
@RequestMapping("/waiter-assignments")
@CrossOrigin("*")
public class WaiterAssignmentController {

    private final WaiterAssignmentService service;

    public WaiterAssignmentController(
            WaiterAssignmentService service) {

        this.service = service;
    }

    @PostMapping
    public WaiterAssignment save(
            @RequestBody WaiterAssignment assignment) {

        return service.save(assignment);
    }

    @GetMapping
    public List<WaiterAssignment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public WaiterAssignment getById(
            @PathVariable("id") UUID id) {

        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable("id") UUID id) {

        service.delete(id);

        return "Deleted Successfully";
    }
}