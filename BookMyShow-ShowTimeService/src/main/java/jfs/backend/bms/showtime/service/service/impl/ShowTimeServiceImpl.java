package jfs.backend.bms.showtime.service.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.constraints.Null;
import jfs.backend.bms.showtime.service.apiResponse.ApiResponse;
import jfs.backend.bms.showtime.service.entity.MoviesDto;
import jfs.backend.bms.showtime.service.entity.ShowTime;
import jfs.backend.bms.showtime.service.entity.TheaterDto;
import jfs.backend.bms.showtime.service.exception.ResourceNotFoundException;
import jfs.backend.bms.showtime.service.externalService.MoviesService;
import jfs.backend.bms.showtime.service.externalService.TheaterService;
import jfs.backend.bms.showtime.service.payload.ShowTimeDto;
import jfs.backend.bms.showtime.service.repo.ShowTimeRepo;
import jfs.backend.bms.showtime.service.service.ShowTimeService;

@Service
public class ShowTimeServiceImpl implements ShowTimeService {

	@Autowired
	private MoviesService moviesService;

	@Autowired
	private TheaterService theaterService;

	@Autowired
	private ShowTimeRepo showTimeRepo;

	@Override
	public ShowTimeDto addShowTime(ShowTimeDto showTimeDto) {

		String theaterId = UUID.randomUUID().toString();
		showTimeDto.setShowtimeId(theaterId);

		ShowTime showTime = new ShowTime();

		BeanUtils.copyProperties(showTimeDto, showTime);
		
		showTimeRepo.save(showTime);

		return showTimeDto;
		
		
		// ShowTimeDto showTimeDto2=new ShowTimeDto();

//		MoviesDto movie = moviesService.getMovieById(showTimeDto.getMovieId());
//		System.out.println(movie.getMovieName());
	//	showTimeDto.setMovies(movie);

		// BeanUtils.copyProperties(movie, showTimeDto2);

//		TheaterDto theater = theaterService.getTheaterById(showTimeDto.getTheaterId());
//		System.out.println(theater.getTheaterName());
	//	showTimeDto.setTheaters(theater);

	//	List<Object> asList = Arrays.asList(movie, theater);

		// showTimeDto.setObjects(asList);
		// BeanUtils.copyProperties(theater, showTimeDto2);


//		showTime.setMoviesJson(convertObjectToJsonString(movie));
//		showTime.setTheatersJson(convertObjectToJsonString(theater));



	}

	private String convertObjectToJsonString(Object object) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			// Handle exception
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<ShowTimeDto> getAllShowTimeDtos() {

		List<ShowTime> showtimeList = this.showTimeRepo.findAll();

		List<ShowTimeDto> showTimeDtos = new ArrayList();

		showtimeList.stream().map((x) -> {

			ShowTimeDto showTimeDto = new ShowTimeDto();
			BeanUtils.copyProperties(x, showTimeDto);
			showTimeDtos.add(showTimeDto);

			return x;

		}).collect(Collectors.toList());

		return showTimeDtos;
	}

	@Override
	public List<ShowTimeDto> searchByShowTime(String showTime) {

		List<ShowTime> findByStartTimeContaining = this.showTimeRepo.findByStartTimeContaining(showTime);

		List<ShowTimeDto> showTimeDtos = new ArrayList();

		findByStartTimeContaining.stream().map((x) -> {

			ShowTimeDto showTimeDto = new ShowTimeDto();

			BeanUtils.copyProperties(x, showTimeDto);

			showTimeDtos.add(showTimeDto);

			return x;

		}).collect(Collectors.toList());

		return showTimeDtos;
	}

	@Override
	public ShowTimeDto getShowTimeById(String showTimeId) {
		
		ShowTime showTime = this.showTimeRepo.findById(showTimeId).orElseThrow(()-> new ResourceNotFoundException("ShowTime", "showTimeId", showTimeId));
		
		ShowTimeDto showTimeDto =new ShowTimeDto();
		
		BeanUtils.copyProperties(showTime, showTimeDto);
		
		return showTimeDto;
	}

}
