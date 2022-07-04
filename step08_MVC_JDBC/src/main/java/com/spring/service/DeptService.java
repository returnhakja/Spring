package com.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.spring.dto.Dept;

public interface DeptService {
   public Dept getDeptByDeptno(int deptno);
   
   public String getDeptNameByDeptno(int deptno);
   
   public HashMap<String, Object> getDeptMap(int deptno);
   
   public List<Dept> getAlldepts();
   
   public List<HashMap<String, Object>> getAlldeptsMap();
   
   
   public void insertDept(Dept dept);
   
   
   
 //update
   public void updateDeptByDeptnoAndDname(Map data);
   
   
   //delete
   public void deleteDeptByLoc(String loc);
   
}