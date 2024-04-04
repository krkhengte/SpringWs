package jfs.backend.bms.movie.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import jfs.backend.bms.movie.service.payload.MovieDto;
import jfs.backend.bms.movie.service.service.MovieService;

@RestController
@RequestMapping("movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@PostMapping("/addNewMovies")
	public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto){
		
		MovieDto addMovie = this.movieService.addMovie(movieDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(addMovie);
		
	}
	
	@GetMapping("/getAllMovies")
	public ResponseEntity<List<MovieDto>> getAllMovies(){
		
		List<MovieDto> allMovies = this.movieService.getAllMovies();
		
		return ResponseEntity.status(HttpStatus.OK).body(allMovies);
		
	}
	
	@DeleteMapping("/deleteMovieByMovieId/{movieId}")
	public ResponseEntity<String> deleteMovieByMovieId(@PathVariable String movieId) {
		String deleteMovie = this.movieService.deleteMovie(movieId);
		return ResponseEntity.status(HttpStatus.OK).body(deleteMovie);
	}
	
	@GetMapping("/searchMovies/{search}")
	public ResponseEntity<List<MovieDto>> searchMovies(@PathVariable String search){
	
		List<MovieDto> searchMovies = this.movieService.searchMovies(search);
		return ResponseEntity.status(HttpStatus.OK).body(searchMovies);
	}
	
	@GetMapping("/searchMovieByName/{search}")
	public ResponseEntity<List<MovieDto>> searchMovieByName(@PathVariable String search){
		List<MovieDto> searchMovieByName = this.movieService.searchMovieByName(search);
		return ResponseEntity.status(HttpStatus.OK).body(searchMovieByName);
	}
	
	@GetMapping("/getMovieById/{movieId}")
	public ResponseEntity<MovieDto> getMovieByMovieId(@PathVariable String movieId){
	
		MovieDto movieByMovieId = this.movieService.getMovieByMovieId(movieId);
		return ResponseEntity.status(HttpStatus.OK).body(movieByMovieId);
	}
	
}
