package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dto.EmpDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.model.Dept;
import com.example.model.Emp;
import com.example.repository.DeptRepository;
import com.example.repository.EmpRepository;
import com.example.dto.EmpDTO;
import com.example.model.Emp;

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
//	      emp.setSal(sal);
	      EmpRepository.save(emp);   
	   }

	public PageResultDTO<EmpDTO, Emp> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageble(Sort.by("empno").descending());
		
		Page<Emp> result =EmpRepository.findAll(pageable);
		
		//entity -> DTO
		Function<Emp, EmpDTO>  function = (empEntity -> empEntity.toDTO(empEntity));
		
		return new PageResultDTO<EmpDTO, Emp>(result, function);
	}
}

