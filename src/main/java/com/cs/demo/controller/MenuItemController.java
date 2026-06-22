package com.cs.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.MenuItem;
import com.cs.demo.service.MenuItemService;

@RestController
@CrossOrigin("*")
@RequestMapping("/menu-items")
public class MenuItemController {

    private final MenuItemService service;

    public MenuItemController(
            MenuItemService service) {

        this.service = service;
    }

    @PostMapping
    public MenuItem save(
            @RequestBody MenuItem item) {

        return service.save(item);
    }

    @GetMapping
    public List<MenuItem> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public MenuItem getById(
            @PathVariable("id") UUID id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public MenuItem update(
            @PathVariable("id") UUID id,
            @RequestBody MenuItem item) {

        return service.update(id, item);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") UUID id) {

        service.delete(id);
    }
}