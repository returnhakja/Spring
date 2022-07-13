package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.BoardDTO;
import com.spring.dto.CommentDTO;
import com.spring.entity.Board;
import com.spring.entity.Comment;
import com.spring.repository.BoardRepository;
import com.spring.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentSerivce{
	 
	private final CommentRepository commentRepository;
	private final BoardRepository boardReposiory;
	@Override
	public List<CommentDTO> findAll() {
		List<CommentDTO> commentDTO = new ArrayList<CommentDTO>();
		System.out.println(commentRepository.findAll());
		
		commentDTO = commentRepository.findAll()
				.stream()
				.map(comment -> comment.toDTO(comment)).collect(Collectors.toList());
				
		System.out.println(commentDTO);
		return commentDTO;

	}
	
	
	
	@Override
	public Comment findCommentByCommentNo(Long commentNo) {
		return commentRepository.findCommentByCommentNo(commentNo);		
	}
	
	@Override
	public void deleteCommentBycommentNo(Long commentNo) {
		commentRepository.deleteById(commentNo);
	}
//
	@Override
	public void CommentByInsert(CommentDTO commentDTO) {
		Comment comment = commentDTO.toEntity(commentDTO);
		System.out.println(comment);
		commentRepository.save(comment);
	}
	
	@Override
	public void CommentByUpdate(CommentDTO commentDTO) {
		Comment comment = findCommentByCommentNo(commentDTO.getCommentNo());
		comment.updateComment(commentDTO);
		
		commentRepository.save(comment);
	}

	@Override
	public List<Comment> CommentByboardNo(Long boardNo){
		return commentRepository.findComentByBoardBoardNo(boardNo);
	}

	
	

	

	

	
}
