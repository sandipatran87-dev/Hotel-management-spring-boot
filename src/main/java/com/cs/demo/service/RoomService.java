package com.cs.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cs.demo.entity.Room;
import com.cs.demo.repo.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepo;

    public RoomService(RoomRepository roomRepo) {
        this.roomRepo = roomRepo;
    }

    public Room save(Room room) {
        return roomRepo.save(room);
    }

    public List<Room> getAll() {
        return roomRepo.findAll();
    }

    public Room getById(UUID id) {
        return roomRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Room Not Found"));
    }
    
    // Update Room
    public Room update(UUID id, Room room) {

        Room existing = getById(id);

        existing.setRoomType(room.getRoomType());
        existing.setFloorNo(room.getFloorNo());
        existing.setRoomNumber(room.getRoomNumber());
        existing.setRoomStatus(room.getRoomStatus());

        return roomRepo.save(existing);
    }
    
}