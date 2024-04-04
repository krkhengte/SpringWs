package jfs.backend.bms.theater.service.payload;

import java.util.List;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheaterDto {
	
	
	private String hallId;
	@NotEmpty
	@NonNull
	private String theaterName;
	@NotEmpty
	@NonNull
	private String location;
	@NotEmpty
	@NonNull
	private Integer seatingCapacity;
	@NotEmpty
	@NonNull
	private List<String> seatType;
	@NotEmpty
	@NonNull
	private List<Integer> screens;
}
