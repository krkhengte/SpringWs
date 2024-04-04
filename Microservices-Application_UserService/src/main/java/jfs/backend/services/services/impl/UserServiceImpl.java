package jfs.backend.services.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jfs.backend.entity.Hotel;
import jfs.backend.entity.Rating;
import jfs.backend.entity.User;
import jfs.backend.exception.ResourceNotFoundException;
import jfs.backend.external.services.RatingService;
import jfs.backend.repository.UserRepository;
import jfs.backend.external.services.HotelService;
import jfs.backend.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;



	@Autowired
	private RatingService ratingService;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();

	}

	@Override
	public User getUser(String userId) {

		User user = this.userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with giben id is not found on Server ! :" + userId));

		List<Rating> ratings = ratingService.getRating();
		List<Rating> listOfRatings = ratings.stream().map((rating) -> {
			String hotelId = rating.getHotelId();
			Hotel hotel = hotelService.getHotelDetails(hotelId);
			System.out.println(hotel.getName());
			rating.setHotel(hotel);
			return rating;

		}).collect(Collectors.toList());

		user.setRatings(listOfRatings);

		return user;
	}

}
