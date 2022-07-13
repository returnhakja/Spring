package com.spring.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.dto.UserDTO;
import com.spring.entity.Board;
import com.spring.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findUserByUserEmail(String userEmail);

	public void deleteByUserEmail(String userEmail);
}
