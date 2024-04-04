package jfs.backend.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.request.PassengerInfo;
import jfs.backend.response.TicketInfo;

@RestController
public class AirIndiaRestController {

	@PostMapping(value = "/bookFlightTicket")
	public ResponseEntity<TicketInfo> bookTicket(@RequestBody PassengerInfo pInfo){
		
		// Logic To Book Ticket
		
		// send ticket Information
		
		TicketInfo ticketInfo=new TicketInfo();
		ticketInfo.setName(pInfo.getFname() + " " + pInfo.getLName());
		ticketInfo.setFrom(pInfo.getFrom());
		ticketInfo.setTo(pInfo.getTo());
		ticketInfo.setTicketStatus("Confirmed..");
		ticketInfo.setTicketPrice("45000.0 INR");
		ticketInfo.setJourneyDate(pInfo.getJourneyDate());
		
		return new ResponseEntity<>(ticketInfo, HttpStatus.CREATED);
		
	}
}
