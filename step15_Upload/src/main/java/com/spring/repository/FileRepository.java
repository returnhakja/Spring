package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.spring.dto.FileDTO;
import com.spring.entity.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long>{

//	public FileDTO findEmpByEmpno(int id );
	
}
