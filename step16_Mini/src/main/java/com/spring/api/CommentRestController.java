package com.spring.api;

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
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.CommentDTO;
import com.spring.entity.Comment;
import com.spring.service.CommentServiceImpl;

@RestController
public class CommentRestController {
	@Autowired
	CommentServiceImpl commentService;
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@GetMapping(value = "/comment")
	public List<CommentDTO> findAll(){
		return commentService.findAll();
	}
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@GetMapping(value = "/comment/{commentno}")
	public Comment findCommentByCommentNo(@PathVariable Long commentno) {
		return commentService.findCommentByCommentNo(commentno);
	}
	
	
	
	
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@DeleteMapping(value = "/commentd/{commentno}")
	public void deleteByCommentNo(@PathVariable Long commentno) {
		commentService.deleteCommentBycommentNo(commentno);
	}
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@PostMapping(value = "/commentin", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void insertByComment(@RequestBody CommentDTO commentDTO) {
		System.out.println(commentDTO);
		commentService.CommentByInsert(commentDTO);
	}
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@PutMapping(value = "/commentup", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void updateComment(@RequestBody CommentDTO commentDTO) {
		commentService.CommentByUpdate(commentDTO);
	}
	
	
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@GetMapping(value = "/comment/comments/{boardNo}")
	public List<Comment> CommentsByBoardNo(@PathVariable Long boardNo){
		return commentService.CommentByboardNo(boardNo);
	}

}
