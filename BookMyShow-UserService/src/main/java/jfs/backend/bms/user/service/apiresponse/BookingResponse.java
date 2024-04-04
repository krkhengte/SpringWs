package jfs.backend.bms.user.service.apiresponse;

import java.time.LocalDate;
import java.util.List;

import jfs.backend.bms.user.service.entity.TicketDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

	private String bookingId;
	private String userId;
	private String fullName;
	private String userEmail;
	private String movieName;
	private String poster;
	private String location;
	private String theaterName;
	private List<TicketDto> bookedtickets;
	private String startTime;
	private Double totalAmmount;
	private String paymentId;
	private String paymentStatus;

}
