package jfs.backend.request;

import lombok.Data;

@Data
public class PassengerInfo {

	private String fname;
	private String lName;
	private String from;
	private String to;
	private String flightId;
	private String journeyDate;
}
