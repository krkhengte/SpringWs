package jfs.backend.bms.booking.service.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {


	private String seatNumber;
	private String activeSwitch;
	private String ticketCategory;
}
