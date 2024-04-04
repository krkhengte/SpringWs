package jfs.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.entity.Rating;
import jfs.backend.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PostMapping("/createRating")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {

		Rating createRating = this.ratingService.createRating(rating);

		return ResponseEntity.status(HttpStatus.CREATED).body(createRating);

	}

	@GetMapping("/getAllRatings")
	public ResponseEntity<List<Rating>> getAllRatings() {

		List<Rating> allRating = this.ratingService.getAllRating();

		return ResponseEntity.status(HttpStatus.OK).body(allRating);

	}

	@GetMapping("/getAllUserRating/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingByUser(@PathVariable String userId) {

		List<Rating> ratingByUserId = this.ratingService.getRatingByUserId(userId);

		return ResponseEntity.status(HttpStatus.OK).body(ratingByUserId);

	}

	@GetMapping("/getSingleHotelRating/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingByHotel(@PathVariable String hotelId) {

		List<Rating> ratingByUserId = this.ratingService.getRatingByHotelId(hotelId);

		//return ResponseEntity.status(HttpStatus.OK).body(ratingByUserId);
		
		return new ResponseEntity<List<Rating>>(ratingByUserId, HttpStatus.OK);

	}

}
