package com.cs.demo.service;



import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.RoomType;
import com.cs.demo.repo.RoomTypeRepository;

@Service
public class RoomTypeService {

    private final RoomTypeRepository rmrepo;

    public RoomTypeService(RoomTypeRepository repository) {
        this.rmrepo = repository;
    }

    public RoomType save(RoomType roomType) {
        return rmrepo.save(roomType);
    }

    public List<RoomType> getAll() {
        return rmrepo.findAll();
    }

    public RoomType getById(UUID id) {
        return rmrepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Room Type Not Found"));
    }

    public RoomType update(UUID id, RoomType roomType) {

        RoomType existing = getById(id);

        existing.setTypeName(roomType.getTypeName());
        existing.setDescription(roomType.getDescription());
        existing.setBasePrice(roomType.getBasePrice());
        existing.setMaxCapacity(roomType.getMaxCapacity());

        return rmrepo.save(existing);
    }

    public void delete(UUID id) {
        rmrepo.deleteById(id);
    }
}