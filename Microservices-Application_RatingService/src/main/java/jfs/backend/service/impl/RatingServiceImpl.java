package jfs.backend.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jfs.backend.entity.Rating;
import jfs.backend.repository.RatingRepository;
import jfs.backend.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository repository;
	
	@Override
	public Rating createRating(Rating rating) {
		
		String ratingId = UUID.randomUUID().toString();
		
		rating.setRatingId(ratingId);
		
		return this.repository.save(rating) ;
	}

	@Override
	public List<Rating> getAllRating() {
		
		return this.repository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {

		return this.repository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return this.repository.findByHotelId(hotelId);
	}

}
