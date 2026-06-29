package com.cs.demo.service;


import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.Feedback;
import com.cs.demo.repo.FeedbackRepository;

@Service
public class FeedbackService {

    private final FeedbackRepository repo;

    public FeedbackService(FeedbackRepository repo) {
        this.repo = repo;
    }

    public Feedback save(Feedback feedback) {
        return repo.save(feedback);
    }

    public List<Feedback> getAll() {
        return repo.findAll();
    }

    public Feedback getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public Feedback update(UUID id, Feedback feedback) {

        Feedback f = repo.findById(id).orElseThrow();

        f.setCustomer(feedback.getCustomer());
        f.setBill(feedback.getBill());
        f.setRating(feedback.getRating());
        f.setComments(feedback.getComments());

        return repo.save(f);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}