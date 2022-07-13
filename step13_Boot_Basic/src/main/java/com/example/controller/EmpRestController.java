package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmpDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.model.Emp;
import com.example.service.EmpServiceImpl;

@RestController
//@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
public class EmpRestController {
	@Autowired
	EmpServiceImpl EmpService;
	
	
	//페이지이잉
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	   @GetMapping(value="/emp/empspaging")
	   public PageResultDTO<EmpDTO, Emp> getEmpAll(@RequestParam int page, @RequestParam int size ) {
		  PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				  .page(page)
				  .size(size)
				  .build();
				  
	      PageResultDTO<EmpDTO, Emp> pageResultDTO = EmpService.getList(pageRequestDTO);
//	      List<EmpDTO> empList = new ArrayList<EmpDTO>();
	      // ??
//	      pageResultDTO.getDtoList().forEach(empDto -> empList.add(empDto));
	      return pageResultDTO;
	   }
	
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@GetMapping(value = "/Emps")
	public List<Emp> getEmps(){
		return EmpService.getEmpAll();
	}
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@GetMapping(value = "/emps/{empno}")
	public Emp getEmpByEmpno(@PathVariable Long empno) {
		System.out.println(empno);
		return EmpService.getEmpByEmpno(empno);
	}
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@DeleteMapping(value = "/emp/{empno}")
	public void EmpByDelete(@PathVariable Long empno) {
		System.out.println(empno);
		EmpService.deleteEmpByEmpno(empno);
	
	} 
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@PostMapping(value = "/emp/insert",  consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void EmpByInsert(@RequestBody Emp emp ) {
		Emp check = new Emp();
		System.out.println("dddd");
		check = getEmpByEmpno(emp.getEmpno());
		if(check == null) {
			Emp emp1 = new Emp();
//			emp1.setEmpno(emp.getEmpno());
//			emp1.setEname(emp.getEname());
//			emp1.setJob(emp.getJob());
//			emp1.setMgr(emp.getMgr());
//			emp1.setHiredate(emp.getHiredate());
//			emp1.setSal(emp.getSal());
//			emp1.setComm(emp.getComm());
//			emp1.setDept(emp.getDept());
			
			System.out.println(emp.getDept());
			System.out.println(emp1);
			EmpService.insertByEmp(emp1);
		}
		else {
			System.out.println("있다는데");
		}
	}
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@PutMapping(value="/emp/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
	   public void updateDept(@RequestBody Emp emp) {
		System.out.println(emp.getEmpno());
	      System.out.println(emp.getSal());

	      EmpService.empByUpdete(emp.getEmpno(), emp.getSal());
	   }

	
		
	
}
