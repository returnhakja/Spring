package com.spring.service;

import java.util.List;

import com.spring.dto.CommentDTO;
import com.spring.entity.Comment;

public interface CommentSerivce {
	public List<CommentDTO> findAll();

	public Comment findCommentByCommentNo(Long commentNo);

	public void deleteCommentBycommentNo(Long commentNo);

	public void CommentByInsert(CommentDTO commentDTO);

	public void CommentByUpdate(CommentDTO commentDTO);

	public List<Comment> CommentByboardNo(Long boarNo);

	
	
	
}
