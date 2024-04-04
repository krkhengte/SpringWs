package jfs.backend.bms.booking.service.externalService;

import jfs.backend.bms.booking.service.entity.MoviesDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "MOVIE-SERVICE")
public interface MoviesService {
	
	@RequestMapping("movies/getMovieById/{movieId}")
	public MoviesDto getMovieById(@PathVariable("movieId") String movieId);

}
