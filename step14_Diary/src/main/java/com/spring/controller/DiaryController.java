package com.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.DiaryDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Diary;
import com.spring.repository.DiaryRepository;
import com.spring.service.DiaryServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor // 다이어리컨트롤러 객체가 생성될때 내부에 있는 모든 필드가 생성 (final이 붙거나 @NotNull이 붙은 필드(멤버변수)의 생성자를 자동 생성하는 어노테이션
public class DiaryController {
	
//	@Autowired
//	private final DiaryServiceImpl diaryServiceImpl;
	
	@Autowired
	private final DiaryServiceImpl diaryServiceImpl;
	
	@Autowired
	DiaryRepository diaryRepository;
	
	@PostMapping("/diary")
	public void insertDiary(@RequestBody DiaryDTO diaryDTO) {
		
		diaryServiceImpl.insertDiary(diaryDTO);	
	}
	
	//대용량 데이터 넣기 (여러개 넣기)
	@PostMapping("/diary-batch")
//	public void insertDiaryBatch(List<DiaryDTO> diaryDTOList) {
	public void insertDiaryBatch() {
		List<DiaryDTO> diaryDTOList = new ArrayList<DiaryDTO>();
		IntStream.rangeClosed(1, 200).forEach(i -> {
			DiaryDTO diaryDTO = DiaryDTO.builder()
								.no(Long.valueOf(i))
								.title("Title:" + i)
								.content("Content :" + i)
								.build();
			diaryDTOList.add(diaryDTO);
//			diaryServiceImpl.insertDiary(diaryDTO);		// 셀인셀인 된다			
		}); //1부터200개 넣어주는거
		diaryServiceImpl.insertDiaryBatch(diaryDTOList);
	}
	
	//페이징처리
	// Pageable 인터페이스 -> 구현체 PageRequest
	// Pageable pageable = new RageRequest() ; xxx 이거안댐
	// 내부 static of 메소드를 사용할 수 있음
	//of(int page, int size) : (페이지 번호(0부터시작), 개수)
	//of(int page, int size , Sort sort) : 페이지번호, 개수, 정렬
	
	
	@GetMapping("/pageable")
	public void pageDefault() {
		Pageable pageable1 = PageRequest.of(10, 10);
		
		Page<Diary> result = diaryRepository.findAll(pageable1);
		System.out.println(result);
		System.out.println("===pageable result");
		System.out.println(result.getTotalPages());  //전체페이지
		System.out.println(result.getTotalElements()); //전체데이터개수
		
		System.out.println(result.getNumber()); // 현재페이지번호 : 0부터 시작
		System.out.println(result.getSize()); //페이지당 데이터 개수
	
		//다음페이지 혹은 이전페이지 존재여부
		System.out.println(result.hasNext()); 
		System.out.println(result.hasPrevious());
		// 모든데이터는
		System.out.println(result.getContent());
		
		//정렬 조건
		Sort sort1 = Sort.by("no").descending();
		Pageable pageable2 = PageRequest.of(0, 10, sort1);
		
		Page<Diary> result2 = diaryRepository.findAll(pageable2);
		result2.forEach(diary ->{
			System.out.println(diary);
		});
		
		
		System.out.println("====쿼리메소드+pageable===");
		//쿼리메소드 + pageable 연관선상 갋을 읽어올까?
		Pageable pageable3 = PageRequest.of(0, 10,Sort.by("no").descending() );
		Page<Diary> result3 = diaryRepository.findByNoBetween(10L,50L, pageable3);
		
		result3.get().forEach(diary -> {
			System.out.println(diary);
		});
		
		
		//고려사항
		//Entity -> DTO
		//DTO -> Pageble
		// 페이지 번호  -> 페이징만 처리하는 DTO를 만듬
		
		System.out.println("====PageRequestDTO====");
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
										.page(1)
										.size(10)
										.build();
		PageResultDTO<DiaryDTO, Diary> pageResultDTO =diaryServiceImpl.getList(pageRequestDTO); 
		System.out.println(pageResultDTO.isPrev()); //?? false
		System.out.println(pageResultDTO.isNext()); //?? next
		System.out.println(pageResultDTO.getTotalPage()); // ?? 20
		System.out.println("=======PageRequestDTO 객체값 출력(1번 페이지에 있는 내용만)======");
		//??
		pageResultDTO.getDtoList().forEach(diaryDTO-> System.out.println(diaryDTO));
		pageResultDTO.getPageList().forEach(diaryDTO -> System.out.println(diaryDTO));
	}
	
	
	
	@GetMapping("/diary")
	public void getDiary(PageRequestDTO pageRequestDTO) {
		System.out.println(pageRequestDTO);
		
//		pageRequestDTO.get
	}
	
	
	
	
	
	
	
	
	
	
}
 