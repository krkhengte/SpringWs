package jfs.backend.bms.booking.service.ApiResponse;

import java.time.LocalDate;
import java.util.List;

import jfs.backend.bms.booking.service.entity.TicketDto;
import jfs.backend.bms.booking.service.payload.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

	private String bookingId;
	private String userId;
	private String fullName;
	private String userName;
	private String userEmail;
	private String movieName;
	private String poster;
	private String location;
	private String theaterName;
	private List<String> bookedSeat;
	private List<TicketDto> bookedtickets;
	private String startTime;
	private String food;
	private Double foodPrice;
    private LocalDate createDate;
	private Double totalAmmount;
	private String paymentId;
	private String paymentStatus;
	private String ticketStatus;

	
}
