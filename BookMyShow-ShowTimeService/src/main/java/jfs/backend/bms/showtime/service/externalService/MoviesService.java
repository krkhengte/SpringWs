package jfs.backend.bms.showtime.service.externalService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jfs.backend.bms.showtime.service.entity.MoviesDto;

@FeignClient("MOVIE-SERVICE")
public interface MoviesService {
	
	@GetMapping("movies/getMovieById/{movieId}")
	public MoviesDto getMovieById(@PathVariable String movieId);

}
