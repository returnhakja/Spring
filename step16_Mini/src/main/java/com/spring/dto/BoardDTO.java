package com.spring.dto;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.spring.entity.Board;
import com.spring.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDTO {
   
   private Long boardNo;
   
   private User user;
   
   private String boardTitle;
   
   private String boardContent;
   
   private LocalDateTime createdDate;
   
   private LocalDateTime modifiedDate;
   
   
   
   public Board toEntity(BoardDTO boardDTO) {
         
      Board boardEntitiy = Board.builder()
                        .boardNo(boardDTO.getBoardNo())
                        .user(boardDTO.getUser())
                        .boardTitle(boardDTO.getBoardTitle())
                        .boardContent(boardDTO.getBoardContent())
                        .createdDate(boardDTO.getCreatedDate())
                        .modifiedDate(boardDTO.getModifiedDate())
                        .build();
   
      return boardEntitiy;
   }
   
   
}