package com.cs.demo.repo;




import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cs.demo.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    @Query("""
        SELECT COALESCE(SUM(p.amount),0)
        FROM Payment p
        WHERE p.paymentStatus='SUCCESS'
    """)
    Double totalRevenue();
    boolean existsByBill_BillId(UUID billId);
}