package jfs.backend.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jfs.backend.entity.Hotel;
import jfs.backend.exception.ResourceNotFoundException;
import jfs.backend.repository.HotelRepository;
import jfs.backend.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return this.hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return this.hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId) {
		// TODO Auto-generated method stub
		
		Hotel hotel = this.hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("hotel with given hotel id is Not found !:"+ hotelId));
		
		return hotel;
	}

	
	
}
