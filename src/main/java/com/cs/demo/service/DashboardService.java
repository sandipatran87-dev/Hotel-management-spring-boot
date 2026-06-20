package com.cs.demo.service;

import com.cs.demo.dto.DashboardSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.demo.repo.BookingRepository;
import com.cs.demo.repo.CustomerRepository;
import com.cs.demo.repo.PaymentRepository;
import com.cs.demo.repo.RoomRepository;

@Service
public class DashboardService {

	@Autowired
	private CustomerRepository customerRepo;

	public Long totalCustomers() {
	    return customerRepo.totalCustomers();
	}
	
	
	@Autowired
	private BookingRepository bookingRepo;

	public Long totalBookings() {
	    return bookingRepo.totalBookings();
	}
	
	
	@Autowired
	private PaymentRepository paymentRepo;

	public Double totalRevenue() {
	    return paymentRepo.totalRevenue();
	}
	
	@Autowired
	private RoomRepository roomRepo;

	public Long availableRooms() {
	    return roomRepo.availableRooms();
	}
	
	public Long occupiedRooms() {
	    return roomRepo.occupiedRooms();
	}
	
	public DashboardSummary getSummary() {

	    DashboardSummary dto = new DashboardSummary();

	    dto.setTotalCustomers(customerRepo.count());
	    dto.setTotalBookings(bookingRepo.count());

	    dto.setAvailableRooms(roomRepo.availableRooms());
	    dto.setOccupiedRooms(roomRepo.occupiedRooms());

	    dto.setTotalRevenue(paymentRepo.totalRevenue());

	    return dto;
	}
	
}
