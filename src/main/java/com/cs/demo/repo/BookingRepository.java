package com.cs.demo.repo;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

}