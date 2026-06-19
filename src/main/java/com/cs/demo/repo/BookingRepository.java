package com.cs.demo.repo;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cs.demo.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

	@Query("SELECT COUNT(b) FROM Booking b")
	Long totalBookings();
	
	
}