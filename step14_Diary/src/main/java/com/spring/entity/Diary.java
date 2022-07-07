package com.spring.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.dto.DiaryDTO;

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
public class Diary implements Persistable<Long>{
	
	@Id
	private Long no;
	
	private String title;
	
	private String content;
	
	@CreatedDate //어노테이션 필드를 통해 오늘날짜가 알아서 들어간다
	private LocalDateTime writtenTime;

	@Override
	public Long getId() {
		return no;
	}

	@Override
	public boolean isNew() { //영속성이 관리하는 객체가 디비에 있는지없는지 판단해주는 메소드 (얘가 중요함)
		//return false;     //기본으로  false로 되있어서 새로운객체로 판단해서 select가 계속 날아간다
		return writtenTime == null; //writtemTime이 없으면 없는객체니까 select를 하지 않음
	}

	//entity -> DTO 변경
	public DiaryDTO toDTO(Diary diaryEntity) {
		DiaryDTO diaryDTO = DiaryDTO.builder()
							.no(diaryEntity.getNo())
							.title(diaryEntity.getTitle())
							.content(diaryEntity.getContent())
							.writtenTime(diaryEntity.getWrittenTime())
							.build();
		return diaryDTO;
	}
	
	
	
	
}
