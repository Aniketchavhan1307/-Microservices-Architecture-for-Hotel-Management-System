package com.hotel.services;

import java.util.List;

import com.hotel.entities.Hotel;

public interface HotelService
{
	// create
	
	Hotel create(Hotel hotel);
	
	// get single 
	Hotel get(String id);
	
	// get All

	List<Hotel> getAll();
	
	// delete hotel
	
	void deleteHotel(String id);
}
