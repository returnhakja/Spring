package com.spring.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.Dept;
import com.spring.service.DeptServiceImpl;

@org.springframework.web.bind.annotation.RestController

// Controller + Responsebody 붙어있는 형태
public class RestController {
	@Autowired
	
	private DeptServiceImpl deptService;

	@GetMapping(value = "/api/test")
	public String apiTest() {
		return "test";
	}

	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@PostMapping(value = "/api/dept/{deptno}/{dname}/{loc}")
	public void insertDept(Dept dept) {
		System.out.println(dept);
		deptService.insertDept(dept);

	}

	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	  @GetMapping(value = "/api/depts") public List<Dept> getAlldepts() { return
	  deptService.getAlldepts(); };
	 
	

	@PostMapping(value = "/api/deptjson/{deptno}/{dname}/{loc}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertDeptJSON(@RequestBody Dept dept) {
		System.out.println(dept);
		

		deptService.insertDept(dept);
	}
	
	/*
	 * @CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	 */
	@PostMapping(value = "/api/deptform", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void insertDeptform(Dept dept) { // form 형태에서는 @ModelAttribute를 받는데 저건 기본타입이다 그래서 없어도댐 consumes도 없어도댐
		System.out.println(dept);
//		deptService.insertDept(dept);
	}

	
	@GetMapping(value = "/api/no-proxy")
	public String noProxy() {
		System.out.println("/no-proxy");
		return "no-proxy";
	}

	@GetMapping(value = "/api/proxy")
	public String proxy() {
		System.out.println("/proxy");
		return "proxy";
	}
	
	@GetMapping(value = "/api/no-cors")
	public String noCors() {
	System.out.println("/api/no-cors");	
		return "api/no-cors";
	}
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@GetMapping(value = "/api/cors")
	public String cors() {
		System.out.println("/api/cors");	
		return "api/cors";
	}
	
//	@DeleteMapping(value = "/api/deptdelete/{loc}")
//	public void deletes(String loc) {
//		System.out.println(loc);
////		deptService.deleteDeptByLoc(loc);
//	}
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@DeleteMapping(value = "/api/deptdelete/{loc}")
	public void deletes(@PathVariable String loc) {
		System.out.println(loc);
		deptService.deleteDeptByLoc(loc);
	}
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@PutMapping(value = "/api/update/{loc}/{deptno}/{dname}")
	public void updates(@PathVariable Map data) {
		System.out.println(data);
		deptService.updateDeptByDeptnoAndDname(data);
	}
	
	

}
