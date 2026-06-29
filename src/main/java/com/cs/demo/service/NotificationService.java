package com.cs.demo.service;



import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.Notification;
import com.cs.demo.repo.NotificationRepository;

@Service
public class NotificationService {

    private final NotificationRepository repo;

    public NotificationService(NotificationRepository repo) {
        this.repo = repo;
    }

    public Notification save(Notification notification) {

        if(notification.getIsRead() == null) {
            notification.setIsRead(false);
        }

        return repo.save(notification);
    }

    public List<Notification> getAll() {
        return repo.findAll();
    }

    public Notification getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public Notification update(UUID id,
            Notification notification) {

        Notification n =
                repo.findById(id).orElseThrow();

        n.setCustomer(notification.getCustomer());
        n.setTitle(notification.getTitle());
        n.setMessage(notification.getMessage());
        n.setIsRead(notification.getIsRead());

        return repo.save(n);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}