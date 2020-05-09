package org.connect.userservice.resource;

import java.util.Collections;
import java.util.List;

import org.connect.userservice.model.User;
import org.connect.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping
	public List<User> getUserList(){
		return userRepo.findAll();
	}
	
	@RequestMapping("{name}")
	public User getUser(@PathVariable("name") String name){
		return userRepo.findByName(name);
	}
	
	@PostMapping()
	public User addUser(@RequestBody User user) {
	    return userRepo.save(user);
	}
	
	@DeleteMapping("{name}")
	public User removeUser(@PathVariable("name") String name){
		User userTodelete = userRepo.findByName(name);
		userRepo.delete(userTodelete);
		return userTodelete;
	}
	
	@PutMapping()
	public User updateUser(@RequestBody User user) {
		User userToUpdate = userRepo.findByName(user.getName());
		userRepo.delete(userToUpdate);
	    return userRepo.save(user);
	}
}
