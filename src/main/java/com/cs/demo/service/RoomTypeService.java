package com.cs.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.RoomType;
import com.cs.demo.repo.RoomTypeRepository;

@Service
public class RoomTypeService {

    private final RoomTypeRepository rmrepo;

    public RoomTypeService(RoomTypeRepository repository) {
        this.rmrepo= repository;
    }

    public RoomType save(RoomType roomType) {
        return rmrepo.save(roomType);
    }

    public List<RoomType> getAll() {
        return rmrepo.findAll();
    }
}