package com.example.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {
	// 화면에서 전달되는 Page와 size
	// --> JPA에서 사용하는 Pageable타입의 객체를 생성하기 위해 존재함
	
	private int size;
	private int page;
	
	public PageRequestDTO() {
		//초기값 설정
		this.page = 1; 
		this.size = 10 ;
	}
	public Pageable getPageble(Sort sort) {
		return PageRequest.of(page - 1 , size, sort);
	}
}
