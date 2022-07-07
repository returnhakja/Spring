package com.example.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@DynamicUpdate(true)
//@DynamicUpdate(Emp)
public class Emp {
   
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
  
   
}