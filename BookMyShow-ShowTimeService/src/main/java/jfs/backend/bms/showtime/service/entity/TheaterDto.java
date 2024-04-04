package jfs.backend.bms.showtime.service.entity;

import java.io.Serializable;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheaterDto implements Serializable {

	private String hallId;
	private String theaterName;
	private String location;
	private Integer seatingCapacity;
	private List<String> seatType;
	private List<Integer> screens;
}
