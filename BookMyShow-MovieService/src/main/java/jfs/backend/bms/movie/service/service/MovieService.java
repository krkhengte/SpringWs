package jfs.backend.bms.movie.service.service;

import java.util.List;

import jfs.backend.bms.movie.service.payload.MovieDto;

public interface MovieService {

	public MovieDto addMovie(MovieDto movieDto);
	
	public List<MovieDto> getAllMovies();
	
	public String deleteMovie(String movieId);
	
	public List<MovieDto> searchMovies(String search);
	
	public List<MovieDto> searchMovieByName(String search);
	
	public MovieDto getMovieByMovieId(String movieId);
	
	//public MovieDto search(MovieDto movieDto);
	
	
}
