package com.rating.entities;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("user_ratings")     	// we can't use @Entity here for table creating instead of that we use @Document and mention the collection
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating 
{
	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
}
