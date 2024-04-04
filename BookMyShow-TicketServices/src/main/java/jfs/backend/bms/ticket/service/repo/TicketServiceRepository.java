package jfs.backend.bms.ticket.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jfs.backend.bms.ticket.service.entity.BookingDto;
import jfs.backend.bms.ticket.service.entity.Ticket;
import jfs.backend.bms.ticket.service.payload.TicketDto;

public interface TicketServiceRepository extends JpaRepository<Ticket, String>{

	public List<Ticket> findByBookingId(String bookingId);
	
	
	

}
