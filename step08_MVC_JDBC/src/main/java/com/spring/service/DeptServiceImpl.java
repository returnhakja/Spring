package com.spring.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Dept;
import com.spring.mapper.DeptMapper;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	DeptMapper deptMapper;

	
	@Override
	public Dept getDeptByDeptno(int deptno) {
		
		return deptMapper.getDeptByDeptno(deptno);
	}
	
	
	@Override
	public String getDeptNameByDeptno(int deptno) {
		
		return deptMapper.getDeptNameByDeptno(deptno);
	}
	
	// HashMap
	public HashMap<String, Object> getDeptMap(int deptno){
		return deptMapper.getDeptMap(deptno);
	}
	
	@Override
	public List<Dept> getAlldepts()
	{
		return deptMapper.getAlldepts();
	}
	
	
	//List<HashMap>String, Object>
  public List<HashMap<String, Object>> getAlldeptsMap(){
		return deptMapper.getAlldeptsMap();
	}
  
  @Override
  public void insertDept(Dept dept) {
     deptMapper.insertDept(dept);
  }




	
  @Override
  public void updateDeptByDeptnoAndDname(Map data) {
     deptMapper.updateDeptByDeptnoAndDname(data);
  }


	@Override
	public void deleteDeptByLoc(String loc) {
		deptMapper.deleteDeptByLoc(loc);
		
	};


	
	
}
