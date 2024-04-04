package jfs.backend.bms.booking.service.exception;

public class DuplicateSeatBookException  extends RuntimeException{

	public DuplicateSeatBookException() {
		super("Seats are already Booked");
	}
}
