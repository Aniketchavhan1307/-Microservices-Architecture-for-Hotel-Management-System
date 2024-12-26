package com.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entities.Hotel;
import com.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController 
{

	@Autowired
	private HotelService hotelService;
	
	// create 
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));     
	}
	
	
	// get single
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> findHotel(@PathVariable String hotelId)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(hotelService.get(hotelId));     
	}
	
	
	// get all
	@GetMapping
	public ResponseEntity<List<Hotel>> findAllHotel()
	{
		return ResponseEntity.ok().body(hotelService.getAll());
		
		// return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());     
	}
	
	
	@DeleteMapping("/{hotelId}")
	public ResponseEntity<?> deleteHotel(@PathVariable String hotelId)
	{
		 System.out.println("Deleting hotel with ID: " + hotelId);
		
		hotelService.deleteHotel(hotelId);
		
		return ResponseEntity.ok().body("Hotel deleted successfully..");
		
		// return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());     
	}
	
}
