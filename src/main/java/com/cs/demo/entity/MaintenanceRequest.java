package com.cs.demo.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "maintenance_requests")
public class MaintenanceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "maintenance_id")
    private UUID maintenanceId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "reported_by")
    private Staff reportedBy;

    @Column(name = "issue_description")
    private String issueDescription;

    @Column(name = "request_status")
    private String requestStatus;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public UUID getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(UUID maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Staff getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(Staff reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}