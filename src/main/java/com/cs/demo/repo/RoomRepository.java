package com.cs.demo.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cs.demo.entity.Room;

public interface RoomRepository extends JpaRepository<Room, UUID> {

	@Query("""
			SELECT COUNT(r)
			FROM Room r
			WHERE r.roomStatus='AVAILABLE'
			""")
			Long availableRooms();
	
	
	@Query("SELECT COUNT(r) FROM Room r WHERE r.roomStatus='BOOKED'")
	Long occupiedRooms();
	
}