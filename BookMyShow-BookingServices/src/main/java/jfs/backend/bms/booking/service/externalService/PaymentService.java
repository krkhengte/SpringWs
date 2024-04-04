package jfs.backend.bms.booking.service.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jfs.backend.bms.booking.service.ApiResponse.PaymentResponse;
import jfs.backend.bms.booking.service.payload.PaymentDto;

@FeignClient("PAYMENT-SERVICE")
public interface PaymentService {
	
	@PostMapping("/payments/makePayment")
	public PaymentResponse processPayment(@RequestBody PaymentDto paymentDto);

}
