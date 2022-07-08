package com.example.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.dto.EmpDTO;
import com.example.model.Emp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

////@Data
//@NoArgsConstructor
//@Entity
//@Builder
////@DynamicUpdate(true)
////@DynamicUpdate(Emp)
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Emp implements Persistable<Long>{
   
   @Id
   private Long empno;
   
   private String ename;
   
   private String job;
   
   private Long mgr;
   
   private String hiredate;
   
   private Double sal;
   
   private Double comm;
   
   @ManyToOne
   @JoinColumn(name = "deptno", foreignKey = @ForeignKey(foreignKeyDefinition = "FOREIGN KEY (deptno) references Emp (deptno) ON DELETE SET NULL"))
   private Dept dept;
	
   @Override
   public Long getId() {
	   // TODO Auto-generated method stub
	   return empno;
   }
   
   
   @Override
   public boolean isNew() {
	   return empno == null;
   }
   
	public EmpDTO toDTO(Emp empEntity) {
		EmpDTO diaryDTO = EmpDTO.builder()
				.empno(empEntity.getEmpno())
				.ename(empEntity.getEname())
				.job(empEntity.getJob())
				.mgr(empEntity.getMgr())
				.hiredate(empEntity.getHiredate())
				.sal(empEntity.getSal())
				.comm(empEntity.getComm())
				.build();
		return diaryDTO;
	}


   
}