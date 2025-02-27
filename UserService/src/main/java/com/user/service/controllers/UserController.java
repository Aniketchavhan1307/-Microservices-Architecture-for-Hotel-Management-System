package com.user.service.controllers;

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

import com.user.service.entities.User;
import com.user.service.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController
{
	@Autowired
	private UserService userService;
	
	//create
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		
		User savedUser = userService.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
	
	
	int retryCount = 1;
	// get single user
	
	@GetMapping("/{userId}")
	@CircuitBreaker(name = "ratingHotelBreaker" , fallbackMethod = "ratingHotelFallback")
	@Retry(name = "ratingHotelService",  fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> geSingleUser(@PathVariable String userId)
	{
		 log.info("Retry count: {}", retryCount);  // Use SLF4J for logging
		retryCount++;
		
		User user = userService.getUser(userId);
		
		return ResponseEntity.ok(user);
		
		//return ResponseEntity.status(HttpStatus.FOUND).body(user);
	}
	
	
	// creating fall back method for circuitBreaker & return type should be same as the calling breaker method 
	
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex)
	{
		User user = User.builder()
				.email("dummy@gmail.com")
				.name("Dummy")
				.about("This user is created dummy because some services are down")
				.userId("141234")
				.build();     
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
	
	// get all user
	@GetMapping
	public ResponseEntity<List<User>> getAlluser()
	{
		List<User> list = userService.getAllUser();
		
		return ResponseEntity.ok(list);
		
	}
}
