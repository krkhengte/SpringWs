package jfs.backend.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import jfs.backend.entity.Rating;

@FeignClient("RATING-SERVICE")
public interface RatingService {

	@GetMapping("/ratings/getAllRatings")
	List<Rating> getRating();
	
}


