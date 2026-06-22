package com.cs.demo.service;


import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.InventoryItem;
import com.cs.demo.repo.InventoryItemRepository;

@Service
public class InventoryItemService {

    private final InventoryItemRepository repo;

    public InventoryItemService(
            InventoryItemRepository repo) {

        this.repo = repo;
    }

    public InventoryItem save(
            InventoryItem item) {

        return repo.save(item);
    }

    public List<InventoryItem> getAll() {
        return repo.findAll();
    }

    public InventoryItem getById(UUID id) {

        return repo.findById(id)
                .orElse(null);
    }

    public InventoryItem update(
            UUID id,
            InventoryItem item) {

        InventoryItem i =
                repo.findById(id)
                .orElseThrow();

        i.setItemName(item.getItemName());
        i.setUnit(item.getUnit());
        i.setQuantity(item.getQuantity());
        i.setReorderLevel(item.getReorderLevel());

        return repo.save(i);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}