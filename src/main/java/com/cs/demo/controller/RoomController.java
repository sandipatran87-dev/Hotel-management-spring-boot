package com.cs.demo.controller;



import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.cs.demo.entity.Room;
import com.cs.demo.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @PostMapping
    public Room save(@RequestBody Room room) {
        return service.save(room);
    }

    @GetMapping
    public List<Room> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Room getById(@PathVariable("id") UUID id) {
        return service.getById(id);
    }
    
  
    
    // Update Room
    @PutMapping("/{id}")
    public Room update(
            @PathVariable("id") UUID id,
            @RequestBody Room room) {

        return service.update(id, room);
    }
    
    
}