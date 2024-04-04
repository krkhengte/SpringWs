package jfs.backend.bms.payment.service.Service;

import java.util.List;

import jfs.backend.bms.payment.service.payload.PaymentDto;
import jfs.backend.bms.payment.service.paymentResponce.PaymentResponse;

public interface PaymentService {

	public PaymentResponse makePayment(PaymentDto paymentDto);
	
	public String chekPaymentStatus(String paymentId);
	
	public PaymentDto getPaymentDetailsByBookingId(String bookingId);
}
