package jfs.backend.bms.showtime.service.service;

import java.util.List;

import jfs.backend.bms.showtime.service.payload.ShowTimeDto;

public interface ShowTimeService {

	public ShowTimeDto addShowTime(ShowTimeDto showTimeDto);
	
	public List<ShowTimeDto> getAllShowTimeDtos();
	
	public List<ShowTimeDto> searchByShowTime(String showTime); 
	
	public ShowTimeDto getShowTimeById(String showTimeId);
}
