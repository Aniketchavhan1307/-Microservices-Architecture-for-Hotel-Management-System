package com.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entities.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repositories.HotelRepository;
import com.hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService
{
	@Autowired
	private HotelRepository hotelRepo; 

	public Hotel create(Hotel hotel) 
	{
		String randomId = UUID.randomUUID().toString();
		
		hotel.setId(randomId);
		return hotelRepo.save(hotel);
	}
	
	

	public Hotel get(String id) 
	{
		return hotelRepo.findById(id).orElseThrow(() ->new ResourceNotFoundException("Hotel with given id not found"));
	}
	
	

	public List<Hotel> getAll() 
	{
		return hotelRepo.findAll();
	}



	public void deleteHotel(String id)
	{
		Hotel hotel = get(id);
	
		 hotelRepo.delete(hotel);
	}

}
