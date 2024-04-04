package jfs.backend.bms.booking.service.ApiResponse;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

	private String paymentId;
	private String bookingId;
	private String userId;
	private Double ammount;
	private String paymentStatus;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime localDateTime;
}
