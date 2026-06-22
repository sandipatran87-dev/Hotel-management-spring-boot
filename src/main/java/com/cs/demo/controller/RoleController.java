package com.cs.demo.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.Role;
import com.cs.demo.service.RoleService;

@RestController
@RequestMapping("/roles")
@CrossOrigin("*")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Role> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Role getById(
            @PathVariable("id") UUID id) {

        return service.getById(id);
    }
}