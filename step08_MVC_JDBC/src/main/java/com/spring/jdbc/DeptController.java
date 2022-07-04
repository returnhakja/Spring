package com.spring.jdbc;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.Dept;
import com.spring.service.DeptServiceImpl;

@Controller
public class DeptController {
	
	@Autowired
	private DeptServiceImpl deptService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		deptService.getDeptByDeptno(10);
		
		model.addAttribute("deptno", deptService.getDeptByDeptno(10));
		model.addAttribute("dname" , deptService.getDeptNameByDeptno(10));
		model.addAttribute("dname1", deptService.getDeptMap(10));
		model.addAttribute("alldept", deptService.getAlldeptsMap());
		
		
//		System.out.println(deptService.getDeptNameByDeptno(10));
//		System.out.println(deptService.getDeptByDeptno(10));
//		System.out.println(deptService.getDeptMap(10));
//		System.out.println(deptService.getAlldeptsMap());
		
//		deptService.insertDept(new Dept(60,"PROGRAMING", "SEOUL"));
		
		
		//updata : where deptno=60 and dname = "PROGRAMMING" -> loc : MOON
//		Map<String , Object> data = new HashMap<String , Object>();
//		data.put("deptno", 60);
//		data.put("dname", "PROGRAMING");
//		data.put("loc", "MOON");
//		deptService.updateDeptByDeptnoAndDname(data);
		
		
		//delete : where loc = "MOON"
		
		deptService.deleteDeptByLoc("MOON");
		
		return "home";
	}
	
}
