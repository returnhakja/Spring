package com.spring.api;

import java.util.List;
import java.util.Optional;

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

import com.spring.dto.BoardDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Board;
import com.spring.service.BoardServiceImpl;

@RestController
public class BoardRestController {
	
	@Autowired
	BoardServiceImpl boardService;
	
//	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
//	@GetMapping(value = "/board")
//	public List<Board> BoardAll(){
//		return BoardService.getBoardAll();
//	}
//	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@GetMapping(value = "/boards")
	public List<BoardDTO> findAll(){
		return boardService.findAll();
	}
	
//	@GetMapping(value = "/board/boardlist")
//	public PageResultDTO<BoardDTO, Board> getBoardList(PageRequestDTO pageRequestDTO){
//		PageResultDTO<BoardDTO, Board> pageResultDTO = boardService.getList(pageRequestDTO);
//		
//		return pageResultDTO;
//	}
//
	//페이징
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	 @GetMapping(value = "/board/boardlist")
	   public PageResultDTO<BoardDTO, Board> findAll(@RequestParam int page, @RequestParam int size) {
	      PageResultDTO<BoardDTO, Board> pageResultDTO = null;
	      try {
	         PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(page).size(size).build();
	         pageResultDTO = boardService.getList(pageRequestDTO);

	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      return pageResultDTO;
	   }

	
//	@GetMapping(value = "/board/{boardno}")
//	public List<BoardDTO> BoardByBoardNo(@PathVariable Long boardno) {
//		System.out.println(boardno);
//		
//		return boardService.findAllByboardNo(boardno);
//	}
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@GetMapping(value = "/board/{boardno}")
	public Board BoardByBoardNo(@PathVariable Long boardno) {
		System.out.println(boardno);
		return boardService.getBoardByBoardNo(boardno);
	}
	
	
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@DeleteMapping(value = "/board/{boardno}")
	public void BoardByDelete(@PathVariable Long boardno) {
//		System.out.println(boardno);
		boardService.deleteBoardByboardNo(boardno);
		
	} 
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@PostMapping(value = "/board/insert",  consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void BoardByInsert(@RequestBody BoardDTO boardDTO ) {
		System.out.println(boardDTO);
		boardService.insertByboard(boardDTO);
	}
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@PutMapping(value="/board/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateBoardByBoardNo(@RequestBody BoardDTO boardDTO) {
		
		boardService.updateByboard(boardDTO);
	}
}
