package com.spring.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.spring.dto.CommentDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DynamicUpdate(true)
public class Comment {
	
	@Id
	@Column(name="comment_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentNo;
	
	//board_no 관계썰정
//	 @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "board_no")
	 private Board board;
	
	@Column(name="commenter")
	private String commenter;
	
	@Column(name = "comment_content")
	private String commentContent;
	
	
	@CreatedDate
	@Column(name = "registerd_date")
	private LocalDateTime createDate;
	
	@LastModifiedDate
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;
	
	public CommentDTO toDTO(Comment commentEintity) {
		
		CommentDTO commentDTO = CommentDTO.builder()
				.commentNo(commentEintity.getCommentNo())
				.board(commentEintity.getBoard())
				.commenter(commentEintity.getCommenter())
				.commentContent(commentEintity.getCommentContent())
				.createDate(commentEintity.getCreateDate())
				.modifiedDate(commentEintity.getModifiedDate())
				.build();
		
		return commentDTO;
		
	}

	public void updateComment(CommentDTO commentDTO) {
		this.commentContent = commentDTO.getCommentContent();
		this.commenter = commentDTO.getCommenter();
	}
	
}
