package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Dept;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Long>{
	public List<Dept> findAll();
	
	public Dept findDeptByDeptno(Long deptno);

	public void deleteDeptByDeptno(Long deptno);
	
//	public Dept save(Dept dept);

//	public void deptByUpdet(Long deptno);

		
	
}


