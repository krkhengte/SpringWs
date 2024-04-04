package jfs.backend.bms.booking.service.Service;

import java.util.List;

import jfs.backend.bms.booking.service.ApiResponse.ApiResponse;
import jfs.backend.bms.booking.service.payload.BookingDto;

public interface BookingService {

	public ApiResponse createBooking(BookingDto bookingDto);

	public List<BookingDto> getAllBooking();

	public List<BookingDto> getBookingByUserId(String userId);

}
