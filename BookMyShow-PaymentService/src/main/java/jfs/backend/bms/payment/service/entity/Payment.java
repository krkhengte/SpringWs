package jfs.backend.bms.payment.service.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Payment {

	@Id
	private String paymentId;
	private String bookingId;
	private String userId;
	private Double ammount;
	private String paymentStatus;
	private String cardHolderName;
	private String cvv;
	private String cardExpiry;
	private String cardNo;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime localDateTime;
	
}
