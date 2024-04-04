package jfs.backend.bms.payment.service.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jfs.backend.bms.payment.service.Service.PaymentService;
import jfs.backend.bms.payment.service.entity.Payment;
import jfs.backend.bms.payment.service.exception.ResourceNotFoundException;
import jfs.backend.bms.payment.service.payload.PaymentDto;
import jfs.backend.bms.payment.service.paymentResponce.PaymentResponse;
import jfs.backend.bms.payment.service.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository; 

	@Override
	public PaymentResponse makePayment(PaymentDto paymentDto) {
	
		String paymentId = UUID.randomUUID().toString();
		
		paymentDto.setPaymentId(paymentId);
		
		PaymentResponse pResponse=new PaymentResponse();
		
		pResponse.setAmmount(paymentDto.getAmmount());
		pResponse.setBookingId(paymentDto.getBookingId());
		pResponse.setLocalDateTime(paymentDto.getLocalDateTime());
		pResponse.setPaymentId(paymentId);
		pResponse.setPaymentStatus(paymentDto.getPaymentStatus());
		pResponse.setUserId(paymentDto.getUserId());
		
		Payment payment=new Payment();
		
		BeanUtils.copyProperties(paymentDto, payment);
		
		this.paymentRepository.save(payment);
		
		return pResponse;
	}

	@Override
	public String chekPaymentStatus(String paymentId) {
		
		Payment payment = this.paymentRepository.findById(paymentId).orElseThrow(()-> new ResourceNotFoundException("Payment", "paymentId", paymentId));
		
		if (payment.getPaymentStatus().equals("Payment Done Successfully...!")) {
			
			return "Payment Done Successfully....!";
		}
		return "Payment Failed.....!";
	}

	@Override
	public PaymentDto getPaymentDetailsByBookingId(String bookingId) {
		
		Payment payment = paymentRepository.findByBookingId(bookingId);
		
		PaymentDto paymentDto=new PaymentDto();
		
		BeanUtils.copyProperties(payment, paymentDto);
		
		return paymentDto;
	}

}
