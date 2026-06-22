package com.cs.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.RestaurantTable;
import com.cs.demo.service.RestaurantTableService;

@RestController
@RequestMapping("/restaurant-tables")
@CrossOrigin("*")
public class RestaurantTableController {

    private final RestaurantTableService service;

    public RestaurantTableController(
            RestaurantTableService service) {

        this.service = service;
    }

    @PostMapping
    public RestaurantTable save(
            @RequestBody RestaurantTable table) {

        return service.save(table);
    }

    @GetMapping
    public List<RestaurantTable> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RestaurantTable getById(
            @PathVariable("id") UUID id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public RestaurantTable update(
            @PathVariable("id") UUID id,
            @RequestBody RestaurantTable table) {

        return service.update(id, table);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable("id") UUID id) {

        service.delete(id);

        return "Deleted Successfully";
    }
}