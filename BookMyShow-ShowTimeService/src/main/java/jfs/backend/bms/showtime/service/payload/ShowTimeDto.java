package jfs.backend.bms.showtime.service.payload;

import java.util.List;

import jfs.backend.bms.showtime.service.entity.MoviesDto;
import jfs.backend.bms.showtime.service.entity.TheaterDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowTimeDto {

	private String showtimeId;
	private String movieId;
	private String theaterId;
	private String startTime;
	private String endTime;
//	private MoviesDto movies;
//	private TheaterDto theaters;
//    private String moviesJson;
//    private String theatersJson;

}
