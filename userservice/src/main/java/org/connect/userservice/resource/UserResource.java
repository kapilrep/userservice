package org.connect.userservice.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.connect.userservice.model.User;
import org.connect.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping("/{name}")
	public User handleUser(@PathVariable("name") String name){
		return userRepo.findByName(name);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public User handleUser(@RequestBody User user) {
	    return userRepo.save(user);
	}
	
	@RequestMapping(value="/{name}", method=RequestMethod.DELETE)
	public User removeUser(@PathVariable("name") String name, HttpServletResponse response) {
		User userTodelete = userRepo.findByName(name);
		if(null!=userTodelete) {
			userRepo.delete(userTodelete);
		}else {
			 response.addHeader("UserService-Header-Error", "404");
		}
		return userTodelete;
	}
	
	@PutMapping()
	public User updateUser(@RequestBody User user, HttpServletResponse response) {
		User userToUpdate = userRepo.findByName(user.getName());
		userRepo.delete(userToUpdate);
		response.addHeader("UserService-Header-AuthCheck", "OK");
	    return userRepo.save(user);
	}
	
	@GetMapping("/http-servlet-response")
	public String usingHttpServletResponse(HttpServletResponse response) {
	    response.addHeader("UserService-Header", "202");
	    return "Response with header using HttpServletResponse";
	}
}
