package jfs.backend.bms.user.service.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class MoviesDto implements Serializable {

	private String movieId;
	private String movieName;
	private String category;
	private String genre;
	private String rating;
	private String country;
	private String poster;
	
}
