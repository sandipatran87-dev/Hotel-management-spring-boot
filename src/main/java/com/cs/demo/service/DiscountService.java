package com.cs.demo.service;


import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.Discount;
import com.cs.demo.repo.DiscountRepository;

@Service
public class DiscountService {

    private final DiscountRepository repo;

    public DiscountService(DiscountRepository repo) {
        this.repo = repo;
    }

    public Discount save(Discount discount) {

        if(discount.getIsActive() == null) {
            discount.setIsActive(true);
        }

        return repo.save(discount);
    }

    public List<Discount> getAll() {
        return repo.findAll();
    }

    public Discount getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public Discount update(UUID id, Discount discount) {

        Discount d = repo.findById(id).orElseThrow();

        d.setDiscountName(discount.getDiscountName());
        d.setDiscountType(discount.getDiscountType());
        d.setDiscountValue(discount.getDiscountValue());
        d.setIsActive(discount.getIsActive());

        return repo.save(d);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

}