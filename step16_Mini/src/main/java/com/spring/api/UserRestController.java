package com.spring.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.BoardDTO;
import com.spring.entity.User;
import com.spring.service.UserService;
import com.spring.service.UserServiceImpl;


@RestController
public class UserRestController {

	@Autowired
	private UserServiceImpl userService;
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@GetMapping(value = "/user/{userEmail}")
	public User getUserByUserEmail(@PathVariable String userEmail) {
		return userService.getUserByUserEmail(userEmail);
	}
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@DeleteMapping(value = "/user/delete/{userEmail}")
	public void deleteUserByUserEmail(@PathVariable String userEmail) {
		System.out.println(userEmail);
		userService.deleteUserByUserEmail(userEmail);
	}
	
	
	
	
}
