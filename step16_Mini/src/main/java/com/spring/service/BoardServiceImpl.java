package com.spring.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.dto.BoardDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Board;
import com.spring.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardRepository BoardRepository;

//	@Override
//	public List<Board> getBoardAll() {
//		
//		return BoardRepository.findAll();
//	}
//	

	
	@Override
	   public List<BoardDTO> findAll() {
	      List<BoardDTO> boardDTO = null;

	      boardDTO =  BoardRepository.findAll()
	            .stream()
	            .map(board -> board.toDTO(board)).collect(Collectors.toList());
	            

	      return boardDTO;
	   }


//	@Override
//	public List<BoardDTO> findAllByboardNo(Long boardNo) {
//		List<BoardDTO> boardDto = null;
//		return boardDto = BoardRepository.findAllByboardNo(boardNo).stream().map(boardDto2 -> boardDto2.toDTO(boardDto2)).collect(Collectors.toList());
//	}
	

	@Override
	public Board getBoardByBoardNo(Long boardNo) {
		return BoardRepository.findAllByboardNo(boardNo);
	}
	
	
	
	@Override
	public void deleteBoardByboardNo(Long boardNo) {
		BoardRepository.deleteById(boardNo);
		
	}
	



	@Override
	public void insertByboard(BoardDTO boardDTO) {
		Board boardEntity = boardDTO.toEntity(boardDTO);
		BoardRepository.save(boardEntity);
	}
	
	@Override
	public void updateByboard(BoardDTO boardDTO) {
		Board board = getBoardByBoardNo(boardDTO.getBoardNo());
		board.updateBoard(boardDTO);
		
		BoardRepository.save(board);
	}


	public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageble(Sort.by("boardNo").descending());
		Page<Board> result = BoardRepository.findAll(pageable);
		Function<Board, BoardDTO> function = (boardEntity -> boardEntity.toDTO(boardEntity));

		return new PageResultDTO<BoardDTO, Board>(result, function);
	}
	
	
	
	
}
