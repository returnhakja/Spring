package com.spring.dto;

import java.time.LocalDateTime;
import com.spring.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

	private String userEmail;
	private String userName;
	private String userPassword;
	private LocalDateTime createDate;
	private LocalDateTime modifiedDate;
	
public User toEntity(UserDTO userDTO) {
		
	User userEntitiy = User.builder()
									.userEmail(userDTO.getUserEmail())
									.userName(userDTO.getUserName())
									.userPassword(userDTO.getUserPassword())
									.createDate(userDTO.getCreateDate())
									.modifiedDate(userDTO.getModifiedDate())
									.build();
				
		return userEntitiy;
	}
}
