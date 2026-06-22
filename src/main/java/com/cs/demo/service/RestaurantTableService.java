package com.cs.demo.service;


import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.RestaurantTable;
import com.cs.demo.repo.RestaurantTableRepository;

@Service
public class RestaurantTableService {

    private final RestaurantTableRepository repo;

    public RestaurantTableService(
            RestaurantTableRepository repo) {

        this.repo = repo;
    }

    public RestaurantTable save(RestaurantTable table) {

        if(table.getTableStatus() == null) {
            table.setTableStatus("AVAILABLE");
        }

        return repo.save(table);
    }

    public List<RestaurantTable> getAll() {
        return repo.findAll();
    }

    public RestaurantTable getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public RestaurantTable update(
            UUID id,
            RestaurantTable table) {

        RestaurantTable t =
                repo.findById(id)
                .orElseThrow();

        t.setTableNumber(table.getTableNumber());
        t.setCapacity(table.getCapacity());
        t.setTableStatus(table.getTableStatus());

        return repo.save(t);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}