package com.example.dto;

import com.example.model.Emp;

import javax.persistence.Id;

import com.example.dto.EmpDTO;
import com.example.model.Emp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpDTO {

	
	@Id
	   private Long empno;
	   
	   private String ename;
	   
	   private String job;
	   
	   private Long mgr;
	   
	   private String hiredate;
	   
	   private Double sal;
	   
	   private Double comm;
	
	
	public Emp toEntity(EmpDTO empDTO) {
		Emp empEntity = Emp.builder()
							.empno(empDTO.getEmpno())
							.ename(empDTO.getEname())
							.job(empDTO.getJob())
							.mgr(empDTO.getMgr())
							.hiredate(empDTO.getHiredate())
							.sal(empDTO.getSal())
							.comm(empDTO.getComm())
							.build();
		return empEntity;
	}
}
