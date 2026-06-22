package com.cs.demo.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.entity.WaiterAssignment;

public interface WaiterAssignmentRepository extends JpaRepository<WaiterAssignment, UUID> {

	
}