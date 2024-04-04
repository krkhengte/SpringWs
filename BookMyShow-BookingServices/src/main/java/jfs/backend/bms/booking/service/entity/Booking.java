package jfs.backend.bms.booking.service.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jfs.backend.bms.booking.service.payload.Ticket;
import lombok.Data;

@Entity
@Data
public class Booking {

	@Id
	private String bookingId;
    private String userId;
    private String theaterId;
    private String showTimeId;
    private String movieId;
    private String foodId;
    private Double totalAmount;
    private String status;
    private String paymentId;
    private List<String> seats;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createDate;
    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDate updatedDate;
    private List<String> tickets;
    
    


	
}
