package com.spring.service;

import java.util.List;

import com.spring.dto.UserDTO;
import com.spring.entity.User;

public interface UserService {
	
	public User getUserByUserEmail(String userEmail);
	
	public void deleteUserByUserEmail(String userEmail);
}
