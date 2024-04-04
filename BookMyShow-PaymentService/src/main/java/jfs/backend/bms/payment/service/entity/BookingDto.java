package jfs.backend.bms.payment.service.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;

public class BookingDto {

	private String bookingId;
    private String userId;
    private String theaterId;
    private String showTimeId;
    private String movieId;
    private String foodId;
    private Double totalAmount;
    private String status;
    private List<String> seats;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createDate;
    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDate updatedDate;
    private List<String> tickets;
}
