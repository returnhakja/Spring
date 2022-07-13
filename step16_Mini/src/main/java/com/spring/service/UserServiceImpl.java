package com.spring.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.BoardDTO;
import com.spring.dto.UserDTO;
import com.spring.entity.User;
import com.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional
	@Override
	public User getUserByUserEmail(String userEmail) {
		return userRepository.findUserByUserEmail(userEmail);
	}


	@Override
	public void deleteUserByUserEmail(String userEmail) {
		 userRepository.deleteByUserEmail(userEmail);
	}
	

	
	
	
	

	

	
}
