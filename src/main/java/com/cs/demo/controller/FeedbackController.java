package com.cs.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.Feedback;
import com.cs.demo.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
@CrossOrigin("*")
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @PostMapping
    public Feedback save(
            @RequestBody Feedback feedback) {

        return service.save(feedback);
    }

    @GetMapping
    public List<Feedback> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Feedback getById(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Feedback update(
            @PathVariable("id") UUID id,
            @RequestBody Feedback feedback) {

        return service.update(id, feedback);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable UUID id) {

        service.delete(id);

        return "Deleted Successfully";
    }
}