package jfs.backend.bms.booking.service.exception;


public class SeatLimitExtends extends RuntimeException{

	public SeatLimitExtends(){
		
		super("You exiced your maximum booking limit your limit is 4");
	}
	
}
