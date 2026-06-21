package com.cs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.demo.dto.DashboardSummary;
import com.cs.demo.repo.BillRepository;
import com.cs.demo.repo.BookingRepository;
import com.cs.demo.repo.CustomerRepository;
import com.cs.demo.repo.RoomRepository;

@Service
public class DashboardService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private BillRepository billRepo;

    // Total Customers
    public Long totalCustomers() {
        return customerRepo.count();
    }

    // Total Bookings
    public Long totalBookings() {
        return bookingRepo.count();
    }

    // Total Revenue
    public Double totalRevenue() {
        return billRepo.totalRevenue();
    }

    // Available Rooms
    public Long availableRooms() {
        return roomRepo.availableRooms();
    }

    // Occupied Rooms
    public Long occupiedRooms() {
        return roomRepo.occupiedRooms();
    }

    // Dashboard Summary
    public DashboardSummary getSummary() {

        DashboardSummary dto = new DashboardSummary();

        dto.setTotalCustomers(
                customerRepo.count());

        dto.setTotalBookings(
                bookingRepo.count());

        dto.setAvailableRooms(
                roomRepo.availableRooms());

        dto.setOccupiedRooms(
                roomRepo.occupiedRooms());

        dto.setTotalRevenue(
                billRepo.totalRevenue());

        return dto;
    }
}