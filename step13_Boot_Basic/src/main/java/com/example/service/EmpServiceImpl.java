package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Dept;
import com.example.model.Emp;
import com.example.repository.DeptRepository;
import com.example.repository.EmpRepository;

@Service
public class EmpServiceImpl implements	EmpService{

	
	@Autowired
	private EmpRepository EmpRepository;
	
	@Override
	public List<Emp> getEmpAll() {
		
		return EmpRepository.findAll();
	}

	 @Override
	 public Emp getEmpByEmpno(Long empno) {
	    return EmpRepository.findEmpByEmpno(empno);
	  }

	 @Override
	 public void deleteEmpByEmpno(Long empno) {
	    EmpRepository.deleteById(empno);
	  }
	
	 @Override
	 public void insertByEmp(Emp emp) {
		 EmpRepository.save (emp);
	 }

	
	 @Override
	   public void empByUpdete(Long empno, Double sal) {
	      Emp emp = getEmpByEmpno(empno);
	      emp.setSal(sal);
	      EmpRepository.save(emp);   
	   }
}

