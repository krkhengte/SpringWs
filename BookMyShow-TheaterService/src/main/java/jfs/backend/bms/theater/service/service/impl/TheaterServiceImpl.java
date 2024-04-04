package jfs.backend.bms.theater.service.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import jfs.backend.bms.theater.service.entity.Theater;
import jfs.backend.bms.theater.service.exception.ResourceNotFoundException;
import jfs.backend.bms.theater.service.payload.TheaterDto;
import jfs.backend.bms.theater.service.repo.TheaterRepository;
import jfs.backend.bms.theater.service.service.TheaterService;


@Service
public class TheaterServiceImpl implements TheaterService{

	@Autowired
	private TheaterRepository theaterRepository;
	
	@Override
	public TheaterDto addNewTheater(TheaterDto theaterDto) {
	
		Theater theater=new Theater();
		
		String string = UUID.randomUUID().toString();
		theaterDto.setHallId(string);
		
		BeanUtils.copyProperties(theaterDto, theater);
		
		this.theaterRepository.save(theater);
		
		BeanUtils.copyProperties(theater, theaterDto);
		
		return theaterDto;
	}

	@Override
	public List<TheaterDto> getAllTheaters() {
		
		List<Theater> theaters = this.theaterRepository.findAll();
		
		List<TheaterDto> listThrTheaterDtos=new ArrayList();
		
		theaters.stream().map((theater)->{
			TheaterDto theaterDto=new TheaterDto();
			BeanUtils.copyProperties(theater, theaterDto);
			listThrTheaterDtos.add(theaterDto);
			return theater;
			
		}).collect(Collectors.toList());
	
		return listThrTheaterDtos;
	}

	@Override
	public TheaterDto updateTheater(String theaterId) {
		
		Theater theater = this.theaterRepository.findById(theaterId).orElseThrow(()->new ResourceNotFoundException("Theare", "theareId", theaterId));
		
		TheaterDto theaterDto=new TheaterDto();
		
		BeanUtils.copyProperties(theater, theaterDto);	
		
		Theater theater2=new Theater();
		BeanUtils.copyProperties(theaterDto, theater2);
		
		this.theaterRepository.save(theater2);
		
		return theaterDto;
	}

	@Override
	public String deleteTheater(String theaterId) {
		
		Theater theater = this.theaterRepository.findById(theaterId).orElseThrow(()->new ResourceNotFoundException("Theare", "theareId", theaterId));
		
		if(theater.getHallId().equals(theaterId)) {
			
			this.theaterRepository.deleteById(theaterId);
			
			return "Theater Deleted Successfull....!";
		}else {
			return "Failed to Delete Theater ....!";
		}
	
	}

	@Override
	public TheaterDto getTheaterDetails(String theaterId) {
	
		Theater theater = this.theaterRepository.findById(theaterId).orElseThrow(()->new ResourceNotFoundException("Theare", "theareId", theaterId));
		
		TheaterDto theaterDto=new TheaterDto();
		
		BeanUtils.copyProperties(theater, theaterDto);
		
		
		return theaterDto;
	}
	
	@Override
    public TheaterDto updateSpecificField(String theaterId, Map<String, Object> fields) {

        Theater theater = this.theaterRepository.findById (theaterId)
                .orElseThrow (() -> new ResourceNotFoundException("Theater", "theaterId", theaterId));
        fields.forEach ((key, value) -> {
            Field field = org.springframework.util.ReflectionUtils.findField (Theater.class,key);
            Optional<Field> optionalField = Optional.ofNullable (field);
            if (optionalField.isPresent ()) {
                field.setAccessible (true);
                ReflectionUtils.setField(field, theater, value);
            } else {
                // Handle the case where the field is not found.
                // You may want to log a warning or throw an exception.
                System.err.println ("Field not found: " + key);
            }
        });
        Theater saveTheater = theaterRepository.save (theater);
        TheaterDto theaterDto = new TheaterDto();
        BeanUtils.copyProperties (saveTheater, theaterDto);
        return theaterDto;
    }

	@Override
	public TheaterDto checkSeatAvailability(String theaterName) {
	
		
		
		return null;
	}

}
