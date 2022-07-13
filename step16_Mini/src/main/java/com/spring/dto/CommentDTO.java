package com.spring.dto;

import java.time.LocalDateTime;

import com.spring.entity.Board;
import com.spring.entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDTO {
	
	
	private Long commentNo;
	
	private Board board;
	
	private String commenter;
	
	private String commentContent;
	
	private LocalDateTime createDate;
	
	private LocalDateTime modifiedDate;
	
	
	public Comment toEntity(CommentDTO commentDTO) {
		
		Comment commentEntitiy = Comment.builder()
									.commentNo(commentDTO.getCommentNo())
									.board(commentDTO.getBoard())
									.commenter(commentDTO.getCommenter())
									.commentContent(commentDTO.getCommentContent())
									.createDate(commentDTO.getCreateDate())
									.modifiedDate(commentDTO.getModifiedDate())
									.build();
				
		return commentEntitiy;
		
	}
}
