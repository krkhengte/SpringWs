package jfs.backend.bms.payment.service.payload;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

	private String paymentId;
	private String bookingId;
	private String userId;
	private Double ammount;
	private String paymentStatus;
	private LocalDateTime localDateTime;
	private String cardHolderName;
	private String cvv;
	private String cardExpiry;
	private String cardNo;
}
