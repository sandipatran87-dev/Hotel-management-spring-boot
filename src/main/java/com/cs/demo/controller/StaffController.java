package com.cs.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.Staff;
import com.cs.demo.service.StaffService;

@RestController
@RequestMapping("/staff")
@CrossOrigin("*")
public class StaffController {

    private final StaffService service;

    public StaffController(StaffService service) {
        this.service = service;
    }

    @PostMapping
    public Staff save(@RequestBody Staff staff) {
        return service.save(staff);
    }

    @GetMapping
    public List<Staff> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Staff getById(
            @PathVariable("id") UUID id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Staff update(
            @PathVariable("id") UUID id,
            @RequestBody Staff staff) {

        return service.update(id, staff);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable("id") UUID id) {

        service.delete(id);

        return "Deleted Successfully";
    }
}