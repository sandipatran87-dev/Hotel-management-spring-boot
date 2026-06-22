package com.cs.demo.service;



import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.Staff;
import com.cs.demo.repo.StaffRepository;

@Service
public class StaffService {

    private final StaffRepository repo;

    public StaffService(StaffRepository repo) {
        this.repo = repo;
    }

    public Staff save(Staff staff) {

        if(staff.getStatus() == null) {
            staff.setStatus("ACTIVE");
        }

        return repo.save(staff);
    }

    public List<Staff> getAll() {
        return repo.findAll();
    }

    public Staff getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public Staff update(UUID id, Staff staff) {

        Staff s = repo.findById(id)
                .orElseThrow();

        s.setRole(staff.getRole());
        s.setFirstName(staff.getFirstName());
        s.setLastName(staff.getLastName());
        s.setGender(staff.getGender());
        s.setMobile(staff.getMobile());
        s.setEmail(staff.getEmail());
        s.setSalary(staff.getSalary());
        s.setJoiningDate(staff.getJoiningDate());
        s.setStatus(staff.getStatus());

        return repo.save(s);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}