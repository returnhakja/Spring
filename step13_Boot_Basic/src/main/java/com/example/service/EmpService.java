package com.example.service;

import java.util.List;

import com.example.dto.EmpDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.model.Dept;
import com.example.model.Emp;

public interface EmpService {
	public List<Emp> getEmpAll();

	public Emp getEmpByEmpno(Long empno);

	public void deleteEmpByEmpno(Long empno);

	public void insertByEmp(Emp emp);

	public  void empByUpdete(Long empno, Double sal);
		
	public PageResultDTO<EmpDTO, Emp> getList(PageRequestDTO pageRequestDTO);
}
