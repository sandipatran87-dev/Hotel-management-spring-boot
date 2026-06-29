package com.cs.demo.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "online_bookings")
public class OnlineBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "online_booking_id")
    private UUID onlineBookingId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "booking_source")
    private String bookingSource;

    @CreationTimestamp
    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

    @Column(name = "booking_status")
    private String bookingStatus;

    public UUID getOnlineBookingId() {
        return onlineBookingId;
    }

    public void setOnlineBookingId(UUID onlineBookingId) {
        this.onlineBookingId = onlineBookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getBookingSource() {
        return bookingSource;
    }

    public void setBookingSource(String bookingSource) {
        this.bookingSource = bookingSource;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}