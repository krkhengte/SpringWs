package jfs.backend.service;

import java.util.List;

import jfs.backend.entity.Rating;

public interface RatingService {

	Rating createRating(Rating rating);
	
	List<Rating> getAllRating();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);
	
}
