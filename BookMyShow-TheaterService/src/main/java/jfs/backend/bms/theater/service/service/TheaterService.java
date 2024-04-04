package jfs.backend.bms.theater.service.service;

import java.util.List;
import java.util.Map;

import jfs.backend.bms.theater.service.payload.TheaterDto;


public interface TheaterService {

	public TheaterDto addNewTheater(TheaterDto theaterDto);
	
	public List<TheaterDto> getAllTheaters();
	
	public TheaterDto updateTheater(String theaterId);
	
	public String deleteTheater(String theaterId);
	
	public TheaterDto getTheaterDetails(String theaterId);
	
	public TheaterDto checkSeatAvailability(String theaterName);
	
	public TheaterDto updateSpecificField(String theaterId, Map<String, Object> fields);
}
