package jfs.backend.bms.user.service.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jfs.backend.bms.user.service.entity.PaymentDto;
import jfs.backend.bms.user.service.entity.PaymentResponse;



@FeignClient("PAYMENT-SERVICE")
public interface PaymentService {
	
	@GetMapping("/payments/getPaymentDetailsByBookingId/{bookingId}")
	public PaymentDto getPaymentDetailsByBookingId(@PathVariable String bookingId);
}
