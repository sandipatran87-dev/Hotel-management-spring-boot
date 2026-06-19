package com.cs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.demo.service.DashboardService;





@RestController
@RequestMapping("/dashboard")
@CrossOrigin("*")
public class DashboardController {

	
	@Autowired
	private DashboardService service;

	@GetMapping("/totalCustomers")
	public Long totalCustomers() {
	    return service.totalCustomers();
	}
	
	
	@GetMapping("/totalBookings")
	public Long totalBookings() {
	    return service.totalBookings();
	}
	
	
	@GetMapping("/totalRevenue")
	public Double totalRevenue() {
	    return service.totalRevenue();
	}
	
	@GetMapping("/availableRooms")
	public Long availableRooms() {
	    return service.availableRooms();
	}
	
	@GetMapping("/occupiedRooms")
	public Long occupiedRooms() {
	    return service.occupiedRooms();
	}
	
	
	
}