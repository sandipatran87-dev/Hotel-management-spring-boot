package com.cs.demo.service;


import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.Supplier;
import com.cs.demo.repo.SupplierRepository;

@Service
public class SupplierService {

    private final SupplierRepository repo;

    public SupplierService(
            SupplierRepository repo) {

        this.repo = repo;
    }

    public Supplier save(Supplier supplier) {
        return repo.save(supplier);
    }

    public List<Supplier> getAll() {
        return repo.findAll();
    }

    public Supplier getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public Supplier update(
            UUID id,
            Supplier supplier) {

        Supplier s =
                repo.findById(id)
                .orElseThrow();

        s.setSupplierName(
                supplier.getSupplierName());

        s.setMobile(
                supplier.getMobile());

        s.setEmail(
                supplier.getEmail());

        s.setAddress(
                supplier.getAddress());

        return repo.save(s);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}