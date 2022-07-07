package com.spring.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import com.spring.entity.Diary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class DiaryDTO {
	@Id
	private Long no;
	
	private String title;
	
	private String content;
	
	private LocalDateTime writtenTime;
	
	
	public Diary toEntity(DiaryDTO diaryDTO) {
		Diary diaryEntity = Diary.builder()
							.no(diaryDTO.getNo())
							.title(diaryDTO.getTitle())
							.content(diaryDTO.getContent())
							.build();
		return diaryEntity;
	}
	
	
	
}
