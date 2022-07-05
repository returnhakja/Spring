package com.example.service;

import java.util.List;

import com.example.model.Dept;

public interface DeptService {
	public List<Dept> getDeptAll();

	public Dept getDeptByDeptno(Long deptno);

	public void deleteDeptByDeptno(Long deptno);

	public void insertByDept(Dept dept);

//	public  void deptByUpdet(Long deptno);
	public  void deptByUpdet(String dname,  Long deptno);
		
	
}
