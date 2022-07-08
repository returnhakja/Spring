package com.spring.dto;

import com.spring.entity.FileEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class FileDTO {
	private Long id;
	
	private String originalFilename;
	
	private String filename;
	
	private String filePath;
	
	
	public FileEntity toEntity(FileDTO fileDTO) {
//		FileEntity fileEntity = FileEntity.builder()
//				.originalFilename(fileDTO.getOriginalFilename())
//				.filename(fileDTO.getFilename())
//				.filePath(fileDTO.getFilePath()
//				builder();
		
		FileEntity fileEntity = FileEntity.builder()
				.originalFilename(fileDTO.getOriginalFilename())
				.filename(fileDTO.getFilename())
				.filePath(fileDTO.getFilePath())
				.build();
		
				return fileEntity;
	}
}
