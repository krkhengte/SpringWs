package jfs.backend.bms.user.service.externalServices;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jfs.backend.bms.user.service.entity.TicketDto;



@FeignClient("TICKET-SERVICE")
public interface TicketService {
	
	@PutMapping("/tickets/updateTickte/{ticketId}")
	public TicketDto updateTicket(@PathVariable("ticketId") String ticketId, @RequestBody TicketDto ticketDto);
	
	
//	@PatchMapping(value = "/updateTickte/{ticketId}",consumes = {"multipart/form-data","application/json","application/xml"})
//    public TicketDto updateSpecificField(@PathVariable ("ticketId") String ticketId,@RequestBody Map<String,Object> objectMap);

	
	@GetMapping("/tickets/getAllTicketByBookingId/{bookingId}")
	public List<TicketDto> getAllTicketByBookingId(@PathVariable String bookingId);
	
}
