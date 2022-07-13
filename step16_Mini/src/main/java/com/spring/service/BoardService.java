package com.spring.service;

import java.util.List;
import java.util.Optional;


import com.spring.dto.BoardDTO;
import com.spring.entity.Board;

public interface BoardService {

//	public List<Board> getBoardAll();

	public List<BoardDTO> findAll();
	
//	public List<BoardDTO> findAllByboardNo(Long boardNo);
	public Board getBoardByBoardNo(Long boardNo);
	
	public void deleteBoardByboardNo(Long boardNo);
	
	public void insertByboard(BoardDTO boardDTO);
	
	public void updateByboard(BoardDTO boardDTO);
	
	
}
