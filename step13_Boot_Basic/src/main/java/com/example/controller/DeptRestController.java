package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Dept;
import com.example.repository.DeptRepository;
import com.example.service.DeptServiceImpl;

@RestController
public class DeptRestController {
	@Autowired
	DeptServiceImpl deptService;
	
	
	
	
	@GetMapping(value = "/depts")
	public List<Dept> getDepts(){
		return deptService.getDeptAll();
	}
	
	@GetMapping(value = "/dept/{deptno}")
	public Dept getDeptBydeptno(@PathVariable Long deptno) {
		System.out.println(deptno);
		return deptService.getDeptByDeptno(deptno);
		
	}
		
	@DeleteMapping(value = "/dept/{deptno}")
	public void DeptByDelete(@PathVariable Long deptno) {
		System.out.println(deptno);
		deptService.deleteDeptByDeptno(deptno);
	
	} 
	
	@PostMapping(value = "/dept/insert",  consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void DepyByInsert(@RequestBody Dept dept) {
		
		System.out.println(dept);
//		deptService.insertByDept(dept);
	}
	
	// JSON 에서 3개 다 때려박는 코드
//	@PostMapping(value = "/dept/insert",  consumes = { MediaType.APPLICATION_JSON_VALUE })
//	public void DepyByInsert(@RequestBody Dept dept) {
//		System.out.println(dept);
//		deptService.insertByDept(dept); 
//	}
	
//	@PostMapping(value = "/dept/insert")
//	public void DepyByInsert() {
//		Dept dept = new Dept();
//		
//		dept.setDeptno(200L);
//		dept.setDname("ddq");
//		dept.setLoc("jamong");
//		
//		deptService.insertByDept(dept);
//	}
	


	
	
	//put 1번
//	@PutMapping(value = "/dept/update/{deptno}")
//	public void DepyByUpdate(@PathVariable Long deptno) {
//
//		System.out.println(deptno);
//		deptService.deptByUpdet(deptno);
//		
//	}
	
	@PutMapping(value="/dept/update")
	   public void updateDept(@RequestBody Dept dept) {
		System.out.println(dept.getDname());
	      System.out.println(dept.getDeptno());

	      deptService.deptByUpdet(dept.getDname(), dept.getDeptno());
	   }

}
