package com.cs.demo.service;


import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.Role;
import com.cs.demo.repo.RoleRepository;

@Service
public class RoleService {

    private final RoleRepository repo;

    public RoleService(RoleRepository repo) {
        this.repo = repo;
    }

    public List<Role> getAll() {
        return repo.findAll();
    }

    public Role getById(UUID id) {
        return repo.findById(id).orElse(null);
    }
}