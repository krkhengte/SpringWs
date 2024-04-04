package jfs.backend.bms.ticket.service.Service;

import java.util.List;
import java.util.Map;

import jfs.backend.bms.ticket.service.payload.TicketDto;


public interface TicketService {
	
	public TicketDto createTicket(TicketDto ticketDto);
	
	public List<TicketDto> getAllTicket();
	
	public List<TicketDto> getAllTickeByBookingId(String bookingId);
	
	public TicketDto getTicketById(String ticketId);
	
	public TicketDto updateTicket(String tickeId, TicketDto ticketDto);
	
	public List<TicketDto> getAllTicketList(String ticketId,String movieId,String theaterId,String bookingId);
	
	public TicketDto updateSpecificField(String ticketId, Map<String, Object> fields);

	
}
