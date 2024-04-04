package jfs.backend.bms.movie.service.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jfs.backend.bms.movie.service.entity.Movie;
import jfs.backend.bms.movie.service.exception.ResourceNotFoundException;
import jfs.backend.bms.movie.service.payload.MovieDto;
import jfs.backend.bms.movie.service.repo.MovieRepository;
import jfs.backend.bms.movie.service.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public MovieDto addMovie(MovieDto movieDto) {

		Movie movie = new Movie();

		String movieId = UUID.randomUUID().toString();

		movieDto.setMovieId(movieId);

		BeanUtils.copyProperties(movieDto, movie);

		this.movieRepository.save(movie);

		return movieDto;
	}

	@Override
	public List<MovieDto> getAllMovies() {

		List<Movie> listOfMovies = this.movieRepository.findAll();

		List<MovieDto> listOfMovieDtos = new ArrayList();

		listOfMovies.stream().map((movie) -> {

			MovieDto movieDto = new MovieDto();

			BeanUtils.copyProperties(movie, movieDto);

			listOfMovieDtos.add(movieDto);

			return movie;
		}).collect(Collectors.toList());

		return listOfMovieDtos;
	}

	@Override
	public String deleteMovie(String movieId) {

		Movie movie = this.movieRepository.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "movieId", movieId));

		if (movie.getMovieId().equals(movieId)) {
			this.movieRepository.deleteById(movieId);

			return "Movie Deleted Successfully";
		} else {
			return "Movie Failed To Delete";
		}

	}

	@Override
	public List<MovieDto> searchMovies(String search) {

		List<MovieDto> listOfMoviesDtos = new ArrayList();

		List<Movie> findByMovieNameContaining = this.movieRepository.findByMovieNameContaining(search);

		List<Movie> findByCategory = this.movieRepository.findByCategoryContaining(search);

		findByMovieNameContaining.stream().map((movie) -> {

			MovieDto movieDto = new MovieDto();

			BeanUtils.copyProperties(movie, movieDto);
			listOfMoviesDtos.add(movieDto);

			return movie;

		}).collect(Collectors.toList());

		findByCategory.stream().map((movie) -> {

			MovieDto movieDto = new MovieDto();

			BeanUtils.copyProperties(movie, movieDto);
			listOfMoviesDtos.add(movieDto);

			return movie;

		}).collect(Collectors.toList());
		
		List<MovieDto> uniqueMovie = listOfMoviesDtos.stream().distinct().collect(Collectors.toList());

		return uniqueMovie;
	}

	@Override
	public List<MovieDto> searchMovieByName(String search) {

		List<Movie> findByMovieNameContaining = this.movieRepository.findByMovieNameContaining(search);

		List<MovieDto> listOfMovieDtos = new ArrayList();

		findByMovieNameContaining.stream().map((movie) -> {
			MovieDto movieDto = new MovieDto();

			BeanUtils.copyProperties(movie, movieDto);
			listOfMovieDtos.add(movieDto);

			return movie;
		}).collect(Collectors.toList());

		return listOfMovieDtos;
	}

	@Override
	public MovieDto getMovieByMovieId(String movieId) {
		
		Movie movie = this.movieRepository.findById(movieId).orElseThrow(()-> new ResourceNotFoundException("Movie", "movieId", movieId));
		
		MovieDto movieDto=new MovieDto();
		
		BeanUtils.copyProperties(movie, movieDto);
		return movieDto;
	}

}
