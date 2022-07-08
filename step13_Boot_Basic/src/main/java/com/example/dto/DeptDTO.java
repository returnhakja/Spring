package com.example.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import com.example.model.Dept;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class DeptDTO {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptno;
	
	private String dname;
	
	private String loc;
	
	public DeptDTO(Long deptno) {
		if(deptno != null) {
			this.deptno = deptno;
		}
	}
	
	
	
	
	
//	public Dept dtoToEntity(DeptDTO deptDTO) {
//		Dept deptEntity = Dept.builder()
//				.dname(deptDTO.getDname())
//				.loc(deptDTO.getLoc())
//				.build()
//				return deptEntity
//	}
}
