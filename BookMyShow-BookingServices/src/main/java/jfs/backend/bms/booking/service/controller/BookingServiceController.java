package jfs.backend.bms.booking.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.bms.booking.service.ApiResponse.ApiResponse;
import jfs.backend.bms.booking.service.Service.BookingService;
import jfs.backend.bms.booking.service.payload.BookingDto;

@RestController
@RequestMapping("booking")
public class BookingServiceController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/createBooking")
	public ResponseEntity<ApiResponse> createBooking(@RequestBody BookingDto bookingDto) {

		ApiResponse apiResponse = this.bookingService.createBooking(bookingDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);

	} 

	@GetMapping("/getAllBookings")
	public ResponseEntity<List<BookingDto>> getAllBookings() {

		List<BookingDto> allBooking = this.bookingService.getAllBooking();

		return ResponseEntity.status(HttpStatus.CREATED).body(allBooking);
	}
	
	@GetMapping("getBookingByUserId/{userId}")
	public ResponseEntity<List<BookingDto>> getBookingByUserId(@PathVariable String userId){
		
		List<BookingDto> bookingByUserId = this.bookingService.getBookingByUserId(userId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingByUserId);
		
	}
}
