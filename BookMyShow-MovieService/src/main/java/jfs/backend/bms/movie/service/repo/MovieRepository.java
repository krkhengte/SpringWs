package jfs.backend.bms.movie.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jfs.backend.bms.movie.service.entity.Movie;
import jfs.backend.bms.movie.service.payload.MovieDto;

public interface MovieRepository extends JpaRepository<Movie, String>{

	public List<Movie> findByMovieNameContaining(String movieName);
	
	public List<Movie> findByCategoryContaining(String category);
	
//	public List<Movie> findByMovieNameOrCategoryContaining(String search,String keyword);
	
	
}
