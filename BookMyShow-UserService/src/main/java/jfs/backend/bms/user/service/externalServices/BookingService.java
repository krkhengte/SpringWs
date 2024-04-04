package jfs.backend.bms.user.service.externalServices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jfs.backend.bms.user.service.entity.BookingDto;

@FeignClient("BOOKINGS-SERVICE")
public interface BookingService {

	@GetMapping("/booking/getBookingByUserId/{userId}")
	public List<BookingDto> getAllBookingById(@PathVariable("userId") String userId);
	
}
