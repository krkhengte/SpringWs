package jfs.backend.bms.ticket.service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.bms.ticket.service.Service.TicketService;
import jfs.backend.bms.ticket.service.entity.BookingDto;
import jfs.backend.bms.ticket.service.payload.TicketDto;


@RestController
@RequestMapping("tickets")
public class TicketServiceController {

	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/createTicket")
	public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto){
		
		TicketDto createTicket = this.ticketService.createTicket(ticketDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createTicket);
	}
	
	
	@GetMapping("/getAllTickets")
	public ResponseEntity<List<TicketDto>> getAllTickets(){
		
		List<TicketDto> allTicket = this.ticketService.getAllTicket();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(allTicket);
	}
	
		
	@GetMapping("/getAllTicketsList/{ticketId}/{movieId}/{theaterId}/{bookingId}")
	public ResponseEntity<List<TicketDto>> getAllTicketList(@PathVariable String ticketId,@PathVariable String movieId, @PathVariable String theaterId,@PathVariable String bookingId){
		
		List<TicketDto> allTicket = this.ticketService.getAllTicketList(ticketId,movieId,theaterId,bookingId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(allTicket);
	}
	
	@GetMapping("/getAllTicketByBookingId/{bookingId}")
	public ResponseEntity<List<TicketDto>> getAllTicketByBookingId(@PathVariable String bookingId){
		
		List<TicketDto> allTickeByBookingId = this.ticketService.getAllTickeByBookingId(bookingId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(allTickeByBookingId);
	}
	
	@GetMapping("/getTicketById/{ticketId}")
	public ResponseEntity<TicketDto> getTicketById(@PathVariable String ticketId){
		
		TicketDto ticketById = this.ticketService.getTicketById(ticketId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ticketById);
		
	}
	
	@PutMapping("/updateTickte/{ticketId}")
	public ResponseEntity<TicketDto> updateTicket(@PathVariable String ticketId, @RequestBody TicketDto ticketDto){
		
		TicketDto updateTicket = this.ticketService.updateTicket(ticketId, ticketDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(updateTicket);
		
	}
	
	
	@PatchMapping(value = "/updateTickte/{ticketId}",consumes = {"multipart/form-data","application/json","application/xml"})
    public ResponseEntity<TicketDto> updateSpecificField(@PathVariable ("ticketId") String ticketId,@RequestBody Map<String,Object> objectMap){
        System.out.println (objectMap.isEmpty ());
        TicketDto updatedTicketDto = this.ticketService.updateSpecificField(ticketId,objectMap );
        return ResponseEntity.ok(updatedTicketDto);
	}
}
