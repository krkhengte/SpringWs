package jfs.backend.bms.theater.service.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Theater {

	@Id
	private String hallId;
	private String theaterName;
	private String location;
	private Integer seatingCapacity;
	private List<String> seatType;
	private List<Integer> screens;
}
