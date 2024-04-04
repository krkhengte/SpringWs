package jfs.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.entity.Hotel;
import jfs.backend.services.HotelService;

@RestController
@RequestMapping("hotels")
public class HotelControllers {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/createHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
		Hotel createHotel = this.hotelService.createHotel(hotel);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createHotel);
		
	}
	
	@GetMapping("/getAllHotels")
	public ResponseEntity<List<Hotel>> getAllHotels(){
		
		List<Hotel> allHotels = this.hotelService.getAllHotels();
		
		return ResponseEntity.status(HttpStatus.OK).body(allHotels);
		
	}
	
	@GetMapping("/getHotel/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId){
		
		Hotel hotel = this.hotelService.getHotel(hotelId);
		
		return ResponseEntity.status(HttpStatus.OK).body(hotel);
		
	}
	
}
