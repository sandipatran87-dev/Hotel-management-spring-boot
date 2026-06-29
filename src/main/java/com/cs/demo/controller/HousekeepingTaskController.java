package com.cs.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.HousekeepingTask;
import com.cs.demo.service.HousekeepingTaskService;

@RestController
@RequestMapping("/housekeeping")
@CrossOrigin("*")
public class HousekeepingTaskController {

    private final HousekeepingTaskService service;

    public HousekeepingTaskController(
            HousekeepingTaskService service) {

        this.service = service;
    }

    @PostMapping
    public HousekeepingTask save(
            @RequestBody HousekeepingTask task) {

        return service.save(task);
    }

    @GetMapping
    public List<HousekeepingTask> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public HousekeepingTask getById(
            @PathVariable("id") UUID id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public HousekeepingTask update(
            @PathVariable("id") UUID id,
            @RequestBody HousekeepingTask task) {

        return service.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") UUID id) {

        service.delete(id);
    }
}