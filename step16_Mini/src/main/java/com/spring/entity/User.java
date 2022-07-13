package com.spring.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.spring.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DynamicUpdate(true)
public class User {
	
	@Id
	@Column(name="user_email")
	private String userEmail;
		
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_password")
	private String userPassword;
	
	@CreatedDate
	@Column(name = "registered_date")
	private LocalDateTime createDate;
	
	@LastModifiedDate
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;
	
	
	
	public UserDTO toDTO(UserDTO userEntity) {
		
		UserDTO userDTO = UserDTO.builder()
				.userEmail(userEntity.getUserEmail())
				.userName(userEntity.getUserName())
				.userPassword(userEntity.getUserPassword())
				.createDate(userEntity.getCreateDate())
				.modifiedDate(userEntity.getModifiedDate())
				.build();
		
		return userDTO;
		
	}
}
