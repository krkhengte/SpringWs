package jfs.backend.bms.showtime.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.bms.showtime.service.apiResponse.ApiResponse;
import jfs.backend.bms.showtime.service.payload.ShowTimeDto;
import jfs.backend.bms.showtime.service.service.ShowTimeService;

@RestController
@RequestMapping("showTime")
public class ShowTimeServiceController {

	@Autowired
	private ShowTimeService showTimeService;
	
	@PostMapping("/addShowTime")
	public ResponseEntity<ApiResponse> createShowTime(@RequestBody ShowTimeDto showTimeDto){
		
		ShowTimeDto addShowTime = this.showTimeService.addShowTime(showTimeDto);
		
		ApiResponse api=new ApiResponse();

			
			api.setEndTime(addShowTime.getEndTime());
			api.setMovieId(addShowTime.getMovieId());
	//		api.setMoviesJson(addShowTime.getMoviesJson());
			api.setShowtimeId(addShowTime.getShowtimeId());
			api.setStartTime(addShowTime.getStartTime());
			api.setTheaterId(addShowTime.getTheaterId());
	//		api.setTheatersJson(addShowTime.getTheatersJson());

		
		return ResponseEntity.status(HttpStatus.OK).body(api);
	}
	
	@GetMapping("/getAllShowTimeList") 
	public ResponseEntity<List<ShowTimeDto>> getAllShowTime(){
		
		List<ShowTimeDto> allShowTimeDto = this.showTimeService.getAllShowTimeDtos();
		
		return ResponseEntity.status(HttpStatus.OK).body(allShowTimeDto);
	}
	
	
	@GetMapping("/getAllShowTimeListsApiResponse")
	public ResponseEntity<List<ApiResponse>> getAllShowTimes(){
		
		List<ShowTimeDto> allShowTimeDto = this.showTimeService.getAllShowTimeDtos();
		
		List<ApiResponse> apiResponses=new ArrayList<>();
		
		allShowTimeDto.stream().map((show)->{
		
			ApiResponse api=new ApiResponse();
			
			api.setEndTime(show.getEndTime());
			api.setMovieId(show.getMovieId());
		//	api.setMoviesJson(show.getMoviesJson());
			api.setShowtimeId(show.getShowtimeId());
			api.setStartTime(show.getStartTime());
			api.setTheaterId(show.getTheaterId());
		//	api.setTheatersJson(show.getTheatersJson());
			
			apiResponses.add(api);
			
			return show;
			
		}).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(apiResponses);
	}
	
	@GetMapping("/searchShowByTime/{startTime}")
	public ResponseEntity<List<ApiResponse>> searchShowTime(@PathVariable String startTime){
		
		List<ShowTimeDto> searchByShowTime = this.showTimeService.searchByShowTime(startTime);
		
		List<ApiResponse> apiResponses=new ArrayList<>();
		
		searchByShowTime.stream().map((show)->{
		
			ApiResponse api=new ApiResponse();
			
			api.setEndTime(show.getEndTime());
			api.setMovieId(show.getMovieId());
	//		api.setMoviesJson(show.getMoviesJson());
			api.setShowtimeId(show.getShowtimeId());
			api.setStartTime(show.getStartTime());
			api.setTheaterId(show.getTheaterId());
	//		api.setTheatersJson(show.getTheatersJson());
			
			apiResponses.add(api);
			
			return show;
			
		}).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(apiResponses);
	}
	
	@GetMapping("showTime/getShowTimeById/{showTimeId}")
	public ResponseEntity<ShowTimeDto> getShowTimeById(@PathVariable String showTimeId){
		ShowTimeDto showTimeById = this.showTimeService.getShowTimeById(showTimeId);
		
		return ResponseEntity.status(HttpStatus.OK).body(showTimeById);
	}
	
}
;