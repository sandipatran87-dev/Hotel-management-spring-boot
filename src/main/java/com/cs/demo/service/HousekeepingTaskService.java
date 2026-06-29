package com.cs.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.HousekeepingTask;
import com.cs.demo.repo.HousekeepingTaskRepository;

@Service
public class HousekeepingTaskService {

    private final HousekeepingTaskRepository repo;

    public HousekeepingTaskService(
            HousekeepingTaskRepository repo) {

        this.repo = repo;
    }

    public HousekeepingTask save(HousekeepingTask task) {

        if(task.getTaskStatus() == null) {
            task.setTaskStatus("PENDING");
        }

        if(task.getTaskDate() == null) {
            task.setTaskDate(LocalDateTime.now());
        }

        return repo.save(task);
    }

    public List<HousekeepingTask> getAll() {
        return repo.findAll();
    }

    public HousekeepingTask getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public HousekeepingTask update(UUID id,
            HousekeepingTask task) {

        HousekeepingTask h =
                repo.findById(id).orElseThrow();

        h.setRoom(task.getRoom());
        h.setAssignedStaff(task.getAssignedStaff());
        h.setTaskStatus(task.getTaskStatus());
        h.setTaskDate(task.getTaskDate());
        h.setRemarks(task.getRemarks());

        return repo.save(h);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

}