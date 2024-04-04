package jfs.backend.bms.payment.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.bms.payment.service.Service.PaymentService;
import jfs.backend.bms.payment.service.payload.PaymentDto;
import jfs.backend.bms.payment.service.paymentResponce.PaymentResponse;

@RestController
@RequestMapping("payments")
public class PaymentServiceController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/makePayment")
	public ResponseEntity<PaymentResponse> makePayment(@RequestBody PaymentDto paymentDto){
		
		PaymentResponse makePayment = this.paymentService.makePayment(paymentDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(makePayment);
		
	}
	
	@GetMapping("/checkPaymentStatus/{paymentId}")
	public ResponseEntity<String> checkPaymentStatus(@PathVariable String paymentId){
		
		String chekPaymentStatus = this.paymentService.chekPaymentStatus(paymentId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(chekPaymentStatus);
		
	}
	
	@GetMapping("/getPaymentDetailsByBookingId/{bookingId}")
	public ResponseEntity<PaymentDto> getPaymentDetailsByBookingId(@PathVariable String bookingId){
		
		PaymentDto paymentDetailsByBookingId = paymentService.getPaymentDetailsByBookingId(bookingId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(paymentDetailsByBookingId);
	}
}
