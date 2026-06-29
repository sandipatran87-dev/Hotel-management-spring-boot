package com.cs.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.Discount;
import com.cs.demo.service.DiscountService;

@RestController
@RequestMapping("/discounts")
@CrossOrigin("*")
public class DiscountController {

    private final DiscountService service;

    public DiscountController(DiscountService service) {
        this.service = service;
    }

    @PostMapping
    public Discount save(@RequestBody Discount discount) {
        return service.save(discount);
    }

    @GetMapping
    public List<Discount> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Discount getById(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Discount update(
            @PathVariable UUID id,
            @RequestBody Discount discount) {

        return service.update(id, discount);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {

        service.delete(id);

        return "Deleted Successfully";
    }

}