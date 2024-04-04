package jfs.backend.bms.user.service.externalServices;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jfs.backend.bms.user.service.entity.MoviesDto;

@FeignClient(name = "MOVIE-SERVICE")
public interface MoviesService {
	
	@RequestMapping("movies/getMovieById/{movieId}")
	public MoviesDto getMovieById(@PathVariable("movieId") String movieId);

}
