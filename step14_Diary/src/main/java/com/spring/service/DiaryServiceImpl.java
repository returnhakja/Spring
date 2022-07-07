package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.dto.DiaryDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Diary;
import com.spring.repository.DiaryRepository;

@Service
public class DiaryServiceImpl implements DiaryService{
	@Autowired //의존성주입
	DiaryRepository diaryRepository;
	
	//돈을보내고 들어가는거 까지 하나의 작업으로 처리함 트랜잭셔널이(?)
	@Transactional
	@Override
	public void insertDiary(DiaryDTO diaryDTO) {
		Diary diaryEntity = diaryDTO.toEntity(diaryDTO);
		
		diaryRepository.save(diaryEntity); // 애쓰면 save 계속 씀 ㅠㅠ
		
	}

	
	@Transactional
	@Override
	public void insertDiaryBatch(List<DiaryDTO> diaryDTOList) {
//		List<Diary> diaryEntityList = new ArrayList<Diary>();
		
		//version1
//		for(DiaryDTO diaryDTO : diaryDTOList) {
//			
//			diaryEntitList.add(diaryDTO.toEntity(diaryDTO));
//		}
		
		//version2
//		diaryDTOList.forEach(diaryDTO -> diaryEntitList.add(diaryDTO.toEntity(diaryDTO)));
		
		
		//version3
		List<Diary> diaryEntityList = diaryDTOList.stream()
                .map(diaryDTO -> diaryDTO.toEntity(diaryDTO))
                .collect(Collectors.toList());
		
		
		
		diaryRepository.saveAll(diaryEntityList);
	}


	public PageResultDTO<DiaryDTO, Diary> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageble(Sort.by("no").descending());
		
		Page<Diary> result =diaryRepository.findAll(pageable);
		
		//entity -> DTO
		Function<Diary, DiaryDTO>  function = (diaryEntity -> diaryEntity.toDTO(diaryEntity));
		
		return new PageResultDTO<DiaryDTO, Diary>(result, function);
	}
	
}
