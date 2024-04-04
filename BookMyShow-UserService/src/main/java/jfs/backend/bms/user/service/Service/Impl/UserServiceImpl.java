package jfs.backend.bms.user.service.Service.Impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import jfs.backend.bms.user.service.Service.UserService;
import jfs.backend.bms.user.service.apiresponse.BookingResponse;
import jfs.backend.bms.user.service.apiresponse.RegisterApiResponse;
import jfs.backend.bms.user.service.entity.BookingDto;
import jfs.backend.bms.user.service.entity.MoviesDto;
import jfs.backend.bms.user.service.entity.PaymentDto;
import jfs.backend.bms.user.service.entity.ShowTimeDto;
import jfs.backend.bms.user.service.entity.TheaterDto;
import jfs.backend.bms.user.service.entity.TicketDto;
import jfs.backend.bms.user.service.entity.User;
import jfs.backend.bms.user.service.exception.ResourceNotFoundException;
import jfs.backend.bms.user.service.externalServices.BookingService;
import jfs.backend.bms.user.service.externalServices.MoviesService;
import jfs.backend.bms.user.service.externalServices.PaymentService;
import jfs.backend.bms.user.service.externalServices.ShowTimeService;
import jfs.backend.bms.user.service.externalServices.TheaterService;
import jfs.backend.bms.user.service.externalServices.TicketService;
import jfs.backend.bms.user.service.payload.UserDto;
import jfs.backend.bms.user.service.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private MoviesService moviesService;

	@Autowired
	private TheaterService theaterService;

	@Autowired
	private ShowTimeService showTimeService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private TicketService ticketService;

	@Override
	public RegisterApiResponse createUser(UserDto userDto) {

		String uid = UUID.randomUUID().toString();
		userDto.setUserId(uid);

		RegisterApiResponse aResponse = new RegisterApiResponse();

		User user2 = new User();

		BeanUtils.copyProperties(userDto, user2);

		user2.setPassword(passwordEncoder.encode(user2.getPassword()));

		userRepository.save(user2);

		aResponse.setFullName(userDto.getFullName());
		aResponse.setUserDob(userDto.getUserDob());
		aResponse.setUserEmail(userDto.getUserEmail());
		aResponse.setUserId(userDto.getUserId());
		aResponse.setUserName(userDto.getUserName());

		return aResponse;

	}

	@Override
	public UserDto updateUser(UserDto userDto, String userId) {

		User user2 = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		user2.setFullName(userDto.getFullName());
		user2.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user2.setUserDob(userDto.getUserDob());
		user2.setUserEmail(userDto.getUserEmail());
		user2.setUserName(userDto.getUserName());

		this.userRepository.save(user2);

		BeanUtils.copyProperties(user2, userDto);

		return userDto;
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> userList = this.userRepository.findAll();

		List<UserDto> userDtos = new ArrayList();

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userList, userDtos);

		userList.stream().map(x -> {
			UserDto userDto2 = new UserDto();
			BeanUtils.copyProperties(x, userDto2);
			userDtos.add(userDto2);

			return x;

		}).collect(Collectors.toList());

		return userDtos;

	}

	@Override
	public UserDto getUserById(String userId) {

		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		UserDto userDto = new UserDto();

		this.userRepository.save(user);

		BeanUtils.copyProperties(user, userDto);

		return userDto;
	}

	@Override
	public UserDto updateSpecificField(String userId, Map<String, Object> fields) {

		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "uId", userId));
		fields.forEach((key, value) -> {
			Field field = org.springframework.util.ReflectionUtils.findField(User.class, key);
			Optional<Field> optionalField = Optional.ofNullable(field);
			if (optionalField.isPresent()) {
				field.setAccessible(true);
				ReflectionUtils.setField(field, user, value);
			} else {
				// Handle the case where the field is not found.
				// You may want to log a warning or throw an exception.
				System.err.println("Field not found: " + key);
			}
		});
		User savedUser = userRepository.save(user);
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(savedUser, userDto);
		return userDto;
	}

	@Override
	public List<BookingResponse> getBookingDetails(String userId) {

		List<BookingDto> listOfBookings = this.bookingService.getAllBookingById(userId);

		List<BookingResponse> bookingResponses = new ArrayList();

		for (BookingDto x : listOfBookings) {

			BookingResponse bResponse = new BookingResponse();

			String bookingId = x.getBookingId();
			
			bResponse.setBookingId(bookingId);

			MoviesDto moviesDto = moviesService.getMovieById(x.getMovieId());
			System.out.println(moviesDto.getMovieId());
			logger.info(moviesDto.getMovieId());
			bResponse.setMovieName(moviesDto.getMovieName());
			bResponse.setPoster(moviesDto.getPoster());

			TheaterDto theaterDto = theaterService.getTheaterById(x.getTheaterId());
			logger.info(theaterDto.getHallId());
			bResponse.setLocation(theaterDto.getLocation());
			bResponse.setTheaterName(theaterDto.getTheaterName());

			ShowTimeDto showTimeDto = showTimeService.getShowTimeById(x.getShowTimeId());
			logger.info(showTimeDto.getShowtimeId());
			bResponse.setStartTime(showTimeDto.getStartTime());

			PaymentDto paymentDto = paymentService.getPaymentDetailsByBookingId(bookingId);
			logger.info(paymentDto.getPaymentId());
			bResponse.setPaymentId(paymentDto.getPaymentId());
			bResponse.setPaymentStatus(paymentDto.getPaymentStatus());
			bResponse.setTotalAmmount(paymentDto.getAmmount());
			
			
			List<TicketDto> ticketDtosList = ticketService.getAllTicketByBookingId(x.getBookingId());

			bResponse.setBookedtickets(ticketDtosList);
			
			
			User user = userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
			bResponse.setUserEmail(user.getUserEmail());
			bResponse.setUserId(user.getUserId());
			bResponse.setFullName(user.getFullName());

			bookingResponses.add(bResponse);

		}

		return bookingResponses;
	}

}
