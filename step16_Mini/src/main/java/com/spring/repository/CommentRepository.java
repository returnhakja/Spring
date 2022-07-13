package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.dto.CommentDTO;
import com.spring.entity.Board;
import com.spring.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

	
	public List<Comment> findAll();
	public Comment findCommentByCommentNo(Long commentNo);
	
	
	public List<Comment> findComentByBoardBoardNo(Long boardNo);
}
