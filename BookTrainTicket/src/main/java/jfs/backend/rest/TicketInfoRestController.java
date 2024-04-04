package jfs.backend.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.binding.PassengerInfo;
import jfs.backend.binding.TicketInfo;

@RestController
public class TicketInfoRestController {

	@PostMapping(value = "/bookTicket" ,produces = {"application/json"},consumes = {"application/json"})
	public ResponseEntity<TicketInfo> bookTicket(@RequestBody PassengerInfo passengerInfo){
		
		System.out.println(passengerInfo);
		
		// Logic 
		
		TicketInfo ticketInfo=new TicketInfo();
		ticketInfo.setTicketPrice(4000);
		ticketInfo.setPRN("LPG394572S");
		ticketInfo.setStatus("Confirmed");
		
		return new ResponseEntity<TicketInfo>(ticketInfo, HttpStatus.CREATED);

	}
	
	@PutMapping("/bookTicket" )
	public ResponseEntity<String> updateTicket(@RequestBody PassengerInfo passengerInfo){
		
		System.out.println(passengerInfo);
		
		// Logic to Update Ticket
		
		return new ResponseEntity<>("Ticket Updated",HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{ticketPrice}")
	public ResponseEntity<String> deletTicketId(@PathVariable("ticketPrice")Integer ticketPrice){
		
		System.out.println(ticketPrice);
		
		// Logic For Delete TicketId
		
		return new ResponseEntity<String>("TicketPrice Deleted",HttpStatus.OK);
	}
	
}
