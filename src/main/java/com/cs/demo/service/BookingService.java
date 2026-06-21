package com.cs.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs.demo.entity.Bill;
import com.cs.demo.entity.Booking;
import com.cs.demo.entity.Room;
import com.cs.demo.repo.BillRepository;
import com.cs.demo.repo.BookingRepository;
import com.cs.demo.repo.RoomRepository;

@Service
public class BookingService {

    private final BookingRepository repository;
    private final RoomRepository roomRepository;
    private final BillRepository billRepository;

    public BookingService(
            BookingRepository repository,
            RoomRepository roomRepository,
            BillRepository billRepository) {

        this.repository = repository;
        this.roomRepository = roomRepository;
        this.billRepository = billRepository;
    }

    // Save Booking
    public Booking save(Booking booking) {

        Room room = roomRepository.findById(
                booking.getRoom().getRoomId())
                .orElseThrow();

        if ("BOOKED".equals(room.getRoomStatus())) {

            throw new RuntimeException(
                    "Room Already Booked");
        }

        room.setRoomStatus("BOOKED");

        roomRepository.save(room);

        booking.setRoom(room);

        return repository.save(booking);
    }

    // Get All Bookings
    public List<Booking> getAll() {
        return repository.findAll();
    }

    // Get Booking By Id
    public Booking getById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    // Delete Booking
    public void delete(UUID id) {

        Booking booking = getById(id);

        if (booking == null) {

            throw new RuntimeException(
                    "Booking Not Found");
        }

        Room room = booking.getRoom();

        room.setRoomStatus("AVAILABLE");

        roomRepository.save(room);

        repository.deleteById(id);
    }

    // Checkout Booking
    public Booking checkout(UUID id) {

        Booking booking =
                repository.findById(id)
                .orElseThrow();

        Room room = booking.getRoom();

        room.setRoomStatus("AVAILABLE");

        roomRepository.save(room);

        booking.setBookingStatus(
                "CHECKED_OUT");

        Booking savedBooking =
                repository.save(booking);

        // Auto Generate Bill

        Bill bill = new Bill();

        bill.setCustomer(
                booking.getCustomer());

        bill.setBooking(
                booking);

        double subtotal =
                booking.getTotalAmount();

        double tax =
                subtotal * 0.18;

        double grandTotal =
                subtotal + tax;

        bill.setSubtotal(subtotal);
        bill.setTaxAmount(tax);
        bill.setGrandTotal(grandTotal);

        bill.setBillStatus("UNPAID");

        billRepository.save(bill);

        return savedBooking;
    }

    // Update Booking
    public Booking update(UUID id,
            Booking booking) {

        Booking existing =
                getById(id);

        existing.setCustomer(
                booking.getCustomer());

        existing.setRoom(
                booking.getRoom());

        existing.setCheckInDate(
                booking.getCheckInDate());

        existing.setCheckOutDate(
                booking.getCheckOutDate());

        existing.setTotalDays(
                booking.getTotalDays());

        existing.setBookingStatus(
                booking.getBookingStatus());

        return repository.save(existing);
    }
}