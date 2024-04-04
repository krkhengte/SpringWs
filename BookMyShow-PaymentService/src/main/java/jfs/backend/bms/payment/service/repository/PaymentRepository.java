package jfs.backend.bms.payment.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jfs.backend.bms.payment.service.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String>{

	public Payment findByBookingId(String bookingId);
	
}
