package com.cs.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.WaiterAssignment;
import com.cs.demo.repo.WaiterAssignmentRepository;

@Service
public class WaiterAssignmentService {

    private final WaiterAssignmentRepository repo;

    public WaiterAssignmentService(
            WaiterAssignmentRepository repo) {

        this.repo = repo;
    }

    public WaiterAssignment save(
            WaiterAssignment assignment) {

        return repo.save(assignment);
    }

    public List<WaiterAssignment> getAll() {
        return repo.findAll();
    }

    public WaiterAssignment getById(UUID id) {

        return repo.findById(id)
                .orElse(null);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}