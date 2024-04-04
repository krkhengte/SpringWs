package jfs.backend.services;

import java.util.List;

import jfs.backend.entity.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAllHotels();
	
	Hotel getHotel(String hotelId);
	
}
