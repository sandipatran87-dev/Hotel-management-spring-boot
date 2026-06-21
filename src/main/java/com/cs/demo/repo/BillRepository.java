package com.cs.demo.repo;



import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cs.demo.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, UUID> {

    @Query("""
        SELECT COALESCE(SUM(b.grandTotal), 0)
        FROM Bill b
    """)
    Double totalRevenue();

}