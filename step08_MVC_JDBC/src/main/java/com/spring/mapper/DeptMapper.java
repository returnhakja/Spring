package com.spring.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.dto.Dept;

public interface DeptMapper{
	
	//resultType
	//String 
	public String getDeptNameByDeptno(int deptno);
	
	
	//객체
	public Dept getDeptByDeptno(int deptno);
	
	
	
	// HashMap
	public HashMap<String, Object> getDeptMap(int deptno);
	
	//List
	public List<Dept> getAlldepts();
	
	//List<HashMap<String, Object>>
	public List<HashMap<String, Object>> getAlldeptsMap();
	
	
	//parameter
	// 객체
	// insert
	public void insertDept(Dept dept);
	
	
	//update
	public void updateDeptByDeptnoAndDname(Map data);
	
	//똑같은 update문이지만 조건 하나만으로 하는법?
	
	//복수 인서트?
	public void insertDepts(List<Dept> deptList);
	
	//delete
	public void deleteDeptByLoc(String loc);
}
