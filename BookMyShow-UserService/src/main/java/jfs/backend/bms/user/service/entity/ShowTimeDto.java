package jfs.backend.bms.user.service.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ShowTimeDto implements Serializable {

	private String showtimeId;
	private String movieId;
	private String theaterId;
	private String startTime;
	private String endTime;
}

