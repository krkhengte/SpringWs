package jfs.backend.bms.showtime.service.apiResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

	private String showtimeId;
	private String movieId;
	private String theaterId;
	private String startTime;
	private String endTime;	

	
}
