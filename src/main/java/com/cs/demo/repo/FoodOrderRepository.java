package com.cs.demo.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.entity.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, UUID> {

}