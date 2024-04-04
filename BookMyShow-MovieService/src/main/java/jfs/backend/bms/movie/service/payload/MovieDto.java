package jfs.backend.bms.movie.service.payload;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class MovieDto {
	
	private String movieId;
	private String movieName;
	private LocalDate releaseDate;
	private String category;
	private String genre;
	private String rating;
	private String country;
	private String poster;
}
