package com.rating.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entities.Rating;
import com.rating.repositories.RatingRepository;
import com.rating.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService
{
	@Autowired
	private RatingRepository ratingRepo;
	
	

	public Rating create(Rating rating) 
	{
	
		return ratingRepo.save(rating);
	}
	
	

	public List<Rating> getAllRating()
	{
		return ratingRepo.findAll();
	}
	
	

	public List<Rating> getRatingByUserId(String userId) 
	{
		return ratingRepo.findByUserId(userId);
	}

	
	
	public List<Rating> getRatingByHotelId(String hotelId) 
	{
		return ratingRepo.findByHotelId(hotelId);
	}

}
