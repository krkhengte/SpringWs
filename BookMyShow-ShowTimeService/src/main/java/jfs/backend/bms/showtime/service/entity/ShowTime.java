package jfs.backend.bms.showtime.service.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class ShowTime {

	@Id
	private String showtimeId;
	private String movieId;
	private String theaterId;
	private String startTime;
	private String endTime;
//	@Transient
//	private MoviesDto movies;
//	@Transient
//	private TheaterDto theaters;
//	
//    private String moviesJson;
//
//    private String theatersJson;

	

	
	
}
