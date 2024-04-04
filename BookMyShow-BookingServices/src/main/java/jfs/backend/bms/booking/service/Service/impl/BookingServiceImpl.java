package jfs.backend.bms.booking.service.Service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import jfs.backend.bms.booking.service.ApiResponse.ApiResponse;
import jfs.backend.bms.booking.service.ApiResponse.PaymentResponse;
import jfs.backend.bms.booking.service.Service.BookingService;
import jfs.backend.bms.booking.service.entity.Booking;
import jfs.backend.bms.booking.service.entity.FoodDto;
import jfs.backend.bms.booking.service.entity.MoviesDto;
import jfs.backend.bms.booking.service.entity.ShowTimeDto;
import jfs.backend.bms.booking.service.entity.TheaterDto;
import jfs.backend.bms.booking.service.entity.TicketDto;
import jfs.backend.bms.booking.service.entity.UserDto;
import jfs.backend.bms.booking.service.exception.DuplicateSeatBookException;
import jfs.backend.bms.booking.service.exception.SeatAlreadyBookedException;
import jfs.backend.bms.booking.service.exception.SeatLimitExtends;
import jfs.backend.bms.booking.service.externalService.FoodService;
import jfs.backend.bms.booking.service.externalService.MoviesService;
import jfs.backend.bms.booking.service.externalService.PaymentService;
import jfs.backend.bms.booking.service.externalService.ShowTimeService;
import jfs.backend.bms.booking.service.externalService.TheaterService;
import jfs.backend.bms.booking.service.externalService.TicketService;
import jfs.backend.bms.booking.service.externalService.UserService;
import jfs.backend.bms.booking.service.payload.BookingDto;
import jfs.backend.bms.booking.service.payload.PaymentDto;
import jfs.backend.bms.booking.service.repo.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	Double ticketPrice = 0.00;	

	@Autowired
	private MoviesService moviesService;

	@Autowired
	private TheaterService theaterService;

	@Autowired
	private UserService userService;

	@Autowired
	private ShowTimeService showTimeService;

	@Autowired
	private FoodService foodService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private TicketService ticketService;

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public ApiResponse createBooking(BookingDto bookingDto) {

		String bookingId = UUID.randomUUID().toString();
		bookingDto.setBookingId(bookingId);
		System.out.println(bookingId);

		ApiResponse apiResponse = new ApiResponse();

		MoviesDto moviesDto = moviesService.getMovieById(bookingDto.getMovieId());

		apiResponse.setMovieName(moviesDto.getMovieName());
		apiResponse.setPoster(moviesDto.getPoster());

		TheaterDto theaterDto = theaterService.getTheaterById(bookingDto.getTheaterId());
		apiResponse.setTheaterName(theaterDto.getTheaterName());
		apiResponse.setLocation(theaterDto.getLocation());

		UserDto userDto = userService.getSingleUser(bookingDto.getUserId());
		apiResponse.setUserId(userDto.getUserId());
		apiResponse.setUserName(userDto.getUserName());
		apiResponse.setUserEmail(userDto.getUserEmail());
		apiResponse.setFullName(userDto.getFullName());

		FoodDto foodDto = this.foodService.getFoodById(bookingDto.getFoodId());
		apiResponse.setFood(foodDto.getFoodName());
		apiResponse.setFoodPrice(foodDto.getFoodPrice());

		ShowTimeDto showTimeDto = showTimeService.getShowTimeById(bookingDto.getShowTimeId());
		apiResponse.setStartTime(showTimeDto.getStartTime());
		apiResponse.setBookedSeat(bookingDto.getSeats());
		apiResponse.setCreateDate(bookingDto.getCreateDate());
		apiResponse.setBookingId(bookingId);

		List<String> seats = bookingDto.getSeats();

		if (seats.size() > 4) {

			throw new SeatLimitExtends();
			
		} else {

			for (String seat : seats) {

				TicketDto ticketDto = new TicketDto();
				ticketDto.setBookingId(bookingId);
				ticketDto.setUserId(userDto.getUserId());

				TicketDto createTicket = this.ticketService.updateTicket(seat, ticketDto);

			}

			List<TicketDto> allTicketByBookingId = this.ticketService.getAllTicketByBookingId(bookingId);

			apiResponse.setBookedtickets(allTicketByBookingId);

			for (TicketDto ticketDto2 : allTicketByBookingId) {

				if (ticketDto2.getTicketCategory().equals("Gold")) {

					ticketPrice = ticketPrice + 400.00;

				}
				if (ticketDto2.getTicketCategory().equals("Diamond")) {

					ticketPrice = ticketPrice + 500.00;

				}
				if (ticketDto2.getTicketCategory().equals("Silver")) {

					ticketPrice = ticketPrice + 300.00;
				}
			}

			System.out.println(ticketPrice);
			apiResponse.setTotalAmmount(bookingDto.getTotalAmmount() + foodDto.getFoodPrice() + ticketPrice);

			PaymentDto paymentDto = new PaymentDto();

			Double totalAmmount = bookingDto.getTotalAmmount();

			Double totalAmmountDouble = totalAmmount + ticketPrice;

			paymentDto.setAmmount(totalAmmountDouble + foodDto.getFoodPrice());

			paymentDto.setBookingId(bookingId);
			paymentDto.setLocalDateTime(null);
			paymentDto.setPaymentId(null);
			paymentDto.setCardHolderName(bookingDto.getCardHolderName());
			paymentDto.setCardExpiry(bookingDto.getCardExpiry());
			paymentDto.setCvv(bookingDto.getCvv());
			paymentDto.setCardNo(bookingDto.getCardNo());
			paymentDto.setPaymentStatus("Payment Done Successfully...!");
			paymentDto.setUserId(userDto.getUserId());

			PaymentResponse processPayment = this.paymentService.processPayment(paymentDto);

			apiResponse.setPaymentId(processPayment.getPaymentId());
			if (processPayment.getPaymentId() != null) {

				apiResponse.setPaymentStatus("Confirm");
				apiResponse.setTicketStatus("Ticked Booked");
			}

			Booking booking = new Booking();

			booking.setPaymentId(processPayment.getPaymentId());

			BeanUtils.copyProperties(bookingDto, booking);

			Booking save = bookingRepository.save(booking);

			BookingDto bookingDto2 = new BookingDto();

			BeanUtils.copyProperties(save, bookingDto2);

			return apiResponse;

		}

	}

	@Override
	public List<BookingDto> getAllBooking() {

		List<Booking> listOfBooking = this.bookingRepository.findAll();

		List<BookingDto> list = new ArrayList();

		listOfBooking.stream().map((x) -> {

			BookingDto bookingDto = new BookingDto();

			BeanUtils.copyProperties(x, bookingDto);
			list.add(bookingDto);

			return x;

		}).collect(Collectors.toList());

		return list;
	}

	@Override
	public List<BookingDto> getBookingByUserId(String userId) {

		List<Booking> booking = this.bookingRepository.findByUserId(userId);

		List<BookingDto> bookingList = new ArrayList();

		booking.stream().map((x) -> {

			BookingDto bookingDto2 = new BookingDto();

			BeanUtils.copyProperties(x, bookingDto2);
			bookingList.add(bookingDto2);

			return x;

		}).collect(Collectors.toList());

		return bookingList;
	}

}
