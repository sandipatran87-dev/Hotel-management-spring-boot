package com.cs.demo.controller;



import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.Notification;
import com.cs.demo.service.NotificationService;

@RestController
@RequestMapping("/notifications")
@CrossOrigin("*")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public Notification save(
            @RequestBody Notification notification) {

        return service.save(notification);
    }

    @GetMapping
    public List<Notification> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Notification getById(
            @PathVariable("id") UUID id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Notification update(
            @PathVariable("id") UUID id,
            @RequestBody Notification notification) {

        return service.update(id, notification);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable("id") UUID id) {

        service.delete(id);

        return "Deleted Successfully";
    }
}