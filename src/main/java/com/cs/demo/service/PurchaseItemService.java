package com.cs.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.InventoryItem;
import com.cs.demo.entity.PurchaseItem;
import com.cs.demo.repo.InventoryItemRepository;
import com.cs.demo.repo.PurchaseItemRepository;

@Service
public class PurchaseItemService {

    private final PurchaseItemRepository repo;
    private final InventoryItemRepository inventoryRepo;

    public PurchaseItemService(
            PurchaseItemRepository repo,
            InventoryItemRepository inventoryRepo) {

        this.repo = repo;
        this.inventoryRepo = inventoryRepo;
    }

    public PurchaseItem save(PurchaseItem item) {

        item.setSubtotal(
                item.getQuantity() *
                item.getUnitPrice());

        PurchaseItem saved = repo.save(item);

        InventoryItem inv =
                inventoryRepo.findById(
                        item.getInventoryItem()
                        .getInventoryId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Inventory Item Not Found"));

        inv.setQuantity(
                inv.getQuantity() +
                item.getQuantity());

        inventoryRepo.save(inv);

        return saved;
    }

    public List<PurchaseItem> getAll() {
        return repo.findAll();
    }

    public PurchaseItem getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}