package jfs.backend.bms.ticket.service.Service.Impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import jfs.backend.bms.ticket.service.Service.TicketService;
import jfs.backend.bms.ticket.service.entity.Ticket;
import jfs.backend.bms.ticket.service.exception.ResourceNotFoundException;
import jfs.backend.bms.ticket.service.payload.TicketDto;
import jfs.backend.bms.ticket.service.repo.TicketServiceRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketServiceRepository ticketServiceRepository;

	@Override
	public TicketDto createTicket(TicketDto ticketDto) {

		ticketDto.setTicketId(UUID.randomUUID().toString());

		Ticket ticket = new Ticket();

		BeanUtils.copyProperties(ticketDto, ticket);

		ticketServiceRepository.save(ticket);

		TicketDto ticketDto2 = new TicketDto();

		BeanUtils.copyProperties(ticket, ticketDto2);

		return ticketDto2;
	}

	@Override
	public List<TicketDto> getAllTickeByBookingId(String bookingId) {

		List<Ticket> findByBookingId = this.ticketServiceRepository.findByBookingId(bookingId);

		List<TicketDto> ticketDtosList = new ArrayList();

		for (Ticket ticket : findByBookingId) {

			TicketDto ticketDto = new TicketDto();

			BeanUtils.copyProperties(ticket, ticketDto);

			ticketDtosList.add(ticketDto);

		}

		return ticketDtosList;

	}

	@Override
	public List<TicketDto> getAllTicket() {
		List<Ticket> ticketList = this.ticketServiceRepository.findAll();

		List<TicketDto> ticketDtosList = new ArrayList();

		for (Ticket ticket : ticketList) {

			TicketDto ticketDto = new TicketDto();

			BeanUtils.copyProperties(ticket, ticketDto);

			ticketDtosList.add(ticketDto);

		}

		return ticketDtosList;
	}

	@Override
	public TicketDto getTicketById(String ticketId) {

		Ticket ticket = this.ticketServiceRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Ticket", "TicketId", ticketId));

		TicketDto ticketDt = new TicketDto();

		BeanUtils.copyProperties(ticket, ticketDt);
		return ticketDt;
	}

	@Override
	public TicketDto updateTicket(String ticketId, TicketDto ticketDto) {

		Ticket ticket = this.ticketServiceRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Ticket", "TicketId", ticketId));

		Ticket ticket2 = new Ticket();

		ticket2.setMovieId(ticket.getMovieId());
		ticket2.setSeatNumber(ticket.getSeatNumber());
		ticket2.setShowTimeId(ticket.getShowTimeId());
		ticket2.setTheaterId(ticket.getTheaterId());
		ticket2.setTicketCategory(ticket.getTicketCategory());
		ticket2.setTicketDate(ticket.getTicketDate());
		ticket2.setTicketId(ticketId);
		ticket2.setBookingId(ticketDto.getBookingId());
		ticket2.setUserId(ticketDto.getUserId());
		ticket2.setBookingStatus("Booked");

		this.ticketServiceRepository.save(ticket2);

		TicketDto ticketDto2 = new TicketDto();

		BeanUtils.copyProperties(ticket2, ticketDto2);

		return ticketDto2;
	}

	@Override
	public TicketDto updateSpecificField(String ticketId, Map<String, Object> fields) {

		Ticket ticket = this.ticketServiceRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Ticket", "TicketId", ticketId));
		fields.forEach((key, value) -> {
			Field field = org.springframework.util.ReflectionUtils.findField(Ticket.class, key);
			Optional<Field> optionalField = Optional.ofNullable(field);
			if (optionalField.isPresent()) {
				field.setAccessible(true);
				ReflectionUtils.setField(field, ticket, value);
			} else {
				// Handle the case where the field is not found.
				// You may want to log a warning or throw an exception.
				System.err.println("Field not found: " + key);
			}
		});
		Ticket savedTicket = ticketServiceRepository.save(ticket);
		TicketDto ticketDto = new TicketDto();
		BeanUtils.copyProperties(savedTicket, ticketDto);
		return ticketDto;

	}

	@Override
	public List<TicketDto> getAllTicketList(String ticketId,String movieId,String theaterId,String bookingId) {
		
		System.out.println("ticket Id"+ticketId);
		System.out.println(movieId);
		System.out.println(theaterId);
		System.out.println(bookingId);
		
		
		Ticket ticket=new Ticket();
		ticket.setTicketId(ticketId);
		ticket.setMovieId(movieId);
		ticket.setTheaterId(theaterId);
		ticket.setBookingId(bookingId);
		
		Example<Ticket> of = Example.of(ticket);
		
		List<Ticket> findAll = ticketServiceRepository.findAll(of);
		
		findAll.stream().forEach((s)->System.out.println(s));
		
		List<TicketDto> ticketDtos=new ArrayList<>();
			
		for(Ticket t1: findAll) {
			
			TicketDto ticketDto3=new TicketDto();
			
			BeanUtils.copyProperties(t1, ticketDto3);
			ticketDtos.add(ticketDto3);
		}
		
		
		return ticketDtos;
	}





}
