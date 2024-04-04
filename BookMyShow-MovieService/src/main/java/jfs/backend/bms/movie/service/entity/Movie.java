package jfs.backend.bms.movie.service.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Movie {

	@Id
	private String movieId;
	private String movieName;
	private LocalDate releaseDate;
	private String category;
	private String genre;
	private String rating;
	private String country;
	private String poster;
	
}
