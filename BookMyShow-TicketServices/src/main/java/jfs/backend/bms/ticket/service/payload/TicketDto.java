package jfs.backend.bms.ticket.service.payload;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {

	private String ticketId;
	private String bookingId;
	private String userId;
	private String movieId;
	private String theaterId;
	private String showTimeId;
	private String seatNumber;
	private String ticketCategory;
	private String bookingStatus;
	private LocalDate ticketDate;
}
