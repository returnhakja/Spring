package com.spring.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.dto.BoardDTO;

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
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate(true)
public class Board {
   
   @Id
   @Column(name="board_no")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long boardNo;
   
   
   // many to one
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "user_email")
   private User user;
   
   
   @Column(name="board_title")
   private String boardTitle;
   
   @Column(name="board_content")
   private String boardContent;
   
   
   @CreatedDate
   @Column(name="registered_date" ,updatable = false)
   private LocalDateTime createdDate;
   
   @LastModifiedDate
   @Column(name="modified_date", insertable = false)
   private LocalDateTime modifiedDate;
   
   public BoardDTO toDTO(Board boardEntity) {
      BoardDTO boardDTO = BoardDTO.builder()
                     .boardNo(boardEntity.getBoardNo())
                     .user(boardEntity.getUser())
                     .boardTitle(boardEntity.getBoardTitle())
                     .boardContent(boardEntity.getBoardContent())
                     .createdDate(boardEntity.getCreatedDate())
                     .modifiedDate(boardEntity.getModifiedDate())
                     .build();
      return boardDTO;
   }

public void updateBoard(BoardDTO boardDTO) {
	this.boardTitle = boardDTO.getBoardTitle();
	this.boardContent = boardDTO.getBoardContent();
	
}




   
   
}