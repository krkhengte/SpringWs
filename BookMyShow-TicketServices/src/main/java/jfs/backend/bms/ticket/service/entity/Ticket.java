package jfs.backend.bms.ticket.service.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ticket {

	@Id
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
