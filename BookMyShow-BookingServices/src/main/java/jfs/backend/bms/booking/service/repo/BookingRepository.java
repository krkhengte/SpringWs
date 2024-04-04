package jfs.backend.bms.booking.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jfs.backend.bms.booking.service.entity.Booking;
import jfs.backend.bms.booking.service.payload.BookingDto;

public interface BookingRepository extends JpaRepository<Booking, String> {

	public List<Booking> findByUserId(String userId);
}
