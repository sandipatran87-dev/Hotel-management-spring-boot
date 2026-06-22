package com.cs.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.demo.entity.MenuCategory;
import com.cs.demo.repo.MenuCategoryRepository;

@Service
public class MenuCategoryService {

    @Autowired
    private MenuCategoryRepository repo;

    public MenuCategory save(MenuCategory category) {
        return repo.save(category);
    }

    public List<MenuCategory> getAll() {
        return repo.findAll();
    }
}