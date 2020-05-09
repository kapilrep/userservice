package org.connect.userservice.repository;

import org.connect.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository <User, String>{
	public User findByName(String name);
	//public List<Rating> findByRating(int rating);

}
