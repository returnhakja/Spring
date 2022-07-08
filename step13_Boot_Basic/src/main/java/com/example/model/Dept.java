package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class Dept {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptno;
	
	private String dname;
	
	private String loc;
	
	
	
}
