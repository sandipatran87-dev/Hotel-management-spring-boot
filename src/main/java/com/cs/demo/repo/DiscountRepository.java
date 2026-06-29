package com.cs.demo.repo;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, UUID>{

}