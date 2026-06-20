package com.cs.demo.dto;

public class DashboardSummary {

    private Long totalCustomers;
    private Long totalBookings;
    private Long availableRooms;
    private Long occupiedRooms;
    private Double totalRevenue;

    public Long getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(Long totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public Long getTotalBookings() {
        return totalBookings;
    }

    public void setTotalBookings(Long totalBookings) {
        this.totalBookings = totalBookings;
    }

    public Long getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(Long availableRooms) {
        this.availableRooms = availableRooms;
    }

    public Long getOccupiedRooms() {
        return occupiedRooms;
    }

    public void setOccupiedRooms(Long occupiedRooms) {
        this.occupiedRooms = occupiedRooms;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}