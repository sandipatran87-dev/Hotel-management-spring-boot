package com.cs.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.MenuItem;
import com.cs.demo.entity.OrderItem;
import com.cs.demo.repo.MenuItemRepository;
import com.cs.demo.repo.OrderItemRepository;

@Service
public class OrderItemService {

    private final OrderItemRepository repo;
    private final MenuItemRepository menuRepo;

    public OrderItemService(
            OrderItemRepository repo,
            MenuItemRepository menuRepo) {

        this.repo = repo;
        this.menuRepo = menuRepo;
    }

    public OrderItem save(OrderItem orderItem) {

        MenuItem menuItem =
                menuRepo.findById(
                        orderItem.getItem().getItemId())
                        .orElseThrow();

        orderItem.setUnitPrice(
                menuItem.getPrice());

        orderItem.setSubtotal(
                menuItem.getPrice()
                * orderItem.getQuantity());

        return repo.save(orderItem);
    }

    public List<OrderItem> getAll() {
        return repo.findAll();
    }

    public OrderItem getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}