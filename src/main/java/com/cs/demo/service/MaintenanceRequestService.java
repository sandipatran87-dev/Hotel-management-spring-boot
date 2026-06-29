package com.cs.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.MaintenanceRequest;
import com.cs.demo.repo.MaintenanceRequestRepository;

@Service
public class MaintenanceRequestService {

    private final MaintenanceRequestRepository repo;

    public MaintenanceRequestService(MaintenanceRequestRepository repo) {
        this.repo = repo;
    }

    // SAVE
    public MaintenanceRequest save(MaintenanceRequest request) {

        // Default Status
        if (request.getRequestStatus() == null ||
            request.getRequestStatus().trim().isEmpty()) {

            request.setRequestStatus("OPEN");
        }

        return repo.save(request);
    }

    // GET ALL
    public List<MaintenanceRequest> getAll() {
        return repo.findAll();
    }

    // GET BY ID
    public MaintenanceRequest getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE
    public MaintenanceRequest update(UUID id, MaintenanceRequest request) {

        MaintenanceRequest m = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Maintenance Request Not Found"));

        m.setRoom(request.getRoom());
        m.setReportedBy(request.getReportedBy());
        m.setIssueDescription(request.getIssueDescription());

        if (request.getRequestStatus() == null ||
            request.getRequestStatus().trim().isEmpty()) {

            m.setRequestStatus("OPEN");
        } else {
            m.setRequestStatus(request.getRequestStatus());
        }

        return repo.save(m);
    }

    // DELETE
    public void delete(UUID id) {
        repo.deleteById(id);
    }

}