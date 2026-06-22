package com.cs.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.MenuItem;
import com.cs.demo.repo.MenuItemRepository;

@Service
public class MenuItemService {

    private final MenuItemRepository repo;

    public MenuItemService(MenuItemRepository repo) {
        this.repo = repo;
    }

    public MenuItem save(MenuItem item) {
        return repo.save(item);
    }

    public List<MenuItem> getAll() {
        return repo.findAll();
    }

    public MenuItem getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

    public MenuItem update(
            UUID id,
            MenuItem item) {

        MenuItem m = getById(id);

        m.setItemName(item.getItemName());
        m.setDescription(item.getDescription());
        m.setPrice(item.getPrice());
        m.setIsAvailable(item.getIsAvailable());
        m.setBrandName(item.getBrandName());
        m.setItemType(item.getItemType());
        m.setServingSize(item.getServingSize());
        m.setCategory(item.getCategory());

        return repo.save(m);
    }
}