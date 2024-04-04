package jfs.backend.bms.booking.service.exception;

public class SeatAlreadyBookedException extends RuntimeException {

	public SeatAlreadyBookedException() {
		super("Provided Seats are Already Booked please select another seat......!");
	}
}
