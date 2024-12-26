package com.rating.services;

import java.util.List;

import com.rating.entities.Rating;

public interface RatingService
{
	// create 
	Rating create(Rating rating);
	
	// get all rating
	List<Rating> getAllRating();
	
	// get all by userId
	List<Rating> getRatingByUserId(String userId);
	
	// get all by hotel
	List<Rating> getRatingByHotelId(String hotelId);

}
