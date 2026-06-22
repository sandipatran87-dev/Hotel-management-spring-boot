package com.cs.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.MenuCategory;
import com.cs.demo.service.MenuCategoryService;

@RestController
@CrossOrigin("*")
public class MenuCategoryController {

    @Autowired
    private MenuCategoryService service;

    @PostMapping("/category")
    public MenuCategory save(
            @RequestBody MenuCategory category) {

        return service.save(category);
    }

    @GetMapping("/category")
    public List<MenuCategory> getAll() {

        return service.getAll();
    }
}