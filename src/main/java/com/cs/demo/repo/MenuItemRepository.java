package com.cs.demo.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.entity.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, UUID> {

}