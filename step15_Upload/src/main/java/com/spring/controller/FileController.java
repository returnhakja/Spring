package com.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.FileDTO;
import com.spring.entity.FileEntity;
import com.spring.repository.FileRepository;
import com.spring.service.FileServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:3000")
public class FileController {
   
   private final FileServiceImpl fileservice;
   private final FileRepository fileRepository;
   
   
   @PostMapping("/file-save-test")
   public void testsaveFile(@RequestParam("file") MultipartFile file) {
      try {
      System.out.println("file.save");
      String originalFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
      System.out.println(originalFileName);
      
      // 파일 저장시 경로 설정
      String filePath = System.getProperty("user.dir") + "\\files";
      System.out.println(filePath);
      
      //저장폴더 생성
      if(!new File(filePath).exists()) {
         new File(filePath).mkdir();
      }
      String finalFilePath = filePath + "\\" + originalFileName;
   
         file.transferTo(new File(finalFilePath));
      } catch (IllegalStateException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      
   }
   
   @PostMapping("/file-save2")
   public ResponseEntity saveFile2(@RequestParam("file") MultipartFile file) {
      try {
         String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
         
         String originalFileName = file.getOriginalFilename();
         
         // 파일 저장시 경로 설정
         String filePath = System.getProperty("user.dir") + "\\files";
         
         //저장폴더 생성
         if(!new File(filePath).exists()) {
            new File(filePath).mkdir();
         }
         String finalFilePath = filePath + "\\" + originalFileName;
      
            file.transferTo(new File(finalFilePath));
            
            FileDTO fileDTO = FileDTO.builder()
                                 .originalFilename(originalFileName)
                                 .filename(filename)
                                 .filePath(finalFilePath)
                                 .build();
                                 
            Long saveFile = fileservice.saveFile(fileDTO);
           
//            FileDTO fileDTO = entity.toDTO(findById.get());
//            return findById;
            
            
         } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         return new ResponseEntity(HttpStatus.OK);
         
         
   }
   
   
   
   @GetMapping("/file-list") 
   public List<FileEntity> showFileList() {
     return fileRepository.findAll();
   }
   

   

//   @GetMapping("/file-download/{id}")
//	public void downloadFile(@PathVariable Long id, HttpServletResponse response) throws FileNotFoundException{
//		FileEntity file = fileRepository.findById(id).get();
//		response.setHeader("Content-Disposition", "attachment;filename=\""+file.getFilename()+"\";");
//		FileInputStream fis = new FileInputStream(file.getFilePath());
//		try {
//			OutputStream os = response.getOutputStream();
//			int readCount = 0;
//			byte[] buffer = new byte[1024];
//			while((readCount = fis.read(buffer)) != -1) {
//				os.write(buffer, 0, readCount);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
   
   @GetMapping("/file-download/{id}")
   public ResponseEntity<Resource> downloadFile(@PathVariable Long id) throws IOException {
     FileEntity fileEntity = fileRepository.findById(id).get();

     Path path = Paths.get(fileEntity.getFilePath());
     Resource resource = new InputStreamResource(Files.newInputStream((path)));

     HttpHeaders headers = new HttpHeaders();
     headers.setContentDisposition(ContentDisposition.builder("attachment")
                     .filename(fileEntity.getOriginalFilename(), StandardCharsets.UTF_8)
                     .build());
     headers.add(HttpHeaders.CONTENT_TYPE, "text/plain");

     return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);

   }
   
   
}