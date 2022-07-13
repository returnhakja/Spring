package com.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;
import com.spring.entity.Board;
import com.spring.entity.Comment;


@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{
	
	public List<Board> findAll();

//	public Board findBoardByboardno(Long boardNo);
//	public List<Board> findAllByboardNo(Long boardNo);
	public Board findAllByboardNo(Long boardNo);

	public void deleteBoardByboardNo(Long boardNo);

	public Board findBoardByBoardNo(Long boardNo);

	




	


	
}
